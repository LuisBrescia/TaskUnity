<template>
    <div class="py-1 bg-rainbow-dark flex justify-center z-50">
        <span class="text-base font-bold">
            TIS2: Modelagem e processos de negócios
        </span>
    </div>
    <nav class="sticky top-0 z-40 w-full" :class="{ 'nav-blur': isScrolling }">
        <!-- * Menu fixo -->
        <div class="container mx-auto relative flex items-center justify-between p-3 lg:p-5 xl:rounded-t" id="menuFixo">
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
            class="lg:opacity-0 text-neutral-100 top-0 right-0 z-50 p-4 h-screen fixed">

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

    <section id="home" class="flex items-center px-3">
        <div class="container flex flex-col xl:flex-row items-center mx-auto gap-3 xl:gap-12">
            <div class="w-full hidden xl:flex">
                <article class="article-card flex-1 rounded-custom text-center shadow-lg p-5">
                    <Icon name="cryptocurrency-color:btg" size="2rem" />
                    <div class="text-xs tracking-wide font-thin mt-3 opacity-50">Seja um</div>
                    <h3 class="text-base uppercase font-bold tracking-widest">Tasker</h3>
                </article>
            </div>

            <div class="flex w-full">
                <header class="header-card flex-1 text-center py-8 px-0 md:px-5 rounded-custom shadow-lg afterglow">
                    <h1 class="text-5xl md:text-7xl tracking-tighter font-black mb-12">
                        <div>Desenvolvimento</div>
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

            <div class="flex w-full gap-3 sm:gap-5 flex-wrap">
                <article class="article-card flex-1 rounded-custom text-center shadow-lg p-5 xl:hidden block">
                    <Icon name="cryptocurrency-color:btg" size="2rem" />
                    <div class="text-xs tracking-wide font-thin mt-3 opacity-50">Seja um</div>
                    <h3 class="text-base uppercase font-bold tracking-widest">Tasker</h3>
                </article>

                <article class="article-card flex-1 rounded-custom text-center shadow-lg p-5">
                    <Icon name="cryptocurrency-color:chsb" size="2rem" />
                    <div class="text-xs tracking-wide font-thin mt-3 opacity-50">Seja um</div>
                    <h3 class="text-base uppercase font-bold tracking-widest">MANAGER</h3>
                </article>
            </div>
        </div>
    </section>

    <section id="guia" class="px-3">
        <div class="container mx-auto mb-5">
            <header class="text-4xl font-bold pl-5">
                Guia de uso	
            </header>
        </div>
        <div class="container flex flex-col-reverse xl:flex-row mx-auto gap-5 items-stretch">
            <div class="flex flex-col lg:flex-row xl:flex-col justify-between gap-5 slider-items">
                <DefaultCard class="p-5 border xl:max-w-md flex flex-col gap-3 relative overflow-hidden flex-1"
                    :class="{ 'slider-active': guiaImgAtual == 'projects' }" @click="handleCarouselChange(0)">
                    <div class="super-rainbow" />
                    <header class="text-xl font-bold flex items-center">
                        <Icon name="material-symbols:ad-group-outline-rounded" />
                        <span class="ml-2">Projetos</span>
                    </header>
                    <p class="text-neutral-300 text-lg font-light">
                        Primeira tela após o login, onde você pode criar um projeto novo ou acessar um já existente.
                    </p>
                    <footer class="text-lg font-bold flex items-center justify-end mt-3">
                        <span class="mr-2">Mais detalhes</span>
                        <Icon class="Icon" name="mdi:arrow-right" />
                    </footer>
                </DefaultCard>

                <DefaultCard class="p-5 border xl:max-w-md flex flex-col gap-3 relative overflow-hidden flex-1"
                    :class="{ 'slider-active': guiaImgAtual == 'project' }" @click="handleCarouselChange(1)">
                    <div class="super-rainbow" />
                    <header class="text-xl font-bold flex items-center">
                        <Icon name="material-symbols:bookmark-manager-outline" />
                        <span class="ml-2">Desenvolvimento</span>
                    </header>
                    <p class="text-neutral-300 text-lg font-light">
                        Onde o projeto é gerenciado, editando dados, adicionando e atribuindo tarefas. 
                    </p>
                    <footer class="text-lg font-bold flex items-center justify-end mt-3">
                        <span class="mr-2">Mais detalhes</span>
                        <Icon class="Icon" name="mdi:arrow-right" />
                    </footer>
                </DefaultCard>

                <DefaultCard class="p-5 border xl:max-w-md flex flex-col gap-3 relative overflow-hidden flex-1"
                    :class="{ 'slider-active': guiaImgAtual == 'tasks' }" @click="handleCarouselChange(2)">
                    <div class="super-rainbow" />
                    <header class="text-xl font-bold flex items-center">
                        <Icon name="tdesign:task" />
                        <span class="ml-2">Tarefas</span>
                    </header>
                    <p class="text-neutral-300 text-lg font-light">
                        Tela para acessar tarefas já atribuídas, encontrar novas e gerenciar candidaturas.
                    </p>
                    <footer class="text-lg font-bold flex items-center justify-end mt-3">
                        <span class="mr-2">Mais detalhes</span>
                        <Icon class="Icon" name="mdi:arrow-right" />
                    </footer>
                </DefaultCard>
            </div>

            <DefaultCard 
                class="flex-1 overflow-hidden flex items-center relative cursor-pointer" id="slider-carousel"
            >
                <div 
                    id="slider-loading" 
                    :style="{ width: loadingWidth + '%' }"
                />
                <!-- <span class="text-xl tracking-widest capitalize font-mono font-black">
                    {{ telaExibida[guiaImgAtual] }}
                </span> -->
                <img :src="`/img/guia/${guiaImgAtual}.png`" alt="Projects" class="w-full h-full object-cover" />
            </DefaultCard>
        </div>
    </section>

    <section id="equipe">

        <h1 class="mb-12 mx-auto text-5xl md:text-7xl font-black text-rainbow font-mono tracking-tighter w-fit">
            &lt; Equipe /&gt;
        </h1>

        <div class="container mx-auto" id="scroll">
            <div class="flex gap-5 py-5" id="scroll-inner">
                <TaskerCard name="André Hyodo Teichi" role="Dev Java IoT" img="andre">
                    Descobriu que o trabalho existia depois de 2 meses de desenvolvimento, formado na UFMG,
                    atualmente trabalha na Stellantis como desenvolvedor Java.
                </TaskerCard>

                <TaskerCard name="Gustavo Pereira" role="Tosador Pro" img="gustavo">
                    Fez a parte dele, formado em mecatrônica pelo Senai, está se preparando para seguir
                    carreira como engenheiro de software, hoje trabalha em um petshop.
                </TaskerCard>

                <TaskerCard name="Luís Felipe Brescia" role="Web developer" img="brescia">
                    Fez o trabalho todo praticamente sozinho, já formado no CEFET-MG,
                    atualmente trabalha na startup Atendeaí como desenvolvedor Vue e Flutter.
                </TaskerCard>

                <TaskerCard name="Luiz Felipe Campos" role="Analista de dados" img="luiz">
                    Apoio moral do grupo, outro que veio de Ciência da Computação, trabalha
                    como analista de dados em uma empresa parceira da Arcellor Mittal.   
                </TaskerCard>

                <TaskerCard name="Marcus Viniciús" role="Dev Flutter" img="marcus">
                    "Ia fazer, mas você já tinha feito", formado pelo Cotemig, de Ciência da computação veio para 
                    Engenharia de software, trabalha como Dev Flutter.
                </TaskerCard>

                <TaskerCard name="André Hyodo Teichi" role="Dev Java IoT" img="andre">
                    Descobriu que o trabalho existia depois de 2 meses de desenvolvimento, formado na UFMG,
                    atualmente trabalha na Stellantis como desenvolvedor Java.
                </TaskerCard>

                <TaskerCard name="Gustavo Pereira" role="Tosador Pro" img="gustavo">
                    Fez a parte dele, formado em mecatrônica pelo Senai, está se preparando para seguir
                    carreira como engenheiro de software, hoje trabalha em um petshop.
                </TaskerCard>

                <TaskerCard name="Luís Felipe Brescia" role="Web developer" img="brescia">
                    Fez o trabalho todo praticamente sozinho, já formado no CEFET-MG,
                    atualmente trabalha na startup Atendeaí como desenvolvedor Vue e Flutter.
                </TaskerCard>

                <TaskerCard name="Luiz Felipe Campos" role="Analista de dados" img="luiz">
                    Apoio moral do grupo, outro que veio de Ciência da Computação, trabalha
                    como analista de dados em uma empresa parceira da Arcellor Mittal.   
                </TaskerCard>

                <TaskerCard name="Marcus Viniciús" role="Dev Flutter" img="marcus">
                    Jogou a toalha, já formado pelo Cotemig, de Ciência da computação veio para 
                    Engenharia de software, trabalha como Dev Flutter.
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

            <div id="assinatura" class="font-mono font-black text-rainbow reveal">
                <NuxtLink to="https://luisbrescia.onrender.com" target="_blank">
                    <span>Luís Brescia</span>
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
const guiaImgAtual = ref('projects');
const guiaImgs = ['projects', 'project', 'tasks'];
const telaExibida = {
    projects: 'Projetos',
    tasks: 'Tarefas',
    project: 'Desenvolvimento'
}
const loadingWidth = ref(0);
const guiaAtualIndex = ref(0);
let intervalId;

