<template>
    <main class="max-w-7xl mx-auto">
        <el-tabs tab-position="top" v-model="activeName" @tab-click="handleClick">
            <!-- <header class="text-center">Clique em uma tarefa para acessá-la</header> -->
            <el-tab-pane label="Minhas Tarefas" name="myTasks">
                <DefaultCard v-for="tarefa in tarefas" :key="tarefa.id" class="p-5 my-5 cursor-pointer w-1/2" @click="router.push(`tasks/${tarefa.id}`)">
                    <div class="border-l-4 pl-5 py-2 rounded-sm" :class="{ 'border-green-500' : tarefa.link, 'border-red-500' : !tarefa.link  }">
                        <header class="w-fit font-bold">
                            {{ tarefa.name }}
                        </header>
                        <div class="text-base font-thin">{{ tarefa.description }}</div>
                        <div class="text-base font-thin">Projeto: {{ tarefa.project }}</div>
                    </div>
                </DefaultCard>
            </el-tab-pane>
            <el-tab-pane label="Procurar uma tarefa" name="searchTasks">
                <DefaultCard 
                    v-for="tarefa in tarefasPublicas" :key="tarefa.id" 
                    class="p-5 my-5 cursor-pointer w-1/2" 
                    @click="router.push(`tasks/${tarefa.id}`)"
                >
                    <div class="border-l-4 pl-5 py-2 rounded-sm border-purple-500">
                        <header class="w-fit font-bold">
                            {{ tarefa.name }}
                        </header>
                        <div class="text-base font-thin">{{ tarefa.description }}</div>
                        <div class="text-base font-thin">Projeto: {{ tarefa.project }}</div>
                    </div>
                </DefaultCard>
            </el-tab-pane>
            <el-tab-pane label="Cadidaturas Pendentes" name="pendingTasks">
                <span>Tarefas a quais usuario se candidatou</span>
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

const tarefasPublicas = ref({})

apiFetch('/tasks?public=true').then(res => {
    tarefasPublicas.value = res.data;
})

const handleClick = (tab, event) => {
    console.log(tab, event);
};

</script>