<template>
  <div class="h-screen max-w-2xl flex justify-center items-center mx-auto">
    <DefaultCard class="p-5 mx-auto w-full">
      <header class="text-4xl font-semibold tracking-tighter flex justify-between items-center">
        Dados do usuário
        <WhiteButton @click="editarDados">
          <Icon name="carbon:edit" size="1.5rem" color="inherit" />
        </WhiteButton>
      </header>
        <hr class="my-5 linha-colorida">
        <h4 class="text-2xl">ID: {{ user.id }}</h4>
        <h4 class="text-2xl">Nome: {{ user.name }}</h4>                     
        <h4 class="text-2xl">Email: {{ user.email }}</h4>
        <h4 class="text-2xl">Função: {{ user.userFunction }}</h4>
        <WhiteButton class="mt-5 w-full" @click="alteraSenha">Alterar senha</WhiteButton>
    </DefaultCard> 
  </div>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js';

definePageMeta({
  layout: 'dashboard'
})

const userStore = useUserStore();
const user = ref(userStore.info);

const alteraSenha = () => {
  console.log("Alterar senha");
}

</script>