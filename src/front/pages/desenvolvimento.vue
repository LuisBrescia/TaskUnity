<template>
    <div class="flex mt-12 gap-12">

        <DefaultCard>

            <header class="text-3xl font-semibold tracking-tighter">Dados do projeto</header>

            <main class="my-12">
                <section class="mb-5">
                    <div class="text-sm font-thin text-neutral-500 tracking-widest">Nome</div>
                    <div class="text-xl font-normal">Projeto 1</div>
                </section>

                <section class="mb-5">
                    <div class="text-sm font-thin text-neutral-500 tracking-widest">Data de início</div>
                    <div class="text-xl font-normal">22/10/2023</div>
                </section>

                <section class="mb-5">
                    <div class="text-sm font-thin text-neutral-500 tracking-widest">Descrição</div>
                    <div class="text-xl font-normal max-w-md">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis eveniet
                        et, quaerat corporis aliquam laborum vero earum incidunt hic praesentium?
                    </div>
                </section>
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
                            <Icon name="material-symbols:edit" size="1.25rem"/>
                        </BlueButton>
                        <RedButton class="rounded-xl">
                            <Icon name="material-symbols:delete" size="1.25rem"/>
                        </RedButton>
                    </div>
                </li>

                <li class="flex justify-between items-center mb-5 gap-8">
                    <div class="text-xl font-mono">Tarefa 2</div>
                    <div class="flex gap-2">
                        <BlueButton class="rounded-xl">
                            <Icon name="material-symbols:edit" size="1.25rem"/>
                        </BlueButton>
                        <RedButton class="rounded-xl">
                            <Icon name="material-symbols:delete" size="1.25rem"/>
                        </RedButton>
                    </div>
                </li>

                <li class="flex justify-between items-center mb-5 gap-8">
                    <div class="text-xl font-mono">Tarefa 3</div>
                    <div class="flex gap-2">
                        <BlueButton class="rounded-xl">
                            <Icon name="material-symbols:edit" size="1.25rem"/>
                        </BlueButton>
                        <RedButton class="rounded-xl">
                            <Icon name="material-symbols:delete" size="1.25rem"/>
                        </RedButton>
                    </div>
                </li>
            </ul>
            
            <WhiteButton @click="showModalTask = true">
                <Icon name="carbon:task-add" size="1.5rem" class="mr-2" />
                <span>Criar tarefa</span>
            </WhiteButton>
        </main>

        </DefaultCard>

    </div>

    <ModalTask v-if="showModalTask" @close="showModalTask = false" />
</template>

<style scoped>

</style>

<script>

definePageMeta({
    layout: 'dashboard'
})

export default {
    name: 'Desenvolvimento',
    methods: {
        teste() {
            alert('Teste')
        }
    }
}

</script>