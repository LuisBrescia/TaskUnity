<template>
    <div class="py-1 bg-rainbow-dark flex justify-center">
        <span class="text-base font-bold">
            TIS2: Modelagem e processos de negócios
        </span>
    </div>
    <nav class="sticky top-0 z-40 w-full" :class="{ 'nav-blur': isScrolling }">
        <!-- * Menu fixo -->
        <div class="container mx-auto relative overflow-hidden flex items-center justify-between p-3 lg:p-5 xl:rounded-t"
            id="menuFixo">
            <h2
                class="flex-1 text-2xl font-black tracking-tight text-neutral-50 cursor-pointer text-border font-sans flex items-center">
                <Icon name="iconamoon:3d-light" color="white" size="2.75rem" />
                <span>&nbsp;TASK</span>
                <span class="text-transparent tracking-normal">UNITY</span>
            </h2>

            <ul class="flex-1 text-base hidden lg:block text-center">
                <li class="inline-block mx-5 hover:text-white">
                    <a href="#">Home</a>
                </li>
                <li class="inline-block mx-5 hover:text-white">
                    <a href="#guia">Guia</a>
                </li>
                <li class="inline-block mx-5 hover:text-white">
                    <a href="#equipe">Equipe</a>
                </li>
            </ul>

            <NuxtLink to="/login?modo=entrar" class="flex-1 text-end p-0 m-0 hidden lg:flex justify-end">
                <WhiteButton>Entrar</WhiteButton>
            </NuxtLink>

            <div @click="menuAberto = !menuAberto" class="lg:hidden cursor-pointer">
                <Icon name="solar:hamburger-menu-outline" color="white" size="2rem" />
            </div>

        </div>

        <!-- * Menu mobile-->
        <div id="menuMobile" :class="{ 'pointer-events-none': !menuAberto, 'active': menuAberto }"
            class="lg:opacity-0 absolute text-neutral-100 top-0 right-0 z-50 p-4 h-screen">

            <div class="flex items-center gap-2 mb-12 text-xl justify-between ps-3">
                <span class="text-xl font-bold tracking-widest">MENU</span>
                <span @click="menuAberto = !menuAberto"
                    class="text-neutral-300 hover:text-white flex items-center cursor-pointer">
                    <Icon name="mdi:close" size="1.75rem" />
                </span>
            </div>

            <ul class="text-base flex flex-col gap-5 font-normal uppercase text-neutral-300 ps-3 pe-24">
                <li class="inline-block mx-5 hover:text-white">
                    <a href="#">Home</a>
                </li>
                <li class="inline-block mx-5 hover:text-white">
                    <a href="#guia">Guia</a>
                </li>
                <li class="inline-block mx-5 hover:text-white">
                    <a href="#equipe">Equipe</a>
                </li>
            </ul>

            <NuxtLink to="/login?modo=entrar">
                <WhiteButton class="mt-12 w-full">Entrar</WhiteButton>
            </NuxtLink>
        </div>
    </nav>

    <section id="home" class="flex items-center">
        <div class="container flex flex-col xl:flex-row items-center mx-auto gap-5 xl:gap-12">
            <div class="flex w-full">
                <article class="flex-1 rounded-custom text-center shadow-lg p-5 hidden xl:block">
                    <Icon name="cryptocurrency-color:btg" size="2rem" />
                    <div class="text-xs tracking-wide font-thin mt-3 opacity-50">Seja um</div>
                    <h3 class="text-base uppercase font-bold tracking-widest">Tasker</h3>
                </article>
            </div>

            <div class="flex w-full">
                <header class="flex-1 text-center py-8 px-0 md:px-5 sm:rounded-2xl shadow-lg">
                    <h1 class="text-5xl md:text-7xl tracking-tighter font-black mb-12">
                        Desenvolvimento <br />
                        <span class="text-rainbow font-mono">
                            &lt;re-imaginado/&gt;
                        </span>
                    </h1>
                    <p class="text-lg md:text-2xl font-light px-3 md:px-0 max-w-3xl mx-auto">
                        TaskUnity é um site que permite você encontrar e unir pessoas para desenvolver projetos.
                        Monte uma equipe e faça acontecer!
                    </p>
                    <div class="flex gap-5 justify-center">
                        <NuxtLink to="/login?modo=cadastrar">
                            <WhiteButton class="mt-12">Começe agora</WhiteButton>
                        </NuxtLink>
                    </div>
                </header>
            </div>

            <div class="flex w-full sm:gap-5 flex-wrap">
                <article class="flex-1 sm:rounded-2xl text-center shadow-lg p-5 xl:hidden block">
                    <Icon name="cryptocurrency-color:btg" size="2rem" />
                    <div class="text-xs tracking-wide font-thin mt-3 opacity-50">Seja um</div>
                    <h3 class="text-base uppercase font-bold tracking-widest">Tasker</h3>
                </article>

                <article class="flex-1 sm:rounded-2xl text-center shadow-lg p-5">
                    <Icon name="cryptocurrency-color:chsb" size="2rem" />
                    <div class="text-xs tracking-wide font-thin mt-3 opacity-50">Seja um</div>
                    <h3 class="text-base uppercase font-bold tracking-widest">MANAGER</h3>
                </article>
            </div>
        </div>
    </section>

    <section id="guia" class="flex items-center">
        <div class="container flex flex-col items-center mx-auto gap-5 xl:gap-12">
            <div class="flex w-full">
                <header class="flex-1 mx-auto text-center py-8 px-0 md:px-5 sm:rounded-2xl shadow-lg afterglow">
                    <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                        Guia
                    </h1>
                    <p class="text-lg md:text-2xl font-light px-3 md:px-0">
                        Mini tutorial sobre o funcionamento do site.
                    </p>
                    <WhiteButton class="mt-12 w-36 animate-bounce">
                        <Icon name="solar:notebook-minimalistic-line-duotone" size="1.75rem" />
                    </WhiteButton>
                </header>
            </div>
            <!-- <div class="max-w-3xl my-5 rounded-custom overflow-hidden">
                <img src="/img/guia/projects.png" alt="Tela de projetos" class="w-full" />
            </div> -->
            <div class="max-w-3xl my-5 rounded-custom overflow-hidden">
                <img src="/img/guia/projeto.png" alt="Tela de projetos" class="w-full" />
            </div>
            <!-- <div class="max-w-3xl my-5 rounded-custom overflow-hidden">
                <img src="/img/guia/projectSendTask.png" alt="Tela de projetos" class="w-full" />
            </div> -->
            <div class="max-w-3xl my-5 rounded-custom overflow-hidden">
                <img src="/img/guia/tasks.png" alt="Tela de projetos" class="w-full" />
            </div>
            <!-- <div class="max-w-3xl my-5 rounded-custom overflow-hidden">
                <img src="/img/guia/tasksFindNew.png" alt="Tela de projetos" class="w-full" />
            </div> -->
            <div class="max-w-3xl my-5 rounded-custom overflow-hidden">
                <img src="/img/guia/profile.png" alt="Tela de projetos" class="w-full" />
            </div>
            <!-- <div class="max-w-3xl my-5 rounded-custom overflow-hidden">
                <img src="/img/guia/profileInvite.png" alt="Tela de projetos" class="w-full" />
            </div> -->
        </div>
    </section>

    <section id="equipe">

        <h1 class="mb-12 mx-auto text-5xl md:text-7xl font-black text-rainbow font-mono tracking-tighter w-fit">
            &lt; Equipe /&gt;
        </h1>

        <div class="container mx-auto" id="scroll">
            <div class="flex sm:gap-5 py-5" id="scroll-inner">
                <TaskerCard name="André Hyodo" role="Roteirista" img="andre">
                    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Pariatur sapiente magnam labore itaque
                    vero consectetur, corporis necessitatibus!
                </TaskerCard>

                <TaskerCard name="Gustavo Pereira" role="Dublador" img="gustavo">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Omnis dicta non tempora vel quibusdam
                    quasi.
                </TaskerCard>

                <TaskerCard name="Luís Felipe Brescia" role="Dev Vue e Flutter" img="brescia">
                    Lorem ipsum dolor sit amet consectetur, adipisicing elit. Eaque pariatur incidunt sapiente modi!
                </TaskerCard>

                <TaskerCard name="Luiz Campos" role="Fotógrafo" img="luiz">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit quaerat corporis ea sed?
                </TaskerCard>

                <TaskerCard name="Marcus Viniciús" role="Dev Flutter" img="marcus">
                    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ea, suscipit adipisci! Porro.
                </TaskerCard>

                <TaskerCard name="André Hyodo" role="Roteirista" img="andre">
                    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Pariatur sapiente magnam labore itaque
                    vero consectetur, corporis necessitatibus!
                </TaskerCard>

                <TaskerCard name="Gustavo Pereira" role="Dublador" img="gustavo">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Omnis dicta non tempora vel quibusdam
                    quasi.
                </TaskerCard>

                <TaskerCard name="Luís Felipe Brescia" role="Dev Vue e Flutter" img="brescia">
                    Lorem ipsum dolor sit amet consectetur, adipisicing elit. Eaque pariatur incidunt sapiente modi!
                </TaskerCard>

                <TaskerCard name="Luiz Campos" role="Fotógrafo" img="luiz">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit quaerat corporis ea sed?
                </TaskerCard>

                <TaskerCard name="Marcus Viniciús" role="Dev Flutter" img="marcus">
                    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ea, suscipit adipisci! Porro.
                </TaskerCard>

            </div>
        </div>
    </section>

    <footer class="px-12 py-2">
        <div class="container mx-auto flex justify-between items-center">

            <div class="text-xl font-sans">
                <Icon name="octicon:logo-github-16" color="white" size="4rem"
                    class="cursor-pointer opacity-80 hover:opacity-100" />
            </div>

            <div class="opacity-80">
                <NuxtLink to="https://luisbrescia.onrender.com" target="_blank">
                    <Icon name="noto:desktop-computer" color="red" size="1rem" />
                    <span class="text-base font-sans ml-2">Luís Brescia</span>
                </NuxtLink>
            </div>

            <div class="flex gap-5">
                <Icon name="mdi:nuxt" color="white" size="2rem" class="cursor-pointer opacity-80 hover:opacity-100" />
            </div>
        </div>
    </footer>

    <!-- * Efeito de escurecer a tela -->
    <div @click="menuAberto = !menuAberto" :class="{ 'hidden': !menuAberto, 'block': menuAberto }"
        class="escurecer fixed inset-0 bg-black opacity-80 z-10" />
