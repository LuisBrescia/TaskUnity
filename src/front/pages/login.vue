<template>
  <main class="overflow-hidden flex justify-center items-center">
    <div class="relative max-w-xl w-11/12">
      <DefaultCard class="p-12">
        <NuxtLink to="/">
          <header class="text-4xl font-black tracking-tight text-neutral-50 cursor-pointer text-border font-sans flex items-center">
            <span>TASK</span>
            <span class="text-transparent tracking-normal">UNITY</span>
          </header>
        </NuxtLink>

        <article class="mt-12" v-if="modo == 'cadastrar'">
          <div class="text-2xl font-bold">Crie uma conta e começe agora mesmo!</div>
          <div class="text-lg">
            Já cadastrado na plataforma? <span @click="changeModo" class="cursor-pointer text-rainbow link">Entre com sua conta.</span>
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
          <InputText value="Senha" type="password" v-model="formData.password" @keypress.enter="submitForm" />
          <InputText 
            value="Email" 
            type="email" 
            v-model="formData.email"  
            :class="modo == 'entrar' ? 'opacity-0' : ''"
            :disabled="modo == 'entrar'"
          />
          <div class="text-sm text-end">
            <span class="opacity-0">.</span>
            <span :class="{ 'text-green-500': success, 'text-red-500': !success  }">{{ status }}</span>
          </div>
        </div>

        <WhiteButton class="w-full" @click="criarConta" v-if="modo == 'cadastrar'">
          Criar Conta
        </WhiteButton>
        <WhiteButton class="w-full" @click="entrar" v-else>
          Entrar
        </WhiteButton>  
      </DefaultCard>
      <!-- <RedBlob class="left-3/4 bottom-2/4 animate-ping"/>
      <RedBlob class="left-3/4 bottom-2/4 animate-spin"/>
      <YellowBlob class="animate-ping" style="top: 65%; left: 60%;" />
      <YellowBlob class="animate-spin" style="top: 65%; left: 60%;" />
      <GreenBlob class="animate-ping" style="bottom: 65%; right: 60%;" />
      <GreenBlob class="animate-spin" style="bottom: 65%; right: 60%;" />
      <BlueBlob class="right-3/4 top-2/4 animate-ping"/>
      <BlueBlob class="right-3/4 top-2/4 animate-spin"/> -->
    </div>
  </main>
</template>

<script setup>

const route = useRoute();
const router = useRouter();
const modo = ref(route.query.modo);

const status = ref('')
const success = ref(false)

const formData = ref({
  name: '',
  password: '',
  email: ''
})

function criarConta() {

  success.value = false

  if (formData.value.name.length < 4 ) {
    status.value = 'Nome deve conter ao menos 4 caracteres'
    return
  } 

  if (formData.value.password.length < 8) {
    status.value = 'Senha deve conter ao menos 8 caracteres'
    return
  }

  if (formData.value.email.length < 10) {
    status.value = 'Email inválido'
    return
  }

  apiFetch('/users', {
    method: 'POST',
    body: {
      name: formData.value.name,
      password: formData.value.password,
      email: formData.value.email
    }
  })
  .then((res) => {
    success.value = true 
    if (res.status == 201) {
      status.value = 'Conta criada com sucesso'
    } 
  }).catch((err) => {
    success.value = false
    if (err.status == 409) {
      status.value = 'Já existe um usuário com esse nome'
    } else if (err.status == 400) {
      status.value = 'Preencha todos os campos'
    }
  })
}

function entrar() {
  apiFetch('/auth', {
    method: 'POST',
    body: {
      name: formData.value.name,
      password: formData.value.password
    }
  }).then((res) => {
    success.value = true
    if (res.status == 202) {
      router.push('/projects');
    } else {
      status.value = res.data
    }
  }).catch((err) => {
    success.value = false
    if (err.status == 401) {
      status.value = 'Senha incorreta'
    } else if (err.status == 404) {
      status.value = 'Usuário não encontrado'
    } else {
      status.value = 'Erro desconhecido'
    }
  })
}

function submitForm() {
  if (modo.value == 'cadastrar') {
    criarConta()
  } else {
    entrar()
  }
}

function changeModo() {
  if (modo.value == 'cadastrar') {
    modo.value = 'entrar'
  } else {
    modo.value = 'cadastrar'
  }
  status.value = ''
}

</script>

<style scoped>
main {
  min-height: 100svh;
}
</style>
