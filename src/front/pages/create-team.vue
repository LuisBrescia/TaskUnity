<script setup>
definePageMeta({
    layout: 'dashboard'
})
</script>

<template>
    <main style="display: flex;">
        <form action="/" class="form">
            <FormInput name="nome">Nome da Equipe</FormInput>
            <TextAreaInput>Descrição</TextAreaInput>
            <div>
                <label class="label">Membros</label>
                <div class="members">
                    <TaskerFormCard name="Membro 1" role="Developer"></TaskerFormCard>
                    <TaskerFormCard name="Membro 2" role="Developer"></TaskerFormCard>
                    <TaskerFormCard name="Membro 3" role="Designer"></TaskerFormCard>
                    <TaskerFormCard name="Membro 4" role="Designer"></TaskerFormCard>
                    <TaskerFormCard name="Membro 5" role="Designer"></TaskerFormCard>
                    <WhiteButton>
                        <Icon name="tdesign:add" />
                    </WhiteButton>
                </div>
            </div>
            <NuxtLink to="/contratar-freelancer">
                <BlueButton>Buscar Taskers</BlueButton>
            </NuxtLink>
            <NuxtLink to="/profile">
                <WhiteButton>Criar Equipe</WhiteButton>
            </NuxtLink>
        </form>
    </main>
</template>

<style scoped>
.form {
    display: flex;
    flex-direction: column;
    gap: 20px;
}

.members {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    gap: 10px;
}
</style>