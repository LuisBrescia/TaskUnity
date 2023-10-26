<template>
  <main class="h-screen flex items-center justify-center">
    <div>
      <form @submit.prevent="() => (isSignUp ? signUp() : login())" class="flex flex-col gap-2">
        <input type="email" placeholder="Email" v-model="email" class="p-2 bg-gray-600 rounded" />
        <input type="password" placeholder="Senha" v-model="password" class="p-2 bg-gray-600 rounded" />
        <button type="submit" class="p-2 text-white bg-green-500 rounded">
          <span v-if="isSignUp"> Sign Up </span>
          <span v-else> Log in </span>
        </button>
      </form>
      <button @click="isSignUp = !isSignUp" class="w-full mt-8 text-sm text-center underline text-slate-300">
        <span v-if="isSignUp"> Já possui uma conta? Entre com seu usuário </span>
        <span v-else> Criar nova conta </span>
      </button>
    </div>

  </main>
</template>

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
onMounted(() => {
  watchEffect(() => {
    if (user.value) {
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
    <button type="submit" class="p-2 text-white bg-green-500 rounded">
      <span v-if="isSignUp"> Cadastrat </span>
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

<style scoped>
.main {
  position: relative;
  display: flex;
  flex-direction: column;
  background-color: #240046;
  max-height: 420px;
  overflow: hidden;
  border-radius: 12px;
  box-shadow: 7px 7px 10px 3px #24004628;
}

.form {
  display: flex;
  flex-direction: column;
  gap: 14px;
  padding: 7px;
}

/*checkbox to switch from sign up to login*/
#chk {
  display: none;
}

/*Login*/
.login {
  position: relative;
  width: 100%;
  height: 100%;
}

.login label {
  margin: 25% 0 5%;
}

label {
  color: #fff;
  font-size: 2rem;
  justify-content: center;
  display: flex;
  font-weight: bold;
  cursor: pointer;
  transition: .5s ease-in-out;
}

.input {
  width: 100%;
  height: 40px;
  background: #e0dede;
  padding: 10px;
  border: none;
  outline: none;
  border-radius: 4px;
}

/*Register*/
.register {
  background: #eee;
  border-radius: 60% / 10%;
  transform: translateY(5%);
  transition: .8s ease-in-out;
}

.register label {
  color: #573b8a;
  transform: scale(.6);
}

#chk:checked~.register {
  transform: translateY(-60%);
}

#chk:checked~.register label {
  transform: scale(1);
  margin: 10% 0 5%;
}

#chk:checked~.login label {
  transform: scale(.6);
  margin: 5% 0 5%;
}

/*Button*/
.form button {
  width: 85%;
  height: 40px;
  margin: 12px auto 10%;
  color: #fff;
  background: #573b8a;
  font-size: 1rem;
  font-weight: bold;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: .2s ease-in;
}

.form button:hover {
  background-color: #6d44b8;
}
</style>