function handleCarouselChange(index, animationEnd = false) {
    clearInterval(intervalId);
    loadingWidth.value = 0;
    carregarLoading();
    if (animationEnd) {
        guiaAtualIndex.value = index + 1;
    } else {
        guiaAtualIndex.value = index;
    }
    guiaAtualIndex.value = guiaAtualIndex.value % guiaImgs.length;
    guiaImgAtual.value = guiaImgs[guiaAtualIndex.value];
}

function carregarLoading() {
    intervalId = intervalId = setInterval(() => {
        loadingWidth.value += 0.5;
        if (loadingWidth.value > 100) {
            clearInterval(intervalId);
            handleCarouselChange(guiaAtualIndex.value, true);
        }
    }, 25);
}

function handleScroll() {
    isScrolling.value = window.scrollY > 100;
}

onMounted(() => {
    window.addEventListener('scroll', handleScroll);
    carregarLoading();
});

onBeforeUnmount(() => {
    window.removeEventListener('scroll', handleScroll);
});
</script>

<style scoped>
.slider-items .card {
    filter: brightness(0.8);
}

.slider-items .card:hover {
    filter: brightness(1);
    transform: scale(1);
    cursor: pointer;
}

.slider-items .card:hover footer {
    text-decoration: underline;
}

.slider-items .card:hover .Icon {
    transform: translateX(0.125rem);
}

