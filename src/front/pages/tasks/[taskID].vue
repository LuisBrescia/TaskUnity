<template>
    <div class="flex mt-12 gap-12">
        <DefaultCard>
            <header class="text-2xl uppercase font-bold font-mono">Tarefa {{ taskID  }}</header>
            <ul class="my-5 text-lg">
                <li>ITEM</li>
                <li>ITEM</li>
                <li>ITEM</li>
                <li>ITEM</li>
            </ul>
            <section class="flex gap-5">
                <GreenButton>Finalizar Tarefa</GreenButton>
                <WhiteButton>Adicionar comentário</WhiteButton>
            </section>
        </DefaultCard>
    </div>
</template>

<script setup>

const { taskID } = useRoute().params;
/*
> const dadosTarefa = await TaskUnityApi.get(`/tasks/${taskId}`);
*/

definePageMeta({
    layout: 'dashboard'
})

</script>