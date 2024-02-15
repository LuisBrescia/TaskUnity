<template>
    <main class="max-w-7xl mx-auto">
        <el-tabs tab-position="top" v-model="activeName" @tab-click="handleClick">
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
                <DefaultCard v-if="tarefas.length == 0" class="p-5 my-5 cursor-pointer w-1/2 afterglow" @click="activeName = 'searchTasks'">
                    <div class="border-l-4 pl-5 py-2 rounded-sm border-blue-500">
                        <header class="w-fit font-bold">
                            Procurar Tarefa
                        </header>
                        <div class="text-base font-thin">
                            Encontre outras tarefas na seção de procurar uma tarefa <br/>
                            Clique aqui e seja redirecionado
                        </div>
                    </div>
                </DefaultCard>
            </el-tab-pane>
            <el-tab-pane label="Procurar uma tarefa" name="searchTasks">
                <DefaultCard 
                    v-for="tarefa in tarefasPublicas" :key="tarefa.id" 
                    class="p-5 my-5 w-1/2" 
                >
                    <div class="border-l-4 pl-5 py-2 rounded-sm border-purple-500">
                        <header class="w-fit font-bold">
                            {{ tarefa.name }}
                        </header>
                        <div class="text-base font-thin">{{ tarefa.description }}</div>
                        <div class="text-base font-thin">Projeto: {{ tarefa.project }}</div>
                        <el-row type="flex" justify="end">
                            <el-button type="primary" class="mt-5" :loading="dialogButtonLoading" @click="abrirDialogEnviarCandidatura(tarefa)">
                                Enviar candidatura
                            </el-button>
                        </el-row>
                    </div>
                </DefaultCard>
            </el-tab-pane>
            <el-tab-pane label="Cadidaturas Pendentes" name="pendingTasks">
                <DefaultCard v-for="candidatura in candidaturasPendentes" :key="candidatura.id" class="p-5 my-5 w-1/2">
                    <div class="border-l-4 pl-5 py-2 rounded-sm border-lime-500">
                        <div class="text-base">Esperando resposta de</div> 
                        <header class="w-fit font-bold">
                            {{ getUser(candidatura.owner)?.name }}
                        </header>
                        <div class="text-base font-thin">{{ candidatura.message }}</div>
                        <el-row type="flex" justify="end">
                            <el-button type="danger" class="mt-5" :loading="dialogButtonLoading" @click="cancelarCandidatura(candidatura)">
                                Cancelar
                            </el-button>
                        </el-row>
                    </div>
                </DefaultCard>
                <DefaultCard v-if="candidaturasPendentes.length == 0" class="p-5 my-5 cursor-pointer w-1/2 afterglow" @click="activeName = 'searchTasks'">
                    <div class="border-l-4 pl-5 py-2 rounded-sm border-blue-500">
                        <header class="w-fit font-bold">
                            Procurar Tarefa
                        </header>
                        <div class="text-base font-thin">
                            Encontre outras tarefas na seção de procurar uma tarefa <br/>
                            Clique aqui e seja redirecionado
                        </div>
                    </div>
                </DefaultCard>
            </el-tab-pane>
        </el-tabs>
    </main>

    <el-dialog v-model="dialogEnviarCandidatura" :title="`Enviar candidatura para a tarefa: ${tarefaSelecionada.name}`">

        <span>Escreva uma mensagem para {{ getUser(tarefaSelecionadaProject.owner).name }}:</span>
        <el-input v-model="conviteCandidatura.message" type="textarea" placeholder="Escreva uma mensagem" />

        <template #footer>
            <el-button @click="dialogEnviarCandidatura = false">Cancelar</el-button>
            <el-button type="primary" @click="enviarCandidatura" :loading="dialogButtonLoading">Enviar</el-button>
        </template>
    </el-dialog>

</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js';

definePageMeta({
    layout: 'dashboard'
})

const router = useRouter();
const userStore = useUserStore();
const activeName = ref('myTasks');
const dialogButtonLoading = ref(false);

const tarefas = ref({})
tarefas.value = userStore.tasks || {}; 

const tarefasPublicas = ref({})

const candidaturasPendentes = computed(() => {
    if (userStore.convites) {
        return userStore.convites.filter(convite => convite.tipo == 'candidatura');
    }
    return {};
})

apiFetch('/tasks?public=true').then(res => {
    tarefasPublicas.value = res.data;
})

const dialogEnviarCandidatura = ref(false);
const tarefaSelecionada = ref({});

const conviteCandidatura = ref({})
const tarefaSelecionadaProject = ref({});

function abrirDialogEnviarCandidatura(tarefa) {
    dialogButtonLoading.value = true;

    apiFetch(`/projects/${tarefa.project}`).then(res => {

        dialogButtonLoading.value = false;
        dialogEnviarCandidatura.value = true;
        
        tarefaSelecionadaProject.value = res.data;
        tarefaSelecionada.value = tarefa;

        conviteCandidatura.value = {
            task: tarefa.id,
            tasker: userStore.info.id,
            owner: tarefaSelecionadaProject.value.owner,
            message: null,
            tipo: 'candidatura'
        }
    })
}

function enviarCandidatura() {

    dialogButtonLoading.value = true;

    if (userStore.convites.some(convite => convite.task === tarefaSelecionada.value.id)) {
        ElMessage({
            message: 'Você já se candidatou para essa tarefa',
            type: 'error'
        })
        dialogButtonLoading.value = false;
        return;
    }

    if (conviteCandidatura.value.message.length < 10) {
        ElMessage({
            message: 'Escreva uma mensagem com pelo menos 10 caracteres',
            type: 'error'
        })
        dialogButtonLoading.value = false;
        return;
    }

    apiFetch(`/convites`, {
        method: 'POST',
        body: conviteCandidatura.value
    }).then(res => {
        ElMessage({
            message: 'Candidatura enviada com sucesso',
            type: 'success'
        })
        dialogButtonLoading.value = false;
        dialogEnviarCandidatura.value = false;
        userStore.convites.push(res.data);
    }).catch(() => {
        ElMessage({
            message: 'Erro ao enviar candidatura',
            type: 'error'
        })
    })
}

function cancelarCandidatura(candidatura) {
    ElMessageBox.confirm('Tem certeza que deseja cancelar essa candidatura?', 'Atenção', {
        confirmButtonText: 'Sim',
        cancelButtonText: 'Não',
        type: 'warning'
    }).then(() => {
        dialogButtonLoading.value = true;
        apiFetch(`/convites/${candidatura.id}`, {
            method: 'DELETE'
        }).then(() => {
            ElMessage({
                message: 'Candidatura cancelada com sucesso',
                type: 'success'
            })
            dialogButtonLoading.value = false;
            userStore.convites = userStore.convites.filter(convite => convite.id !== candidatura.id);
        }).catch(() => {
            ElMessage({
                message: 'Erro ao cancelar candidatura',
                type: 'error'
            })
        })
    }).catch(() => {
        ElMessage({
            message: 'Operação cancelada',
            type: 'info'
        })
    })
}

function getUser(id) {
    return userStore.users.find(user => user.id == id) || {};
}

const handleClick = (tab, event) => {
    console.log(tab, event);
};

</script>