.slider-items .card.slider-active {
    filter: brightness(1);
    transform: scale(1);
}

.slider-items .card:hover .super-rainbow::after {
    background-color: #0f0f0f;
}

.super-rainbow {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(to right, #38bdf8, #4ade80, #fbbf24, #fb7185, #fbbf24, #4ade80, #38bdf8);
    z-index: -1;
    background-size: 200%;
    animation: move-background 3s linear infinite;
    filter: brightness(0);
    transition: all .5s ease;
    opacity: 0;
}

.super-rainbow::after {
    content: "";
    position: absolute;
    height: 100%;
    width: 100%;
    background-color: #030303;
    border-radius: .75rem;
    z-index: 10;
    transform: scaleX(0.99) scaleY(0.97);
    transition: all .5s ease;
}

.slider-active .super-rainbow {
    filter: brightness(1);
    opacity: 1;
}

.slide-active .super-rainbow:hover .super-rainbow::after {
    opacity: 0;
}

#slider-carousel {
    position: relative;
}

#slider-carousel span {
    position: absolute;
    right: 0;
    bottom: 0;
    background-color: #030303;
    border-top-left-radius: 1rem;
    border-top: 2px solid #ffffff1a;
    border-left: 2px solid #ffffff1a;
    padding: 0.5rem 1rem;
    transition: all .5s ease;
}

#slider-carousel:hover span {
    border-color: #ffffff3a;
    background: #0f0f0f;
}

#slider-loading {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    height: 5px;
    width: 0%;
    background: linear-gradient(90deg, #38bdf8, #4ade80, #fbbf24, #fb7185);
    /* border-radius: 1.5rem; */
}

body {
    background: linear-gradient(144deg, #3b82f6, #22c55e, #eab308, #dc2626, #3b82f6, #22c55e);
}

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

.nav-blur,
nav {
    background-color: #030303f0;
    /* backdrop-filter: blur(25px);
    -webkit-backdrop-filter: blur(25px); */
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

.header-card {
    width: 50rem;
}

.article-card {
    min-width: 10rem;
}

.header-card,
.article-card {
    backdrop-filter: brightness(0);
    -webkit-backdrop-filter: brightness(0);
    transition: all .5s ease;
    border: 2px solid #ffffff1a;
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
    .header-card:hover,
    .article-card:hover {
        border-color: rgba(255, 255, 255, 0.2);
        background: rgba(255, 255, 255, 0.05);
        transform: translateY(-0.5rem);
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