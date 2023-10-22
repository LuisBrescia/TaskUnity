<script setup>
definePageMeta({
    layout: 'dashboard'
})
</script>

<template>
    <main>
        <form action="/">
            <FormInput name="nome">Nome da Equipe</FormInput><br>
            <FormInput name="descricao">Descrição</FormInput><br>
            <WhiteButton>Criar Equipe</WhiteButton>
        </form>
    </main>
</template>

<style scoped>
main {
    display: flex;
}
</style>