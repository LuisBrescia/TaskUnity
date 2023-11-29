<template>
    <main class="flex gap-5 mt-5">


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

        <section class="flex gap-5 flex-wrap w-full">
            <div v-for="project in projects" :key="project.id" class="flex-1">
                <DefaultCard class="cursor-pointer overflow-auto w-full" style="min-width: 360px; height: 360px;" @click="abrirProjeto(project.id)">
                    <header>
                        <h2 class="text-4xl font-semibold tracking-tighter">{{ project.name }} ({{ project.id }})</h2>                       
                        <h4 class="text-2xl">Criação: {{ project.startDate }}</h4>
                        <h4 class="text-2xl">Owner: {{ project.owner }}</h4>
                    </header>
                    <hr class="my-2 linha-colorida">
                    <section>
                        <h4 class="font-black uppercase">Feramentas:</h4>
                        <ul v-for="(tool, idx) in project.tools">
                            <li>{{ idx + 1 }} - {{ tool }}</li>
                        </ul>
                    </section>
                    <p class="text-base">{{ project.description }}</p>
                </DefaultCard>
            </div>
            <div class="flex-1">
                <DefaultCard class="cursor-pointer relative" style="min-width: 360px; height: 360px; border-style: dashed;" @click="createProject">
                    <div class="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2">
                        <Icon name="carbon:add" size="5rem" />
                    </div>
                </DefaultCard>
            </div>
        </section>
    </main>
</template>

<script setup>

const projects = ref({});
const router = useRouter();


definePageMeta({
    layout: 'dashboard'
})

apiFetch('/projects')
    .then(res => {
        projects.value = res.data
        console.log(res)
    }).catch(err => {
        console.log(err)
    })

function createProject() {
    console.log('Criar projeto');
    router.push('/create-project');
}

function abrirProjeto(id) {
    console.log('Abrir projeto: ' + id);
    router.push(`/projects/${id}`);
}

</script>

<style lang="scss" scoped>
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