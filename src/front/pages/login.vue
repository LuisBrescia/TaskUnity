<template>
  <main class="flex justify-center ">
    <section id="formulario" class="flex flex-col p-10 relative overflow-hidden">
      <NuxtLink to="/">
        <header class="flex-1 text-4xl font-black tracking-tight text-neutral-50 cursor-pointer text-border font-sans flex items-center">
          <span>TASK</span>
          <span class="text-transparent tracking-normal">UNITY</span>
        </header>
      </NuxtLink>
      <article class="mt-12">
        <div class="text-2xl font-bold">Crie uma conta e começe agora mesmo!</div>
        <div class="text-lg">
          Já cadastrado na plataforma? <NuxtLink to="/login" class="text-rainbow">Entre com sua conta.</NuxtLink>
        </div>
      </article>
      <div class="my-12">
        <InputText value="Nome" />
        <InputText value="Email" type="email" />
        <InputText value="Senha" type="password" />
      </div>

      <NuxtLink to="/profile">
        <WhiteButton class="w-full">
          Criar Conta
        </WhiteButton>
      </NuxtLink>
    
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
  </main>
</template>

<script setup>

apiFetch('/users', { mode: 'no-cors' }).then(res => console.log(res))

</script>

<style scoped>
main {
  min-height: 100vh;
}

#formulario {
  max-width: 40rem;
  width: 100%;
  border-right: 2px solid #ffffff1a;
  border-left: 2px solid #ffffff1a;
  transition: filter .3s ease-in-out, border-color .3s ease-in-out;
}

#formulario:hover {
  border-color: rgba(255, 255, 255, 0.2)
}

#espacoVazio {
  background-color: black;
}

</style>
