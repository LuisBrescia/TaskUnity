<template>
    <DefaultCard>
      <header>
        <h2 class="text-4xl font-semibold tracking-tighter" style="padding: 20px;"> Olá, {{ user.name }}</h2>
        <DefaultCard class="overflow-auto w-full" style="min-width: 360px; height: 360px;">
                    <header>
                      <hr class="my-2 linha-colorida">
                      <h4 class="text-2xl">Nome: {{ user.name }}</h4>                     
                        <h4 class="text-2xl">ID: {{ user.id }}</h4>
                        <h4 class="text-2xl">Email: {{ user.email }}</h4>
                        <h4 class="text-2xl">Função: {{ user.userFunction }}</h4>
                        <hr class="my-2 linha-colorida">  
                    </header>
                </DefaultCard>
      </header>
      
    </DefaultCard> 
</template>

<script setup>
window.onload = loadUser()

definePageMeta({
  layout: 'dashboard'
})

var user = ref([]);

function loadUser(){
    console.log("Load users")
    apiFetch('/users/2')
    .then(res => {
        user.value = res.data;
        console.log(user.value);
    }).catch(err => {
        console.log(err)
    })
}

</script>