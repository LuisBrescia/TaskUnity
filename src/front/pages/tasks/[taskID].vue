<template>
    <NuxtLink to="/tasks">
        <div class="fixed bottom-0 right-0 m-5 backdrop-brightness-50 rounded-custom">
            <DefaultCard class="px-5 py-3">
                <header class="text-2xl">Voltar</header>
            </DefaultCard>
        </div>
    </NuxtLink>

    <!-- <div class="flex mt-12 gap-12">
        <DefaultCard class="p-5">
            <header class="text-2xl uppercase font-bold">{{ tarefa.name }} ({{ tarefa.id  }})</header>
            <p class="text-base mt-5">{{ tarefa.description }}</p>
            <div class="text-base">
                Status: {{ tarefa.completed ? "Tarefa Completa" : "Tarefa nao completa" }}
            </div>

            <div class="text-base mt-5">
                <span class="text-lg font-bold text-neutral-300">Dados do usuario:</span>
                <ul>
                    <li>
                        ID : {{ tarefaTasker.id }}
                    </li>
                    <li>
                        NOME : {{ tarefaTasker.name }}
                    </li>
                    <li>
                        EMAIL : {{ tarefaTasker.email }}
                    </li>
                    <li>
                        SENHA : {{ tarefaTasker.password}}
                    </li>
                    <li>
                        USERFUNCTION : {{ tarefaTasker.userFunction }}
                    </li>
                </ul>
            </div>

            <div class="text-base mt-5">
                <span class="text-lg font-bold text-neutral-300">Dados do projeto:</span>
                <ul>
                    <li>
                        ID : {{ tarefaProjeto.id }}
                    </li>
                    <li>
                        NOME : {{ tarefaProjeto.name }}
                    </li>
                    <li>
                        DESCRICAO : {{ tarefaProjeto.description }}
                    </li>
                    <li>
                        TOOLS : {{ tarefaProjeto.tools }}
                    </li>
                    <li>
                        DATA DE INICIO : {{ tarefaProjeto.startDate }}
                    </li>
                </ul>
            </div>

            <section class="flex gap-5 mt-12">
                <GreenButton @click="alteraStatus" v-if="!tarefa.completed">Finalizar Tarefa</GreenButton>
                <RedButton @click="alteraStatus" v-else>Cancelar</RedButton>
                <WhiteButton>Adicionar comentário</WhiteButton>
            </section>
        </DefaultCard> 
    </div> -->
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js';

const userStore = useUserStore();
const route = useRoute();

console.log(route.params.taskID)

const tarefa = ref({});
tarefa.value = userStore.tasks.find(task => task.id == route.value.params.taskID);

console.log("Valor da tarefa", tarefa.value)

// const tarefaTasker = ref({});
// tarefaTasker.value = userStore.info;

// const tarefaProjeto = ref({});

// function alteraStatus() {
//     tarefa.value.completed = !tarefa.value.completed;
//     apiFetch(`/tasks/${tarefa.value.id}`, {
//         method: 'PUT',
//         body: tarefa.value
//     })
//         .then(res => {
//             console.log(res)
//             userStore.tasks = userStore.tasks.map(task => {
//                 if (task.id == tarefa.value.id) {
//                     return tarefa.value;
//                 }
//                 return task;
//             })
//         }).catch(err => {
//             console.log(err)
//         })
// }

// apiFetch(`/projects/${tarefa.value.project}`)
//         .then(res => {
//             tarefaProjeto.value = res.data;
//             console.log("Tarefas daquele projeto", tarefaProjeto.value)
//         }).catch(err => {
//             console.log(err)
//         })


</script>