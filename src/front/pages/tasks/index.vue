<template>
    <el-row>
        <el-col :span="16" :offset="4">
            <el-tabs tab-position="top" v-model="activeName" @tab-click="handleClick">
                <el-tab-pane label="Minhas Tarefas" name="myTasks">
                    <span>Quando tiver tarefas vinculadas a você, elas aparecerão aqui.</span>
                    <DefaultCard>
                        <nuxt-link to="/tasks/1">Logomarca empresa x</nuxt-link>
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

definePageMeta({
    layout: 'dashboard'
})

</script>