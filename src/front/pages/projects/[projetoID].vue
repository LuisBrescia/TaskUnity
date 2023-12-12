<template> 
    <main v-if="carregado" class="flex h-screen justify-between gap-5">
        <div class="m-5 mr-0">
            <DefaultCard class="p-5 m-5">
                <header class="font-bold text-4xl">Equipe</header>
            </DefaultCard>
        </div>

        <div class="m-5 mx-0">
            <DefaultCard class="p-5 m-5">
                <header class="font-bold text-4xl">{{ projeto.name }}</header>
            </DefaultCard>
        </div>

        <div class="m-5 ml-0">
            <DefaultCard class="p-5 m-5">
                <header class="font-bold text-4xl">Tarefas</header>
            </DefaultCard>
            <div class="flex overflow-hidden gap-5 m-5 flex-wrap">
                <DefaultCard v-for="tarefa in tarefas" :key="tarefa.id" class="p-5">
                    <header class="font-bold text-2xl">{{ tarefa.name }}</header>
                    <p class="text-lg">{{ tarefa.description }}</p>
                </DefaultCard>
            </div>
        </div>
    </main>
    <main v-else class="flex h-screen justify-center items-center">
        <div class="relative max-w-xl">
            <div class="animate-pulse rounded-full h-28 flex justify-center items-center" />
        </div>
    </main>

    <NuxtLink to="/projects">
        <div class="fixed bottom-0 right-0 m-5">
            <DefaultCard class="px-5 py-3">
                <header class="text-2xl">Voltar</header>
            </DefaultCard>
        </div>
    </NuxtLink>
</template>

<script setup>

const projeto = ref({});
const tarefas = ref({});
const route = useRoute();
const carregado = ref(false);

// const router = useRouter(); 

apiFetch(`/projects/${route.params.projetoID}`).then( (res) => {
    projeto.value = res.data;
    console.log("Projeto:", projeto.value);
    carregado.value = true;
})

apiFetch(`/tasks?project=${route.params.projetoID}`).then( (res) => {
    tarefas.value = res.data;
    console.log("Projeto:", projeto.value);
})

// colocar o layout do projeto aqui

definePageMeta({
    layout: 'empty'
})

</script>

<style scoped>
    main div {
        flex-basis: 33%;
        flex-grow: 1;
    }
</style>