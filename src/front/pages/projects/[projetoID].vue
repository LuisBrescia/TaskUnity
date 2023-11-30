<template>
    <div class="flex mt-12 gap-12">

        <DefaultCard v-if="projeto">

            <header class="text-3xl font-semibold tracking-tighter">Dados do projeto</header>

            <main class="my-12">
                <section class="mb-5">
                    <div class="text-sm font-thin text-neutral-500 tracking-widest">Nome</div>
                    <div class="text-xl font-normal">{{ projeto.name }}</div>
                </section>

                <section class="mb-5">
                    <div class="text-sm font-thin text-neutral-500 tracking-widest">Data de início</div>
                    <div class="text-xl font-normal">{{ projeto.startDate }}</div>
                </section>

                <section class="mb-5">
                    <div class="text-sm font-thin text-neutral-500 tracking-widest">Descrição</div>
                    <div class="text-xl font-normal max-w-md">{{ projeto.description }}</div>
                </section>

                <BlueButton class="rounded-xl" v-if="!editing" @click="saveEditedProject(projeto.id)">
                    <Icon name="material-symbols:edit" size="1.25rem" />
                </BlueButton>

                <RedButton class="rounded-xl" @click="deleteProject(projeto.id)">
                    <Icon name="material-symbols:delete" size="1.25rem" />
                </RedButton>
            </main>

        </DefaultCard>

        <DefaultCard>

            <header class="text-3xl font-semibold tracking-tighter">Tarefas</header>

            <main class="flex flex-col">
                <ul class="my-12">
                    <li class="flex justify-between items-center mb-5 gap-8">
                        <div class="text-xl font-mono">Tarefa 1</div>
                        <div class="flex gap-2">
                            <BlueButton class="rounded-xl">
                                <Icon name="material-symbols:edit" size="1.25rem" />
                            </BlueButton>
                            <RedButton class="rounded-xl">
                                <Icon name="material-symbols:delete" size="1.25rem" />
                            </RedButton>
                        </div>
                    </li>

                    <li class="flex justify-between items-center mb-5 gap-8">
                        <div class="text-xl font-mono">Tarefa 2</div>
                        <div class="flex gap-2">
                            <BlueButton class="rounded-xl">
                                <Icon name="material-symbols:edit" size="1.25rem" />
                            </BlueButton>
                            <RedButton class="rounded-xl">
                                <Icon name="material-symbols:delete" size="1.25rem" />
                            </RedButton>
                        </div>
                    </li>

                    <li class="flex justify-between items-center mb-5 gap-8">
                        <div class="text-xl font-mono">Tarefa 3</div>
                        <div class="flex gap-2">
                            <BlueButton class="rounded-xl">
                                <Icon name="material-symbols:edit" size="1.25rem" />
                            </BlueButton>
                            <RedButton class="rounded-xl">
                                <Icon name="material-symbols:delete" size="1.25rem" />
                            </RedButton>
                        </div>
                    </li>
                </ul>

                <WhiteButton>
                    <Icon name="carbon:task-add" size="1.5rem" class="mr-2" />
                    <span>Criar tarefa</span>
                </WhiteButton>

            </main>

        </DefaultCard>


    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';

const projeto = ref(null);

onMounted(async () => {
    const { params } = useRoute();

    const projectId = params.projetoID;

    try {
        const response = await fetch(`http://localhost:8080/projects/${projectId}`);
        const data = await response.json();
        projeto.value = data;
    } catch (error) {
        console.error('Erro ao obter dados do projeto:', error);
    }
});

const deleteProject = async (projectId) => {
    try {
        const response = await fetch(`http://localhost:8080/projects/${projectId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        if (response.ok) {
            console.log('Projeto excluído com sucesso!');
        } else {
            console.error('Erro ao excluir o projeto:', response.statusText);
        }
    } catch (error) {
        console.error('Erro ao excluir o projeto:', error);
    }
};

const saveEditedProject = async () => {
    try {
        const response = await fetch(`http://localhost:8080/projects/${projeto.value.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                name: 'Novo Nome',
                description: 'Nova Descrição',
                tools: 'Nova ferramenta'
            }),
        });

        if (response.ok) {
            console.log('Projeto editado com sucesso!');
            editing.value = false;
        } else {
            console.error('Erro ao editar o projeto:', response.statusText);
        }
    } catch (error) {
        console.error('Erro ao editar o projeto:', error);
    }
};

definePageMeta({
    layout: 'dashboard'
});

</script>