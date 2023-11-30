<template>
    <main class="flex">
        <aside class="flex flex-col h-screen p-8 overflow-hidden items-center justify-between sticky top-0">
            <div class="flex flex-col gap-12 items-center">
                <NuxtLink to="/" exact>
                    <div class="item-dashboard rounded-3xl text-neutral-300">
                        <Icon name="iconamoon:3d-light" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Início</span>
                    </div>
                </NuxtLink>
                <NuxtLink to="/projects" exact>
                    <div class="item-dashboard rounded-3xl text-neutral-300"
                        :class="{ 'active': isLinkActive('/projects') }">
                        <Icon name="material-symbols:ad-group-outline-rounded" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Projetos</span>
                    </div>
                </NuxtLink>
                <NuxtLink to="/tasks" exact>
                    <div class="item-dashboard rounded-3xl text-neutral-300" :class="{ 'active': isLinkActive('/tasks') }">
                        <Icon name="tdesign:task" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Tarefas</span>
                    </div>
                </NuxtLink>

                <NuxtLink to="/profile" exact>
                    <div class="item-dashboard rounded-3xl text-neutral-300"
                        :class="{ 'active': isLinkActive('/profile') }">
                        <Icon name="material-symbols:person-outline" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Perfil</span>
                    </div>
                </NuxtLink>

                <NuxtLink to="/teams" exact>
                    <div class="item-dashboard rounded-3xl text-neutral-300"
                        :class="{ 'active': isLinkActive('/teams') }">
                        <Icon name="fluent:people-team-16-regular" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Equipes</span>
                    </div>
                </NuxtLink>

                <NuxtLink to="/contratar-freelancer" exact>
                    <div class="item-dashboard rounded-3xl text-neutral-300"
                        :class="{ 'active': isLinkActive('/contratar-freelancer') }">
                        <div class="rounded-full overflow-hidden" style="width: 1.75rem; aspect-ratio: 1/1;">
                            <img src="/img/andre.jpg" />
                        </div>
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Andre</span>
                    </div>
                </NuxtLink>
            </div>
        </aside>

        <div class="w-full py-3 px-5">
            <div class="flex items-end">
                <!-- <div class="flex-1 my-3 relative mr-5">
                    <hr class="linha-branca w-full rounded-full" />
                    <hr class="linha-colorida w-full rounded-full" />
                </div> -->
                <!-- <div class="w-fit flex items-center tracking-tighter font-black text-4xl relative text-neutral-300 font-mono">
                    <span id="titulo-pagina">[{{ paginaAtual }}]</span>
                    <span id="titulo-pagina-branco">[{{ paginaAtual }}]</span>
                </div> -->
            </div>
            <slot />
        </div>
    </main>
</template>

<style scoped>
aside {
    color: #fff;
    backdrop-filter: blur(25px);
    -webkit-backdrop-filter: blur(25px);
    transition: border-color .5s ease;
    border-right: 2px solid #ffffff1a;
    transition: all .5s ease, height 0s;
}

aside:hover {
    border-color: rgba(225, 255, 255, 0.2);
    background: rgba(255, 255, 255, 0.02);
}

.item-dashboard span {
    font-size: 0.7rem;
    line-height: 1rem;
    position: absolute;
    top: 50px;
    padding: 0.25rem 0.5rem;
    border-radius: 0.25rem;
    opacity: 0;
    transform: translateY(-10px) scaleY(0);
    filter: blur(10px);
    transition: opacity 0.3s ease-in-out, transform .3s ease-in-out, filter .3s ease-in-out;
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
    filter: drop-shadow(0 0 .75rem #fff);
    transition: background-color .3s ease-in-out, color .3s ease-in-out, outline-color .5s ease-in-out;
    position: relative;
}

.item-dashboard:hover {
    backdrop-filter: saturate(125%);
    background-color: rgba(255, 255, 255, 0.2);
    color: #fff;
    animation: pulse 1.25s cubic-bezier(0.215, 0.61, 0.355, 1) infinite;
}

.item-dashboard.active {
    backdrop-filter: saturate(125%);
    outline: 2px solid #d4d4d4;
}

.item-dashboard.active:hover {
    outline-color: #fff;
}

@keyframes pulse {
    0% {
        transform: scale(0.95);
        box-shadow: 0 0 0 0 rgba(255, 255, 255, 0.5);
    }

    70% {
        transform: scale(1);
        box-shadow: 0 0 0 10px rgba(255, 255, 255, 0);
    }

    100% {
        transform: scale(0.95);
        box-shadow: 0 0 0 0 rgba(255, 255, 255, 0);
    }
}

#titulo-pagina {
    background-clip: text;
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    /* background-image: linear-gradient(to right, transparent, #0ea5e9, transparent, #22c55e, transparent, #eab308, transparent, #f43f5e, transparent); */
    background-image: linear-gradient(to right,  #38bdf8, #4ade80, #fbbf24, #fb7185, #fbbf24, #4ade80, #38bdf8);
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