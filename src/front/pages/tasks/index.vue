<template>
    <el-row>
        <el-col :span="20" :offset="2">
            <el-tabs tab-position="top" v-model="activeName" @tab-click="handleClick">
                <el-tab-pane label="Minhas Tarefas" name="myTasks">
                    
                    <DefaultCard v-for="tarefa in tarefas" :key="tarefa.id" class="p-5 my-5">
                        <div>ID: {{ tarefa.id  }}</div>
                        <div>NOME: {{ tarefa.name  }}</div>
                        <div>Status: {{ tarefa.completed  }}</div>
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

const activeName = ref('myTasks');

const handleClick = (tab, event) => {
    console.log(tab, event);
};

const tarefas = ref({})

apiFetch('/tasks').then((res) => {
    tarefas.value = res.data
}).catch((err) => {
    console.log(err)
})

definePageMeta({
    layout: 'dashboard'
})

</script>