</template>

<script setup>

const menuAberto = ref(false);
const isScrolling = ref(false);

onMounted(() => {
    window.addEventListener('scroll', handleScroll);
});

onBeforeUnmount(() => {
    window.removeEventListener('scroll', handleScroll);
});

const handleScroll = () => {
    isScrolling.value = window.scrollY > 100;
}
</script>

<style scoped>
ul li::after {
    content: "";
    display: block;
    width: 0;
    height: 1px;
    margin: auto;
    background: white;
    transition: width .2s ease;
}

ul li:hover::after {
    width: 100%;
}

.nav-blur {
    backdrop-filter: blur(25px);
    -webkit-backdrop-filter: blur(25px);
}

#menuMobile {
    filter: blur(5px);
    background: rgb(0, 0, 0);
    border-left: 1px solid rgba(255, 255, 255, 0.10);
    transform: translate(100%) scaleX(75%);
    transition: all .5s ease;
    -webkit-transition: all .5s ease;
    -moz-transition: all .5s ease;
    -ms-transition: all .5s ease;
    -o-transition: all .5s ease;
}

#menuMobile.active {
    filter: blur(0px);
    transform: translate(0);
}

#menuMobile li::after {
    margin-left: 0;
}

#menuMobile ul li:hover::after {
    width: 10%;
}

