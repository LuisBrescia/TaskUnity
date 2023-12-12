<template> 
    <main v-if="carregado" class="flex h-screen justify-between gap-5">
        <div class="m-5 mx-0">
            <DefaultCard class="p-5 m-5">
                <header class="font-bold text-4xl">{{ projeto.name }}</header>
            </DefaultCard>
            <el-button type="danger" class="m-5" @click="deletarProjeto">Deletar</el-button>
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

import { useUserStore } from '@/stores/userStore.js'

const userStore = useUserStore();
const projeto = ref({});
// const projeto = ref(userStore.projects.find(projeto => projeto.id == route.params.projetoID));
const tarefas = ref({});
const route = useRoute();
const router = useRouter();
const carregado = ref(false);

projeto.value = userStore.projects.find(projeto => projeto.id == route.params.projetoID);

// apiFetch(`/projects/${route.params.projetoID}`).then( (res) => {
//     projeto.value = res.data;
//     console.log("Projeto:", projeto.value);
//     carregado.value = true;
// })

apiFetch(`/tasks?project=${route.params.projetoID}`).then( (res) => {
    tarefas.value = res.data;
    console.log("Projeto:", projeto.value);
    carregado.value = true;
})

function deletarProjeto() {
    // apiFetch(`/projects/${route.params.projetoID}`, {
    //     method: 'DELETE'
    // }).then((res) => {
    //     console.log("Projeto deletado:", res.data);
        
    //     router.push('/projects');
    // })
    ElMessageBox.confirm('Tem certeza que deseja deletar este projeto?', 'Aviso', {
        confirmButtonText: 'Sim',
        cancelButtonText: 'Não',
        type: 'warning'
    }).then(() => {
        carregado.value = false;
        apiFetch(`/projects/${route.params.projetoID}`, {
            method: 'DELETE'
        }).then((res) => {
            console.log("Projeto deletado:", res.data);
            router.push('/projects');
            userStore.projects = userStore.projects.filter(projeto => projeto.id != route.params.projetoID);
        })
    }).catch(() => {
        ElNotification({
            title: 'Aviso',
            message: 'Projeto não foi deletado',
            type: 'info'
        });
    })
}

definePageMeta({
    layout: 'empty'
})

</script>

<style scoped>
    main div {
        flex-basis: 50%;
        flex-grow: 1;
    }
</style>