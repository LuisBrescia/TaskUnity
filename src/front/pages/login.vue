<script setup lang="ts">
definePageMeta({
  middleware: ['auth']
})
const email = ref('')
const password = ref('')
const isSignUp = ref(false)
const client = useSupabaseClient()

const signUp = async () => {
  const { data, error } = await client.auth.signUp({
    email: email.value,
    password: password.value
  })
  console.log('error', error)
}

const login = async () => {
  const { data, error } = await client.auth.signInWithPassword({
    email: email.value,
    password: password.value
  })
  console.log('user', user)
  console.log('error', error)
}

const user = useSupabaseUser()
onMounted(() =>{
  watchEffect(() => {
    if (user.value){
      navigateTo('/profile')
    }
  })
})

</script>


<template>
<main class="h-screen flex items-center justify-center">
<div>
  <form
  @submit.prevent="() => (isSignUp ? signUp() : login())"
  class="flex flex-col gap-2"
  >
    <input
    type="email"
    placeholder="Email"
    v-model="email"
    class="p-2 bg-gray-600 rounded"
    />
    <input
    type="password"
    placeholder="Senha"
    v-model="password"
    class="p-2 bg-gray-600 rounded"
    />
    <button type="submit" class="p-2 text-white bg-purple-500 rounded">
      <span v-if="isSignUp"> Cadastrar </span>
      <span v-else> Entrar </span>
    </button>
    </form>
    <button
    @click="isSignUp = !isSignUp"
    class="w-full mt-8 text-sm text-center underline text-slate-300"
    >
    <span v-if="isSignUp"> Já possui uma conta? Entre com seu usuário </span>
    <span v-else> Criar nova conta </span>
  </button>
</div>

</main>
</template>
