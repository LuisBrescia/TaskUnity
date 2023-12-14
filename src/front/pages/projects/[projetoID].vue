<template>
    <NuxtLink to="/projects">
        <div class="fixed bottom-0 right-0 m-5 backdrop-brightness-50 rounded-custom">
            <DefaultCard class="px-5 py-3">
                <header class="text-2xl">Voltar</header>
            </DefaultCard>
        </div>
    </NuxtLink>

    <main v-if="!carregado" class="flex h-screen justify-center items-center">
        <div class="relative max-w-xl w-full">
            <div class="animate-pulse rounded-full h-28 flex justify-center items-center" />
        </div>
    </main>

    <main v-else class="flex justify-center h-screen gap-5 py-12">
        <DefaultCard class="p-5 w-96 h-fit">
            <header class="flex justify-between">
                <span>{{ projeto.name }}</span>
                <el-button type="info" text circle @click="abrirDialogEditarProjeto" :icon="ElIconTools" />
            </header>
        
            <hr class="mt-2 mb-5 linha-colorida">
            
            <p class="text-base">
                <div class="text-lg font-bold">Progresso:</div>
                <div>
                    <Icon name="material-symbols:done" color="green" /> Completas: {{ tarefasCompletas.length }}
                </div>
                <div> 
                    <Icon name="material-symbols:clock-loader-10" color="yellow" />  Em análise: {{ tarefasEmAnalise.length }}
                </div>
                <div> 
                    <Icon name="material-symbols:close" color="red" />  Incompletas: {{ tarefasIncompletas.length }}
                </div>
            </p>

            <DefaultCard class="text-base mt-5 p-3">
                <small class="font-bold">Descrição:</small>
                <p class="font-thin">{{ projeto.description }}</p>
            </DefaultCard>
        </DefaultCard>

        <DefaultCard class="p-5 h-fit" style="min-width: 846px;">
            <header class="flex justify-between">
                <span>Tarefas</span>
                <el-button type="success" text circle @click="abrirDialogTarefa" :icon="ElIconPlus" />
            </header>

            <hr class="mt-2 mb-5 linha-colorida">

            <div 
                v-for="(tarefa, idx) in tarefas" 
                :key="tarefa.id" 
                class="mb-5 border-l-2 rounded-sm pl-3 py-2 pr-0 flex gap-5" 
                :class="{ 
                    'border-green-500': tarefa.completed === true, 
                    'border-yellow-500': tarefa.completed === false, 
                    'border-red-500': tarefa.completed === null 
                }"
            >
                <section class="w-96">
                    <div class="text-lg flex justify-between items-center">
                        <span>{{ tarefa.name }}</span>
                        <el-button type="primary" plain circle @click="abrirDialogTarefa(tarefa, idx)" :icon="ElIconEdit" />
                    </div>
                    <div class="text-base flex justify-between items-center my-2">
                        <span>{{ tarefa.description }}</span>
                        <el-button type="primary" plain circle :icon="ElIconEdit" class="opacity-0" />
                    </div>
                </section>
                <section class="w-96">
                    <div class="text-lg flex justify-between items-center">
                        <span>{{ tarefa.tasker ? getTasker(tarefa.tasker).name : "Não atribuída" }}</span>  
                        <el-button type="info" plain round :icon="ElIconSwitch">
                            <span>Alterar</span>
                        </el-button>
                    </div>
                    <div class="text-base flex justify-between items-center my-2">
                        <a :href="tarefa.link" target="_blank">
                            <span v-if="tarefa.link" class="underline cursor-pointer text-rainbow link">Link para tarefa completa</span>
                        </a> 
                        <el-button v-if="tarefa.link" type="success" plain round :icon="ElIconCheck">
                            <span>Aceitar</span>
                        </el-button>  
                    </div>
                </section>
            </div>
            <span v-if="tarefas.length == 0" class="text-lg">Este projeto ainda não possui tarefas</span>
        </DefaultCard>
    </main>

    <el-dialog v-model="dialogEditarProjeto" title="Configurações do projeto">

        <div>Nome:</div>
        <el-input v-model="projetoCopia.name" placeholder="Nome do projeto" size="large" />

        <div class="mt-5">Descrição:</div>
        <el-input v-model="projetoCopia.description" type="textarea" placeholder="Descrição do projeto" size="large" />

        <div class="mt-5">Ferramentas:</div>
        <el-input v-model="projetoCopia.tools" placeholder="Ferramentas utilizadas" size="large" />

        <template #footer>
            <span class="dialog-footer flex justify-between">
                <el-button type="danger" @click="deletarProjeto" :icon="ElIconDelete" :loading="dialogButtonLoading2">
                  Deletar Projeto
                </el-button>
                <div>
                    <el-button @click="dialogEditarProjeto = false">Cancelar</el-button>
                    <el-button type="primary" @click="editarProjetoSubmit" :loading="dialogButtonLoading">
                        Salvar
                    </el-button>
                </div>
            </span>
        </template>
    </el-dialog>

    <el-dialog v-model="dialogTarefa" :title="`${modelTarefa.id ? 'Editar' : 'Adicionar'} tarefa`">
        <div>Nome:</div>
        <el-input v-model="modelTarefa.name" placeholder="Nome da tarefa" size="large" />

        <div class="mt-5">Descrição:</div>
        <el-input v-model="modelTarefa.description" type="textarea" placeholder="Descrição da tarefa" size="large" />

        <div class="mt-5">Atribuição:</div>
        <el-select v-model="modelTarefa.atribuicao" size="large">
            <el-option
                v-for="atribuicao in atribuicoes"
                :key="atribuicao.value"
                :label="atribuicao.label"
                :value="atribuicao.value"
            />
        </el-select>
        <template #footer>
            <el-row class="dialog-footer" justify="space-between">
                <div>
                    <el-button 
                        type="danger" 
                        plain 
                        v-show="modelTarefa.id" 
                        :icon="ElIconDelete" 
                        @click="deletarTarefa" 
                        :loading="dialogButtonLoading2"
                    >
                        Deletar Tarefa
                    </el-button>
                </div>
                <div>
                    <el-button @click="dialogTarefa = false">Cancel</el-button>
                    <el-button type="primary" @click="salvarTarefa" :loading="dialogButtonLoading">
                        Salvar
                    </el-button>
                </div>
            </el-row>
        </template>
    </el-dialog>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js'

