<template>

    <!-- Colocar uma seta no canto superior esquerdo para voltar para tasks -->
    <NuxtLink class="w-10 h-10" to="/tasks">
        <!-- Seta virada para esquerda -->
        <Icon name="material-symbols:arrow-back-ios-rounded" size="2.5rem" />
    </NuxtLink>

    <div class="flex mt-12 gap-12">
        <DefaultCard class="p-5">
            <header class="text-2xl uppercase font-bold">{{ tarefa.name }} ({{ tarefa.id  }})</header>
            <div class="text-base">
                Status: {{ tarefa.completed ? "Tarefa Completa" : "Tarefa nao completa" }}
            </div>

            <div class="text-base mt-5">
                <span class="text-lg font-bold text-neutral-300">Dados do projeto:</span>
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
    </div>
</template>

<script setup>

definePageMeta({
    layout: 'dashboard'
})

const route = useRoute();
const tarefa = ref([]);

const tarefaProjeto = ref([]);
const tarefaTasker = ref([]);

function alteraStatus() {
    tarefa.value.completed = !tarefa.value.completed;
    apiFetch(`/tasks/${tarefa.value.id}`, {
        method: 'PUT',
        body: {
            name: tarefa.value.name,
            completed: tarefa.value.completed,
            project: tarefa.value.project,
            tasker: tarefa.value.tasker
        }
    })
        .then(res => {
            console.log(res)
        }).catch(err => {
            console.log(err)
        })
}

apiFetch(`/tasks/${route.params.taskID}`)
    .then(res => {
        tarefa.value = res.data;
        console.log(tarefa.value)

        apiFetch(`/projects/${tarefa.value.project}`)
            .then(res => {
                tarefaProjeto.value = res.data;
                console.log(tarefaProjeto.value)
            }).catch(err => {
                console.log(err)
            })

        apiFetch(`/users/${tarefa.value.tasker}`)
            .then(res => {
                tarefaTasker.value = res.data;
                console.log(tarefaTasker.value)
            }).catch(err => {
                console.log(err)
            })

    }).catch(err => {
        console.log(err)
    })

</script>