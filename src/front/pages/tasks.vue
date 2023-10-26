<template>

    <el-container>
        <el-tabs tab-position="top" type="border-card" v-model="activeName" @tab-click="handleClick">
            
            <el-tab-pane label="Minhas Tarefas" name="myTasks">
                <span>Quando tiver tarefas vinculadas a você, elas aparecerão aqui.</span>
            </el-tab-pane>

            <el-tab-pane label="Procurar uma tarefa" name="searchTasks">
                <span>Procurar uma tarefa</span>
            </el-tab-pane>

            <el-tab-pane label="Cadidaturas Pendentes" name="pendingTasks">
                <span>Candidaturas Pendentes</span>
            </el-tab-pane>

        </el-tabs>
    </el-container>

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

<style scoped>
span {
    color: black;
}
</style>
