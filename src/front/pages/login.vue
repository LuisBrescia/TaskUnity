<template>
  <main class="flex justify-center items-center">
    <DefaultCard class="overflow-hidden max-w-xl relative w-11/12 h-full">
      <section class="flex flex-col p-8 h-full">
        <NuxtLink to="/">
          <header class="flex-1 text-4xl font-black tracking-tight text-neutral-50 cursor-pointer text-border font-sans flex items-center">
            <span>TASK</span>
            <span class="text-transparent tracking-normal">UNITY</span>
          </header>
        </NuxtLink>

        <article class="mt-12" v-if="modo == 'cadastrar'">
          <div class="text-2xl font-bold">Crie uma conta e começe agora mesmo!</div>
          <div class="text-lg">
            Já cadastrado na plataforma? <span @click="changeModo" class="cursor-pointer text-rainbow">Entre com sua conta.</span>
          </div>
        </article>
        <article class="mt-12" v-else>
          <div class="text-2xl font-bold">Insira seu usuário e senha!</div>
          <div class="text-lg">
            Ainda não cadastrado? <span @click="changeModo" class="cursor-pointer text-rainbow">Crie uma conta.</span>
          </div>
        </article>

        <div class="my-12">
          <InputText value="Nome" v-model="formData.nome" />
          <InputText value="Senha" type="password" v-model="formData.senha" />
          <InputText value="Email" type="email" v-if="modo == 'cadastrar'" />
          <InputText class="opacity-0" disabled="true" v-else />
          <div class="text-sm">
            <span class="font-black">STATUS:&nbsp;</span>
            <span class="text-red-500">{{ status }}</span>
          </div>
        </div>

        <WhiteButton class="w-full" @click="criarConta" v-if="modo == 'cadastrar'">
          Criar Conta
        </WhiteButton>
        <WhiteButton class="w-full" @click="entrar" v-else>
          Entrar
        </WhiteButton>
      
        <div style="filter: brightness(0.75); z-index: -9999;" class="absolute w-full h-full">
          <RedBlob class="left-3/4 bottom-2/4 animate-ping"/>
          <RedBlob class="left-3/4 bottom-2/4 animate-spin"/>
          <YellowBlob class="animate-ping" style="top: 65%; left: 55%;" />
          <YellowBlob class="animate-spin" style="top: 65%; left: 55%;" />
          <GreenBlob class="animate-ping" style="bottom: 65%; right: 55%;" />
          <GreenBlob class="animate-spin" style="bottom: 65%; right: 55%;" />
          <BlueBlob class="right-3/4 top-2/4 animate-ping"/>
          <BlueBlob class="right-3/4 top-2/4 animate-spin"/>
        </div>
      </section>
    </DefaultCard>
  </main>
</template>

<script setup>

const route = useRoute();
const modo = ref(route.query.modo);

const status = ref('')

const formData = ref({
  nome: null,
  senha: null
})

const router = useRouter();

function criarConta() {
  apiFetch('/users', {
    method: 'POST',
    body: {
      name: formData.value.nome,
      email: formData.value.email,
      password: formData.value.password
    }
  })
  .then((res) => {
    console.log(res)

    if (res.status == 200) {
      router.push('/profile');
    } else {
      status.value = res.data
    }

  }).catch((err) => {
    console.log(err)
  })
}

function entrar() {
  console.log('Enviando', formData.value)
  apiFetch('/auth', {
    method: 'POST',
    body: {
      name: formData.value.nome,
      password: formData.value.senha
    }
  }).then((res) => {
    console.log(res)
    if (res.data == 'token') {
      router.push('/profile');
    } else {
      status.value = res.data
    }
  }).catch((err) => {
    console.log(err)
  })
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
