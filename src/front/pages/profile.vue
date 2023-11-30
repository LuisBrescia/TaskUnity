<template>
    <DefaultCard class="p-5">
      <header class="text-4xl font-semibold tracking-tighter">
        Olá, {{ user.name }}
      </header>
        <hr class="my-2 linha-colorida">
        <h4 class="text-2xl">Nome: {{ user.name }}</h4>                     
        <h4 class="text-2xl">ID: {{ user.id }}</h4>
        <h4 class="text-2xl">Email: {{ user.email }}</h4>
        <h4 class="text-2xl">Função: {{ user.userFunction }}</h4>
    </DefaultCard> 
</template>

<script setup>

definePageMeta({
  layout: 'dashboard'
})

const user = ref({});

apiFetch('/users/3').then(res => {
    user.value = res.data;
    console.log(user.value);
}).catch(err => {
    console.log(err)
})

</script>