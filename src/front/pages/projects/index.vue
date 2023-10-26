<template>
    <main class="flex gap-5 mt-5">

<<<<<<< HEAD:src/front/pages/projects.vue
        <CardProject>
            <template #title>
                <h2 class="text-2xl font-semibold tracking-tighter>Título do Projeto">Título do projeto</h2>
            </template>
            <template #description>
                <p>25/10/2023</p>
            </template>
        </CardProject>
        <!-- <Card3D linkParaProjeto="/desenvolvimento">
=======
        <!-- > Aqui terá um v-for percorrendo os projetos daquele usuário -->
        <Card3D linkParaProjeto="/projects/1">
>>>>>>> 5989834e581aa6af3f554c84b8785575c80a0283:src/front/pages/projects/index.vue
            <template #title>
                <h2>Título do Projeto</h2>
            </template>
            <template #description>
                <p>Este projeto está aqui apenas por motivos de testes, tanto esta tela quantas as outras ainda estão em
                    fase de desenvolvimento</p>
            </template>
        </Card3D> -->

<<<<<<< HEAD:src/front/pages/projects.vue

        <DefaultCard class="relative" style="width: 252px; border-style: dashed;">
=======
        <DefaultCard class="relative" style="width: 300px; border-style: dashed;">
>>>>>>> 5989834e581aa6af3f554c84b8785575c80a0283:src/front/pages/projects/index.vue
            
            <div class="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2">
                <Icon name="carbon:add" size="5rem" />
            </div>
        </DefaultCard>
    </main>
</template>

<script setup>

definePageMeta({
    layout: 'dashboard'
})

</script>