section {
    position: relative;
    transition: all 1s ease;
    min-height: 50vh;
    margin-bottom: 10rem;
}

section:first-of-type {
    min-height: 75vh;
}

header {
    width: 50rem;
}

#equipe article {
    min-width: 364px;
    background-size: 200%;
    animation: move-background 3s linear infinite;
}

article {
    min-width: 10rem;
}

header,
article {
    backdrop-filter: brightness(0);
    -webkit-backdrop-filter: brightness(0);
    transition: all .5s ease;
    /* border-top: 2px solid #ffffff1a;
    border-bottom: 2px solid #ffffff1a; */
}

header:hover,
article:hover {
    border-color: rgba(255, 255, 255, 0.2);
    background: rgba(255, 255, 255, 0.05);
    transform: translateY(-0.5rem);
}

.escurecer.block {
    animation: fade 1s ease;
}

@keyframes fade {
    from {
        opacity: 0;
    }

    to {
        opacity: .8;
    }
}

@media screen and (max-width: 440px) {
    h1 {
        font-size: 2.5rem;
        line-height: 2.5rem;
    }
}

@media screen and (min-width: 640px) {
    header,
    article {
        /* border-right: 2px solid #ffffff1a;
        border-left: 2px solid #ffffff1a; */
        border: 2px solid #ffffff1a;
    }
}

#scroll {
    overflow-x: scroll;
    overflow-y: hidden;
    scroll-snap-type: x mandatory;
    -webkit-overflow-scrolling: touch;
    scrollbar-width: none;
    -ms-overflow-style: none;
    mask-image: linear-gradient(to right, transparent, black 20%, black 80%, transparent);
    -webkit-mask-image: linear-gradient(to right, transparent, black 20%, black 80%, transparent);
}

#scroll::-webkit-scrollbar {
    display: none;
}

#scroll-inner {
    display: flex;
    flex-wrap: nowrap;
    scroll-snap-type: x mandatory;
    scroll-behavior: smooth;
    -webkit-overflow-scrolling: touch;
    scrollbar-width: none;
    -ms-overflow-style: none;
    animation: scroll-horizontal 20s linear infinite;
    width: max-content;
}

#scroll-inner:hover {
    animation-play-state: paused;
}

@keyframes scroll-horizontal {
    to {
        transform: translateX(calc(-50% - 0.625rem));
    }
}
</style>