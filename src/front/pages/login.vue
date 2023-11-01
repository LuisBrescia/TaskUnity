<template>
  <section class="max-w-xl mx-auto flex items-center">
    <DefaultCard class="w-full">

      <h1>Login</h1>

      <TextInput label="Email" inputType="email" inputName="email" required="false"/>

      <TextInput label="Senha" inputType="password" inputName="password" required="false" />

      <NuxtLink to="/profile">
        <BlueButton>Entrar</BlueButton>
      </NuxtLink>

    </DefaultCard>
  </section>
</template>

<script setup>
</script>

<style scoped>
section {
  min-height: 100vh;
}
</style>
