<template>
    <el-row>
        <el-col :span="20" :offset="2">
            <el-tabs tab-position="top" v-model="activeName" @tab-click="handleClick">
                <el-tab-pane label="Minhas Tarefas" name="myTasks">
                    
                    <DefaultCard v-for="tarefa in tarefas" :key="tarefa.id" class="p-5 my-5">
                        <div>Id: {{ tarefa.id  }}</div>
                        <div>Nome: {{ tarefa.name  }}</div>
                        <div>Descrição: {{ tarefa.description  }}</div>
                        <div>Status: {{ tarefa.completed ? "Completa" : "Em andamento" }}</div>
                        <div>Projeto: {{ tarefa.project  }}</div>
                        <div>User responsável: {{ tarefa.tasker  }}</div>

                        <NuxtLink :to="`/tasks/${tarefa.id}`" class="flex justify-end">
                            <BlueButton>Acessar Task</BlueButton>
                        </NuxtLink>

                    </DefaultCard>

                </el-tab-pane>

                <el-tab-pane label="Procurar uma tarefa" name="searchTasks">
                    <span>Procurar uma tarefa</span>
                </el-tab-pane>

                <el-tab-pane label="Cadidaturas Pendentes" name="pendingTasks">
                    <span>Candidaturas Pendentes</span>
                </el-tab-pane>
            </el-tabs>
        </el-col>
    </el-row>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js';

definePageMeta({
    layout: 'dashboard'
})

const userStore = useUserStore();
const activeName = ref('myTasks');
const tarefas = ref({})
tarefas.value = userStore.tasks;

const handleClick = (tab, event) => {
    console.log(tab, event);
};

</script>