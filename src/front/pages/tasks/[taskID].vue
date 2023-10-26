<template>
    <div class="flex mt-12 gap-12">

        <DefaultCard>


            <header>Tarefa {{ taskID  }}</header>


            <section>
                <WhiteButton>Finzalizar Tarefa</WhiteButton>
                <WhiteButton>Adiciovar comentário</WhiteButton>
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