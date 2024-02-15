<template>
  <main v-if="!onLoading" class="flex flex-col justify-center items-center">
    <DefaultAlert class="max-w-xl w-11/12" type="warning" description="Estimativa de 2 minutos." message="Aviso" />
    <DefaultCard class="my-3 p-12 max-w-xl w-11/12 afterglow">
      <NuxtLink to="/">
        <header
          class="text-4xl font-black tracking-tight text-neutral-50 cursor-pointer text-border font-sans flex items-center">
          <span>TASK</span>
          <span class="text-transparent tracking-normal">UNITY</span>
        </header>
      </NuxtLink>

      <article class="mt-12" v-if="modo == 'cadastrar'">
        <div class="text-2xl font-bold">Crie uma conta e começe agora mesmo!</div>
        <div class="text-lg">
          Já cadastrado na plataforma? <span @click="changeModo" class="cursor-pointer text-rainbow link">Entre com sua
            conta.</span>
        </div>
      </article>
      <article class="mt-12" v-else>
        <div class="text-2xl font-bold">Bem vindo de volta!</div>
        <div class="text-lg">
          Ainda não cadastrado? <span @click="changeModo" class="cursor-pointer text-rainbow link">Crie uma conta.</span>
        </div>
      </article>

      <div class="my-12" style="transition: all 0.5s ease !important">
        <InputText value="Nome" v-model="formData.name" />
        <InputText value="Senha" type="password" v-model="formData.password"
          @keypress.enter="modo == 'cadastrar' ? criarConta() : entrar()" />
        <InputText value="Email" type="email" v-model="formData.email" :class="modo == 'entrar' ? 'opacity-0' : ''"
          :disabled="modo == 'entrar'" />
        <div class="text-sm text-end">
          <span class="opacity-0">.</span>
          <span :class="{ 'text-green-500': success, 'text-red-500': !success }">{{ status }}</span>
        </div>
      </div>

      <WhiteButton class="w-full" @click="criarConta" v-if="modo == 'cadastrar'">
        Criar Conta
      </WhiteButton>
      <WhiteButton class="w-full" @click="entrar" v-else>
        Entrar
      </WhiteButton>
      <!-- <div class="flex justify-end mt-3 me-2">
        <span class="text-rainbow cursor-pointer text-xs">Esqueci minha senha</span>
      </div> -->
    </DefaultCard>
  </main>
  <main v-else class="flex h-screen justify-center items-center">
    <div class="relative max-w-xl w-full">
      <div class="animate-pulse rounded-full h-28 flex justify-center items-center w-full" />
    </div>
  </main>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js';

const userStore = useUserStore();
const route = useRoute();
const router = useRouter();
const modo = ref(route.query.modo);
const status = ref('')
const success = ref(false)
const onLoading = ref(false)
const formData = ref({
  name: '',
  password: '',
  email: ''
})

function validarCampo(campo, comprimentoMinimo, mensagemErro) {
  if (campo.length < comprimentoMinimo) {
    status.value = mensagemErro;
    throw new Error('Validação falhou');
  }
}

async function criarConta() {

  success.value = false;
  validarCampo(formData.value.name, 4, 'Nome deve conter ao menos 4 caracteres');
  validarCampo(formData.value.password, 8, 'Senha deve conter ao menos 8 caracteres');
  validarCampo(formData.value.email, 10, 'Email inválido');
  status.value = '';

  try {
    const res = await apiFetch('/users', {
      method: 'POST',
      body: formData.value
    });

    userStore.setInfo(res.data);
    success.value = true;
    status.value = 'Conta criada com sucesso';
    router.push('/projects');


    setTimeout(() => {
      onLoading.value = true;
    }, 1000);
    
    const usersRes = await apiFetch(`/users`);

    userStore.setProjects([]);
    userStore.setTasks([]);
    userStore.setUsers(usersRes.data);
    userStore.setConvites([]);

  } catch (err) {
    success.value = false;
    if (err.status === 409)
      status.value = 'Já existe um usuário com esse nome';
    else if (err.status === 400)
      status.value = 'Preencha todos os campos';
      else if (err.code === 'ECONNREFUSED') 
      status.value = 'Servidor indisponível, tente novamente mais tarde';
    else if (err.code === 'ETIMEDOUT') 
      status.value = 'Tempo limite de conexão excedido';
    else
      status.value = 'Erro desconhecido';
    
    console.log(err);
  }
}

async function entrar() {
  try {
    const res = await apiFetch('/auth', {
      method: 'POST',
      body: formData.value
    });

    success.value = true;
    status.value = 'Logado com sucesso';
    userStore.setInfo(res.data);

    setTimeout(() => {
      onLoading.value = true;
    }, 1000);

    const [projectsRes, tasksRes, usersRes, conviteRes] = await Promise.all([
      apiFetch(`/projects?owner=${res.data.id}`),
      apiFetch(`/tasks?tasker=${res.data.id}`),
      apiFetch(`/users`),
      apiFetch(`/convites?tasker=${res.data.id}`)
    ]);

    userStore.setProjects(projectsRes.data);
    userStore.setTasks(tasksRes.data);
    userStore.setUsers(usersRes.data);
    userStore.setConvites(conviteRes.data);
    router.push('/projects');
  } catch (err) {
    success.value = false
    if (err.status == 401)
      status.value = 'Senha incorreta'
    else if (err.status == 404)
      status.value = 'Usuário não encontrado'
    else
      status.value = 'Erro desconhecido'
  }
}

function changeModo() {
  modo.value = modo.value == 'cadastrar' ? 'entrar' : 'cadastrar'
  status.value = ''
}

</script>

<style scoped>
main {
  min-height: 100svh;
  transition: all 0.5s ease;
}
</style>
