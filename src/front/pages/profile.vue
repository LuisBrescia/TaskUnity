<script setup lang="ts">

definePageMeta({
    layout: 'dashboard',
    middleware: ['auth']
})


const user = useSupabaseUser()
onMounted(() =>{
  watchEffect(() => {
    if (!user.value){
      navigateTo('/login')
    }
  })
})

</script>

<template>
    Resto da página Profile.  
</template>