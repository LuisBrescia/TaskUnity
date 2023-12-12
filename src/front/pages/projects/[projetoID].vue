<template>
    <main v-if="carregado" class="flex h-screen justify-center gap-5 py-12">
        <el-card shadow="never" class="box-card">
            <template #header>
                <div class="card-header">
                    <span>{{ projeto.name }}</span>
                    <el-button type="danger" @click="deletarProjeto" :icon="ElIconDelete">Deletar projeto</el-button>
                </div>
            </template>
            <el-button class="button" plain>Operation button</el-button>
            <template #footer>Footer content</template>
        </el-card>

        <el-card shadow="never" class="box-card">
            <template #header>
                <div class="card-header">
                    <span>Tarefa</span>
                    <el-button type="success" @click="dialogCriarTarefa = true" :icon="ElIconPlus">Adicionar tarefa</el-button>
                </div>
            </template>
            <div v-for="tarefa in tarefas" :key="tarefa.id" class="text item">{{ 'List item ' + tarefa.name }}</div>
            <template #footer>Footer content</template>
        </el-card>
        
    </main>
    <main v-else class="flex h-screen justify-center items-center">
        <div class="relative max-w-xl w-full">
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

    <el-dialog v-model="dialogCriarTarefa" title="Criar tarefa">
        <div>Nome:</div>
        <el-input v-model="modelNovaTarefa.name" placeholder="Nome da tarefa" size="large" />

        <div class="mt-5">Descrição:</div>
        <el-input v-model="modelNovaTarefa.description" placeholder="Descrição da tarefa" size="large" />

        <div class="mt-5">Atribuição:</div>
        <el-select size="large">
            <el-option
                v-for="projeto in userStore.projects"
                :key="projeto.id"
                :label="projeto.name"
                :value="projeto.id"
            />
        </el-select>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="dialogCriarTarefa = false">Cancel</el-button>
                <el-button type="success" @click="criarTarefa">
                  Criar
                </el-button>
            </span>
        </template>
    </el-dialog>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js'

const userStore = useUserStore();
const projeto = ref({});
const tarefas = ref({});
const route = useRoute();
const router = useRouter();
const carregado = ref(false);

const dialogCriarTarefa = ref(false);
const modelNovaTarefa = ref({
    name: '',
    completed: false,
    project: route.params.projetoID,
    tasker: null
})

projeto.value = userStore.projects.find(projeto => projeto.id == route.params.projetoID);

apiFetch(`/tasks?project=${route.params.projetoID}`).then((res) => {
    tarefas.value = res.data;
    console.log("Projeto:", projeto.value);
    carregado.value = true;
})

function deletarProjeto() {
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

function criarTarefa() {
    apiFetch('/tasks', {
        method: 'POST',
        body: {
            name: modelNovaTarefa.value.name,
            completed: modelNovaTarefa.value.completed,
            project: modelNovaTarefa.value.project,
            tasker: modelNovaTarefa.value.tasker
        }
    }).then((res) => {
        if (res.status == 201) {
            tarefas.value.push(res.data);
            dialogCriarTarefa.value = false;
            ElNotification({
                title: 'Sucesso',
                message: 'Tarefa criada com sucesso',
                type: 'success'
            });
        }
    })
}

definePageMeta({
    layout: 'empty'
})

</script>

<style scoped>
/* main div {
    flex-basis: 50%;
    flex-grow: 1;
} */

.card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.text {
    font-size: 14px;
}

.item {
    margin-bottom: 18px;
}

.box-card {
    width: 480px;
}

</style>