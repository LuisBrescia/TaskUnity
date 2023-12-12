<template>
    <main class="flex h-screen border justify-between gap-5">

        <div class="border m-5 mr-0">
            <DefaultCard class="p-5 m-5">
                <header class="font-bold text-4xl text-rainbow ">Equipe</header>
            </DefaultCard>
        </div>

        <div class="border m-5 mx-0">
            <DefaultCard class="p-5 m-5">
                <header class="font-bold text-4xl text-rainbow">{{ projeto.name }} ({{ projeto.id }})</header>
            </DefaultCard>
        </div>

        <div class="border m-5 ml-0">
            <DefaultCard class="p-5 m-5">
                <header class="font-bold text-4xl text-rainbow ">Tarefas</header>
            </DefaultCard>
            <div class="flex overflow-hidden gap-5 m-5 flex-wrap">
                <DefaultCard v-for="tarefa in tarefas" :key="tarefa.id" class="p-5">
                    <header class="font-bold text-2xl">{{ tarefa.name }}</header>
                    <p class="text-lg">{{ tarefa.description }}</p>
                </DefaultCard>
            </div>
        </div>

    </main>
</template>

<script setup>

const projeto = ref({});
const tarefas = ref({});
const route = useRoute();

// const router = useRouter(); 

apiFetch(`/projects/${route.params.projetoID}`).then( (res) => {
    projeto.value = res.data;
    console.log("Projeto:", projeto.value);
})

apiFetch(`/tasks?project=${route.params.projetoID}`).then( (res) => {
    tarefas.value = res.data;
    console.log("Projeto:", projeto.value);
})

</script>

<style scoped>
    main div {
        flex-basis: 33%;
        flex-grow: 1;
    }
</style>