<template>
    <main class="max-w-7xl mx-auto">
        <el-tabs tab-position="top" v-model="activeName" @tab-click="handleClick">
            <!-- <header class="text-center">Clique em uma tarefa para acessá-la</header> -->
            <el-tab-pane label="Minhas Tarefas" name="myTasks">
                <DefaultCard v-for="tarefa in tarefas" :key="tarefa.id" class="p-5 my-5 cursor-pointer" @click="router.push(`tasks/${tarefa.id}`)">
                    <div>{{ tarefa.name }}</div>
                    <hr class="my-2 linha-colorida">
                    <div>{{ tarefa.description }}</div>
                    <div>Status: {{ tarefa.completed ? "Completa" : "Em andamento" }}</div>
                    <div>Projeto: {{ tarefa.project }}</div>
                    <div>User responsável: {{ tarefa.tasker }}</div>
                </DefaultCard>
            </el-tab-pane>
            <el-tab-pane label="Procurar uma tarefa" name="searchTasks">
                <span>Procurar uma tarefa</span>
            </el-tab-pane>
            <el-tab-pane label="Cadidaturas Pendentes" name="pendingTasks">
                <span>Candidaturas Pendentes</span>
            </el-tab-pane>
        </el-tabs>
    </main>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js';

definePageMeta({
    layout: 'dashboard'
})

const router = useRouter();

const userStore = useUserStore();
const activeName = ref('myTasks');
const tarefas = ref({})
tarefas.value = userStore.tasks;

const handleClick = (tab, event) => {
    console.log(tab, event);
};

</script>