const route = useRoute();
const router = useRouter();
const userStore = useUserStore();
const carregado = ref(false);

const dialogButtonLoading = ref(false);
const dialogButtonLoading2 = ref(false);

const tarefas = ref({});
apiFetch(`/tasks?project=${route.params.projetoID}`).then((res) => {
    tarefas.value = res.data;
    carregado.value = true;
})

const dialogTarefa = ref(false);
const modelTarefa = ref({})
const posicaoTarefa = ref(0);

const atribuicoes = [
  {
    value: 'public',
    label: 'Compartilhar ao público',
  },
  {
    value: 'someone',
    label: 'Selecionar um tasker',
  },
  {
    value: 'self',
    label: 'Atribuir tarefa a mim',
  }
]

function getTasker(taskerID) {
    return userStore.users.find(user => user.id == taskerID);
}

function abrirDialogTarefa(tarefa = {}, idx = 0) {
    modelTarefa.value = {...tarefa};
    posicaoTarefa.value = idx;
    dialogTarefa.value = true;
    console.log("Tarefa:", tarefa);
}

const tarefasCompletas = computed(() => {
  return tarefas.value.filter(tarefa => tarefa.completed)
})

const tarefasEmAnalise = computed(() => {
  return tarefas.value.filter(tarefa => !tarefa.completed && tarefa.link )
})

const tarefasIncompletas = computed(() => {
    return tarefas.value.filter(tarefa => !tarefa.completed && !tarefa.link)
})

