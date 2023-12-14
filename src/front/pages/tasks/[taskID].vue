<template>
    <NuxtLink to="/tasks">
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
        <DefaultCard class="p-5 w-custom-scoped h-fit">

            <header class="flex justify-between mb-5 font-black">
                <span>{{ tarefa.name }}</span>
                <el-button type="info" text circle @click="dialogTarefaInfo = true" :icon="ElIconTools" />
            </header>

            <InputText value="Link da tarefa completa:" v-model="tarefa.link" />

            <el-row justify="end">
                <el-button type="success" :icon="ElIconLink" @click="enviarTarefa" :loading="dialogButtonLoading">
                    Enviar para análise
                </el-button>
            </el-row>
            
        </DefaultCard>
        <div class="flex flex-col gap-5">

            <DefaultCard class="p-5 w-96 h-fit">
                <header class="flex justify-between mb-5 font-black">
                    <span>Descrição</span>
                </header>
                <p class="font-thin text-base text-rainbow">{{ tarefa.description }}</p>
            </DefaultCard>

            <DefaultCard class="p-5 w-96 h-fit">
                <header class="flex justify-between mb-5 font-black">
                    <span>Info</span>
                </header>
                <article class="mb-5">
                    <span class="text-base text-neutral-300">Projeto</span>
                    <div>{{ projeto?.name }}</div>
                </article>
                <article>
                    <span class="text-base text-neutral-300">Dono</span>
                    <div>{{ owner?.name }}</div>
                </article>
            </DefaultCard>
        </div>
    </main>

    <el-dialog v-model="dialogTarefaInfo" title="Info" width="30%">
        <el-row justify="end">
            <el-button type="danger" @click="desistirTarefa">Desistir da tarefa</el-button>
        </el-row>
    </el-dialog>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js';

const route = useRoute();
const router = useRouter();
const userStore = useUserStore();
const dialogTarefaInfo = ref(false);
const dialogButtonLoading = ref(false);
const carregado = ref(false);

const tarefa = ref({});
tarefa.value = userStore.tasks.find(task => task.id == route.params.taskID);

const projeto = ref({});
const owner = ref({});

apiFetch(`/projects/${tarefa.value.project}`).then(res => {
    projeto.value = res.data;
    console.log(projeto.value);
    carregado.value = true;
    owner.value = userStore.users.find(user => user.id == projeto.value.owner);
})

function desistirTarefa() {
    ElMessageBox.confirm('Tem certeza que deseja desistir da tarefa?', 'Atenção', {
        confirmButtonText: 'Sim',
        cancelButtonText: 'Não',
        type: 'warning'
    }).then(() => {
        tarefa.value.tasker = null;
        dialogButtonLoading.value = true;
        apiFetch(`/tasks/${tarefa.value.id}`, {
            method: 'PUT',
            body: tarefa.value
        }).then(res => {
            dialogTarefaInfo.value = false;
            userStore.tasks = userStore.tasks.filter(task => task.id != tarefa.value.id);
            router.push('/tasks');
        })
    }).catch(() => {
        ElMessage({
            type: 'info',
            message: 'Operação cancelada'
        });          
    });
}

function enviarTarefa() {
    dialogButtonLoading.value = true;
    apiFetch(`/tasks/${tarefa.value.id}`, {
        method: 'PUT',
        body: tarefa.value
    }).then(res => {

        dialogButtonLoading.value = false;
    
        ElNotification({
            title: 'Sucesso',
            message: 'Tarefa enviada para análise',
            type: 'success'
        });

        userStore.tasks = userStore.tasks.map(task => {
            if (task.id == tarefa.value.id) 
                return res.data;
            else
                return task;
        })
    })
}

</script>

<style scoped>

.w-custom-scoped {
    width: 48rem;
}

</style>