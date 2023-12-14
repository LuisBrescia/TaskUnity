<template>
    <main class="gap-5 justify-center">

        <header class="mx-auto text-center mb-5">Clique em um projeto para editá-lo</header>

        <!-- <div v-for="project in projects" :key="project.id">
            <NuxtLink :to="`/projects/${project.id}`" exact>
                <CardProject>
                    <template #title>
                        <h2 class="text-2xl font-semibold tracking-tighter">{{ project.name }}</h2>
                    </template>
                    <template #description>
                        <p>{{ project.description }}</p>
                    </template>
                </CardProject>
            </NuxtLink>
        </div> -->

        <section class="flex gap-5 flex-wrap w-full max-w-7xl mx-auto justify-center">
            <DefaultCard 
                class="flex-1 cursor-pointer overflow-auto p-5" 
                style="min-width: 24rem; height: 24rem;" 
                @click="abrirProjeto(project)"
                v-for="project in projects" :key="project.id"
            >
                <header>
                    <h2 class="font-semibold tracking-tighter">{{ project.name }}</h2>                       
                    <hr class="my-2 linha-colorida">
                    <!-- <h4 class="text-2xl">Criação: {{ project.startDate }}</h4> -->
                </header>
                <section class="text-base">
                    <p>{{  project.description  }}</p>
                </section>
                <!-- <p class="text-base">{{ project.description }}</p> -->
            </DefaultCard>
            <DefaultCard 
                v-for="i in 6 - projects.length" :key="i"
                class="flex-1 cursor-pointer relative p-5" 
                style="min-width: 24rem; height: 24rem; border-style: dashed;" 
                @click="dialogCriarProjeto = true"
            >
                <div class="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2">
                    <Icon name="carbon:add" size="5rem" />
                </div>
            </DefaultCard>
        </section>
    </main>

    <el-dialog v-model="dialogEditarProjeto" :title="`Deseja abrir o projeto ${projetoEditado.name}?`">
        <span>{{ projetoEditado.description }}</span>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="dialogEditarProjeto = false">Cancelar</el-button>
                <el-button type="primary" @click="router.push(`projects/${projetoEditado.id}`)">
                  Abrir
                </el-button>
            </span>
        </template>
    </el-dialog>

    <el-dialog v-model="dialogCriarProjeto" title="Criar projeto">
        <div>Nome:</div>
        <el-input v-model="modelNovoProjeto.name" placeholder="Nome do projeto" size="large" />

        <div class="mt-5">Descrição:</div>
        <el-input v-model="modelNovoProjeto.description" placeholder="Descrição do projeto" size="large" />
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="dialogCriarProjeto = false">Cancel</el-button>
                <el-button type="success" @click="criarProjeto" :loading="dialogButtonLoading">
                  Criar
                </el-button>
            </span>
        </template>
    </el-dialog>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js';

definePageMeta({
    layout: 'dashboard'
})

const dialogButtonLoading = ref(false);

const userStore = useUserStore();
const projects = ref(userStore.projects);
const router = useRouter();

const dialogCriarProjeto = ref(false);
const dialogEditarProjeto = ref(false);

const projetoEditado = ref({});

const modelNovoProjeto = ref({
    name: '',
    description: '',
    owner: userStore.info.id,
});

function criarProjeto() {
    dialogButtonLoading.value = true;
    apiFetch('/projects', {
        method: 'POST',
        body: {
            name: modelNovoProjeto.value.name,
            description: modelNovoProjeto.value.description,
            owner: modelNovoProjeto.value.owner,
        }
    }).then((response) => {
        if (response.status === 201) {
            
            userStore.projects.push(response.data);
            dialogCriarProjeto.value = false;
            dialogButtonLoading.value = false;

            ElNotification({
                title: 'Sucesso',
                message: 'Projeto criado com sucesso',
                type: 'success'
            });
        }
    });
}

function abrirProjeto(projeto) {
    projetoEditado.value = projeto; 
    dialogEditarProjeto.value = true;
}

</script>

<style lang="scss" scoped>

.edit #iconeNovoProjeto {
    opacity: 0.5;
}
.scroll-personalizado {
    scrollbar-color: #ffffff1a #ffffff1a;
    scrollbar-width: thin;
}

.scroll-personalizado::-webkit-scrollbar {
    width: 5px;
}

.scroll-personalizado::-webkit-scrollbar-track {
    background: #ffffff1a;
}

.scroll-personalizado::-webkit-scrollbar-thumb {
    background-color: #ffffff1a;
    border-radius: 20px;
    border: 3px solid #ffffff1a;
}

.scroll-personalizado::-webkit-scrollbar-thumb:hover {
    background-color: #ffffff1a;
}

.scroll-personalizado::-webkit-scrollbar-thumb:active {
    background-color: #ffffff1a;
}

</style>