<template>
    <main class="flex">
        <aside class="flex flex-col h-screen py-5 px-8 overflow-hidden items-center justify-between">

            <!-- <NuxtLink to="/">
                <Icon name="iconamoon:3d-light" color="white" size="3rem" class="mb-4"/>
            </NuxtLink>  -->

            <div class="flex flex-col gap-12 items-center">
                <NuxtLink to="/projects" exact>
                    <div class="item-dashboard rounded-3xl text-neutral-300" :class="{ 'active': isLinkActive('/projects') }">
                        <Icon name="material-symbols:ad-group-outline-rounded" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Projetos</span>
                    </div>
                </NuxtLink>
                <NuxtLink to="/tasks" exact>
                    <div class="item-dashboard rounded-3xl text-neutral-300" :class="{ 'active': isLinkActive('/tasks') }">
                        <Icon name="material-symbols:price-change-outline-rounded" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Tarefas</span>
                    </div>
                </NuxtLink>
                <NuxtLink to="/profile" exact>
                    <div class="item-dashboard rounded-3xl text-neutral-300" :class="{ 'active': isLinkActive('/profile') }">
                        <Icon name="material-symbols:person-2-outline" size="1.75rem" class="p-0 m-0" />
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Perfil</span>
                    </div>
                </NuxtLink>
            </div>

            <div class="flex flex-col gap-12 items-center">
                <NuxtLink to="/">
                    <div class="item-dashboard rounded-3xl text-neutral-300 mb-5">
                        <Icon name="material-symbols:house-outline-rounded" size="1.75rem" />
                        <span class="mt-1 tracking-widest font-extrabold uppercase p-0 m-0">Início</span>
                    </div>
                </NuxtLink>
            </div>

            <RedBlob class="left-3/4 animate-ping" style="bottom: 20%; filter: blur(50px)" />
            <RedBlob class="left-3/4 animate-spin" style="bottom: 20%; filter: blur(50px)" />

            <YellowBlob class="animate-ping" style="top: 65%; left: 55%; filter: blur(50px)" />
            <YellowBlob class="animate-spin" style="top: 65%; left: 55%; filter: blur(50px)" />

            <GreenBlob class="animate-ping" style="bottom: 65%; right: 55%; filter: blur(50px)" />
            <GreenBlob class="animate-spin" style="bottom: 65%; right: 55%; filter: blur(50px)" />

            <BlueBlob class="right-3/4 animate-ping" style="top: 20%; filter: blur(50px)" />
            <BlueBlob class="right-3/4 animate-spin" style="top: 20%; filter: blur(50px)" />

        </aside>
        <div class="w-full py-5 px-8">
            <div class="flex items-center tracking-tighter font-black text-4xl uppercase relative text-neutral-300 font-mono">
                <span id="titulo-pagina">/{{ paginaAtual  }}</span>
                <span id="titulo-pagina-branco">/{{ paginaAtual }}</span> 
            </div>

            <div class="my-3 relative">
                <hr class="linha-branca w-full rounded-full" />
                <hr class="linha-colorida w-full rounded-full" />
            </div>
            
            <slot />
        </div>
    </main>
</template>

<style scoped>

aside {
    color: #fff;
    backdrop-filter: blur(25px) brightness(0.75);
    -webkit-backdrop-filter: blur(25px) brightness(0.75);
    border-right: 1px solid #d4d4d4;
    background-color: #000;
}

main {
    background: linear-gradient(144deg, #050809, #0f0f0f);
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
    /* filter: drop-shadow(0 0 .75rem #fff); */
    transition: background-color .3s ease-in-out, color .3s ease-in-out, outline-color .5s ease-in-out;
    position: relative;
}

.item-dashboard:hover {
    backdrop-filter: saturate(125%);
    background-color: rgba(0, 0, 0, 0.1);
    color: #fff;
    animation: pulse 1.25s cubic-bezier(0.215, 0.61, 0.355, 1) infinite;
}

.item-dashboard.active {
    backdrop-filter: saturate(125%);
    background-color: rgba(0, 0, 0, 0.1);
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
    background-image: linear-gradient(to right, transparent, #0ea5e9, transparent,  #22c55e, transparent,  #eab308, transparent,  #f43f5e, transparent );
    width: 100%;
    background-size: 200%;
    animation: move-background 5s linear infinite;
}

#titulo-pagina-branco {
    position: absolute;
    top: 1px;
    left: -2px;
}

.linha-colorida {
    background: linear-gradient(to right, transparent, #0ea5e9, transparent,  #22c55e, transparent,  #eab308, transparent,  #f43f5e, transparent );
    height: 3px;
    border: none;
    background-size: 200%;
    animation: move-background 5s linear infinite;
}

.linha-branca {
    height: 1px;
    width: 100%;
    border: none;
    background: #d4d4d4;
    position: absolute;
    top: 1px;
}

@keyframes move-background {
    0% {
    background-position: 0% center;
  }

  100% {
    background-position: -200% center;
  }
}

</style>

<script>
export default {
    methods: {
        isLinkActive(route) {
            return this.$route.path === route;
        }
    },
    data () {
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