function salvarTarefa() {

    dialogButtonLoading.value = true;
    modelTarefa.value.project = route.params.projetoID;

    if (modelTarefa.value.atribuicao == 'self') 
        modelTarefa.value.tasker = userStore.info.id;

    if (modelTarefa.value.id == undefined) {
        apiFetch('/tasks', {
            method: 'POST',
            body: modelTarefa.value
        }).then((res) => {
            dialogTarefa.value = false;
            dialogButtonLoading.value = false;
            tarefas.value.push(res.data);
            ElNotification({
                title: 'Sucesso',
                message: 'Tarefa criada com sucesso',
                type: 'success'
            });
            if (modelTarefa.value.atribuicao == 'self' || modelTarefa.value.tasker == userStore.info.id) {
                if (userStore.tasks.find(tarefa => tarefa.id == modelTarefa.value.id) == undefined) {
                    userStore.tasks.push(res.data);
                }
                userStore.tasks = userStore.tasks.map(tarefa => {
                    if (tarefa.id == modelTarefa.value.id) {
                        return res.data;
                    } else {
                        return tarefa;
                    }
                })
            }
        })
    } else {
        apiFetch(`/tasks/${modelTarefa.value.id}`, {
            method: 'PUT',
            body: modelTarefa.value
        }).then((res) => {
            tarefas.value[posicaoTarefa.value] = res.data;
            dialogTarefa.value = false;
            dialogButtonLoading.value = false;
            ElNotification({
                title: 'Sucesso',
                message: 'Tarefa editada com sucesso',
                type: 'success'
            });
            if (modelTarefa.value.atribuicao == 'self' || modelTarefa.value.tasker == userStore.info.id) {
                if (userStore.tasks.find(tarefa => tarefa.id == modelTarefa.value.id) == undefined) {
                    userStore.tasks.push(res.data);
                }
                userStore.tasks = userStore.tasks.map(tarefa => {
                    if (tarefa.id == modelTarefa.value.id) {
                        return res.data;
                    } else {
                        return tarefa;
                    }
                })
            }
        })
    }
}

function deletarTarefa() {
    ElMessageBox.confirm('Tem certeza que deseja deletar esta tarefa?', 'Aviso', {
        confirmButtonText: 'Sim',
        cancelButtonText: 'Não',
        type: 'warning'
    }).then(() => {
        dialogButtonLoading2.value = true;
        apiFetch(`/tasks/${modelTarefa.value.id}`, {
            method: 'DELETE'
        }).then((res) => {
            dialogButtonLoading2.value = false;
            tarefas.value.splice(posicaoTarefa.value, 1);
            userStore.tasks = userStore.tasks.filter(tarefa => tarefa.id != modelTarefa.value.id);
            dialogTarefa.value = false;
            ElNotification({
                title: 'Sucesso',
                message: 'Tarefa deletada com sucesso',
                type: 'success'
            });
        })
    }).catch(() => {
        ElNotification({
            title: 'Aviso',
            message: 'Exclusão cancelada',
            type: 'info'
        });
    })
}

const projeto = ref({});
projeto.value = userStore.projects.find(projeto => projeto.id == route.params.projetoID);

const projetoCopia = ref({});
const dialogEditarProjeto = ref(false);

function abrirDialogEditarProjeto() {
    projetoCopia.value = {...projeto.value};
    dialogEditarProjeto.value = true;
}

function editarProjetoSubmit() {
    dialogButtonLoading.value = true;
    apiFetch(`/projects/${route.params.projetoID}`, {
        method: 'PUT',
        body: projetoCopia.value
    }).then((res) => {
        dialogButtonLoading.value = false;
        dialogEditarProjeto.value = false;
        projeto.value = res.data;
        userStore.projects = userStore.projects.map(projeto => {
            if (projeto.id == route.params.projetoID) {
                return res.data;
            } else {
                return projeto;
            }
        })
        ElNotification({
            title: 'Sucesso',
            message: 'Projeto editado com sucesso',
            type: 'success'
        });
    })
}

function deletarProjeto() {
    ElMessageBox.confirm('Tem certeza que deseja deletar este projeto?', 'Aviso', {
        confirmButtonText: 'Sim',
        cancelButtonText: 'Não',
        type: 'warning'
    }).then(() => {
        carregado.value = false;
        dialogEditarProjeto.value = false;
        apiFetch(`/projects/${route.params.projetoID}`, {
            method: 'DELETE'
        }).then((res) => {
            console.log("Projeto deletado:", res.data);
            router.push('/projects');
            userStore.projects = userStore.projects.filter(projeto => projeto.id != route.params.projetoID);
            ElNotification({
                title: 'Sucesso',
                message: 'Projeto deletado com sucesso',
                type: 'success'
            });
        })
    }).catch(() => {
        ElNotification({
            title: 'Aviso',
            message: 'Exclusão cancelada',
            type: 'info'
        });
    })
}

</script>

<style scoped>
.card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.box-card {
    width: 500px;
}

</style>