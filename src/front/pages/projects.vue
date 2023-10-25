<template>
    <main class="flex gap-5 mt-5">
        <Card3D linkParaProjeto="/desenvolvimento">
            <template #title>
                <h2>Título do Projeto</h2>
            </template>
            <template #description>
                <p>Este projeto está aqui apenas por motivos de testes, tanto esta tela quantas as outras ainda estão em
                    fase de desenvolvimento</p>
            </template>
        </Card3D>


        <DefaultCard class="relative" style="width: 300px; border-style: dashed;">
            
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