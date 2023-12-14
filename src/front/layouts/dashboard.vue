<template>
    <div class="blobs fixed pointer-events-none" style="height: 100vh; width: 100vw;">
        <BlueBlob class="animate-ping right-full" style="top: 0%;" />
        <BlueBlob class="animate-spin right-full" style="top: 0%;" />
        <GreenBlob class="animate-ping right-full" style="top: 25%;" />
        <GreenBlob class="animate-spin right-full" style="top: 25%;" />
        <YellowBlob class="animate-ping right-full" style="top: 50%;" />
        <YellowBlob class="animate-spin right-full" style="top: 50%;" />
        <RedBlob class="animate-ping right-full" style="top: 75%;" />
        <RedBlob class="animate-spin right-full" style="top: 75%;" />

        <BlueBlob class="animate-ping left-full" style="top: 0%;" />
        <BlueBlob class="animate-spin left-full" style="top: 0%;" />
        <GreenBlob class="animate-ping left-full" style="top: 25%;" />
        <GreenBlob class="animate-spin left-full" style="top: 25%;" />
        <YellowBlob class="animate-ping left-full" style="top: 50%;" />
        <YellowBlob class="animate-spin left-full" style="top: 50%;" />
        <RedBlob class="animate-ping left-full" style="top: 75%;" />
        <RedBlob class="animate-spin left-full" style="top: 75%;" />
    </div>
    <main class="flex flex-col">
        <div class="flex-1 w-full py-3 px-5" style="height: 90svh">
            <slot />
        </div>
        <div class="fixed w-full flex justify-center bottom-0 py-5 pointer-events-none">
            <aside class="flex rounded-custom pointer-events-auto">
                <NuxtLink to="/projects" exact>
                    <div class="item-dashboard primeiro-item text-neutral-300" :class="{ 'active': isLinkActive('/projects') }">
                        <Icon name="material-symbols:ad-group-outline-rounded" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-black uppercase p-0 m-0">Projetos</span>
                    </div>
                </NuxtLink>
                <NuxtLink to="/tasks" exact>
                    <div class="item-dashboard text-neutral-300" :class="{ 'active': isLinkActive('/tasks') }">
                        <Icon name="tdesign:task" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-black uppercase p-0 m-0">Tarefas</span>
                    </div>
                </NuxtLink>

                <NuxtLink to="/profile" exact>
                    <div class="item-dashboard text-neutral-300" :class="{ 'active': isLinkActive('/profile') }">
                        <Icon name="material-symbols:person-outline" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-black uppercase p-0 m-0">Perfil</span>
                    </div>
                </NuxtLink>

                <NuxtLink to="/teams" exact>
                    <div class="item-dashboard text-neutral-300" :class="{ 'active': isLinkActive('/teams') }">
                        <Icon name="fluent:people-team-16-regular" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Equipes</span>
                    </div>
                </NuxtLink>

                <NuxtLink to="/contratar-freelancer" exact>
                    <div class="item-dashboard text-neutral-300"
                        :class="{ 'active': isLinkActive('/contratar-freelancer') }">
                        <Icon name="simple-icons:freelancer" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-black uppercase p-0 m-0">Contratar</span>
                    </div>
                </NuxtLink>

                <div class="item-dashboard ultimo-item text-neutral-300 cursor-pointer" @click="modalSair">
                    <Icon name="material-symbols:logout" size="1.75rem" />
                    <span class="mt-1 tracking-widest font-black uppercase p-0 m-0">Sair</span>
                </div>
            </aside>
        </div>
    </main>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js';

const userStore = useUserStore();
const router = useRouter();

function modalSair() {
    ElMessageBox.confirm('Deseja realmente sair?', 'Sair', {
        confirmButtonText: 'Sair',
        cancelButtonText: 'Cancelar',
        type: 'warning'
    }).then(() => {
        userStore.logout();
        router.push('/');
    }).catch(() => { });
}

</script>

<style scoped>
.blobs>* {
    width: 25vh;
    filter: blur(100px);
}

main {
    min-height: 100vh;
}

aside {
    color: #fff;
    background: #030303;
    border: 2px solid #ffffff1a;
    transition: all .3s ease, border-color .5s ease;
}

aside:hover {
    border-color: rgba(225, 255, 255, 0.2);
    background: #050505;
}

.item-dashboard span {
    font-size: 0.7rem;
    line-height: 1rem;
    position: absolute;
    bottom: 60px;
    text-align: center;
    background: linear-gradient(to right, #38bdf8, #4ade80, #fbbf24, #fb7185, #fbbf24, #4ade80, #38bdf8);
    background-size: 200%;
    animation: move-background 3s linear infinite;
    padding: 0.25rem 0.5rem;
    border-radius: 0.25rem;
    opacity: 0;
    transform: translateY(-10px) scaleY(0);
    filter: blur(10px);
    transition: opacity 0.3s ease-in-out, transform .3s ease-in-out, filter .3s ease-in-out;
    min-width: 5rem;
}

.item-dashboard:hover span {
    opacity: 1;
    transform: translate(0) scaleY(1);
    filter: blur(0);
}

.item-dashboard {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: .75rem 1rem;
    transition: background-color .3s ease-in-out, color .3s ease-in-out, outline-color .3s ease-in-out;
    position: relative;
}

.primeiro-item {
    border-top-left-radius: 1rem;
    border-bottom-left-radius: 1rem;
}

.ultimo-item {
    border-top-right-radius: 1rem;
    border-bottom-right-radius: 1rem;
} 

.item-dashboard:hover {
    color: #fff;
    background-color: rgba(255, 255, 255, 0.05);
    /* background: linear-gradient(to right, #38bdf8, #4ade80, #fbbf24, #fb7185, #fbbf24, #4ade80, #38bdf8);
    background-size: 200%;
    animation: move-background 3s linear infinite; */
}

.item-dashboard.active {
    outline: 2px solid #d4d4d4;
}

.item-dashboard.active:hover {
    outline-color: #fff;
}

#titulo-pagina {
    background-clip: text;
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    /* background-image: linear-gradient(to right, transparent, #0ea5e9, transparent, #22c55e, transparent, #eab308, transparent, #f43f5e, transparent); */
    background-image: linear-gradient(to right, #38bdf8, #4ade80, #fbbf24, #fb7185, #fbbf24, #4ade80, #38bdf8);
    width: 100%;
    background-size: 200%;
    animation: move-background 10s linear infinite;
}

#titulo-pagina-branco {
    position: absolute;
    top: 1px;
    left: -2px;
}
</style>

<script>
export default {
    methods: {
        isLinkActive(route) {
            return this.$route.path === route;
        }
    },
    data() {
        return {
            paginaAtual: this.$route.path.substring(1)
        }
    },
    watch: {
        '$route'() {
            this.paginaAtual = this.$route.path.substring(1);
        }
    }
}
</script>