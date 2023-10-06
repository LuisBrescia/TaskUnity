<script setup>

const menuAberto = ref(false);
const isScrolling = ref(false);
const gradientColor = ref("from-red-500 via-rose-300 to-pink-500");
const fonteAlternativa = ref("font-sans");
let indexCor = 0, indexFonte = 0;

const colors = [
    "from-indigo-500 via-sky-300 to-cyan-500",
    "from-emerald-500 via-green-300 to-lime-500",
    "from-yellow-500 via-amber-300 to-orange-500",
    "from-red-500 via-rose-300 to-pink-500"
]
// const fonts = [
//     "font-serif",
//     "font-cursive",
//     "font-mono",
//     "font-marker"
// ]

setInterval(() => {

    gradientColor.value = colors[indexCor]
    // fonteAlternativa.value = fonts[indexFonte]

    if (indexCor < colors.length - 1) indexCor++
    else indexCor = 0

    // if (indexFonte < fonts.length - 1) indexFonte++
    // else indexFonte = 0

}, 750);

onMounted(() => {
  window.addEventListener('scroll', handleScroll);
});

onBeforeUnmount(() => {
  window.removeEventListener('scroll', handleScroll);
});

const handleScroll = () => {
    isScrolling.value = window.scrollY > 100;
    // clearTimeout(isScrolling.value);

    // isScrolling.value = setTimeout(() => {
    //     isScrolling.value = false;
    // }, 100);
}


</script>

<template>
    <main class="overflow-hidden">

        <nav class="fixed top-0 z-30 w-full" :class="{'border-b' : isScrolling}">
            <!-- * Menu fixo -->
            <div class="container mx-auto relative overflow-hidden flex items-center justify-between p-3 lg:p-5 xl:rounded-t"
            :class="{'nav-blur' : isScrolling}" id="menuFixo">
                <h1 class="text-2xl font-black tracking-tight text-neutral-50 cursor-pointer text-border font-sans flex items-center">
                    <Icon name="iconamoon:3d" color="white" size="2.75rem" />
                    <span>&nbsp;TASK</span>
                    <span class="text-transparent tracking-normal">UNITY</span>
                </h1>

                <ul class="text-base text-neutral-300 hidden lg:block">
                    <li class="inline-block mx-5 hover:text-white">
                        <NuxtLink to="#">Guia</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white">
                        <NuxtLink to="#">Equipe</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white">
                        <NuxtLink to="#">Orçamento</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white">
                        <NuxtLink to="#">Contato</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white">
                        <NuxtLink to="#">Download</NuxtLink>
                    </li>
                </ul>

                <NuxtLink to="/login" class="p-0 m-0 hidden lg:block">
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
                    <span @click="menuAberto = !menuAberto" class="text-neutral-300 hover:text-white flex items-center cursor-pointer">
                        <Icon name="mdi:close" size="1.75rem" />
                    </span>
                </div>

                <ul class="text-base flex flex-col gap-5 font-normal uppercase text-neutral-300 ps-3 pe-24">
                    <li class="hover:text-white"><a href="#">Guia</a></li>
                    <li class="hover:text-white"><a href="#">Equipe</a></li>
                    <li class="hover:text-white"><a href="#">Orçamento</a></li>
                    <li class="hover:text-white"><a href="#">Contato</a></li>
                    <li class="hover:text-white"><a href="#">Download</a></li>
                </ul>

                <NuxtLink to="/login">
                    <WhiteButton class="mt-12 w-full">Entrar</WhiteButton>
                </NuxtLink>
            </div>
        </nav>

        <section class="flex items-center mt-24">

            <header class="text-center max-w-3xl mx-auto">
                <h1 class="text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Desenvolvimento <br />
                    <span id="trocaCor" class="text-gradient bg-gradient-to-r font-mono" :class="gradientColor">
                        &lt;re-imaginado/&gt;
                    </span>
                </h1>
                <p class="text-lg md:text-2xl font-light px-3 md:px-0">
                    TaskUnity é um site que permite você encontrar e unir pessoas para desenvolver projetos.
                    Monte uma equipe e faça acontecer!
                </p>
                <WhiteButton class="mt-12">Começe já</WhiteButton>
            </header>

            <BlueBlob class="bottom-1/4 right-3/4 animate-ping" />
            <GreenBlob class="bottom-2/4 right-2/4 animate-ping" />
            <RedBlob class="top-2/4 left-2/4 animate-ping" />
            <YellowBlob class="bottom-1/4 left-3/4 animate-ping" />

            <BlueBlob class="bottom-1/4 right-3/4 animate-spin"/>
            <GreenBlob class="bottom-2/4 right-2/4 animate-spin"/>
            <RedBlob class="top-2/4 left-2/4 animate-spin"/>
            <YellowBlob class="bottom-1/4 left-3/4 animate-spin"/>

        </section>

        <section class="flex items-center">

            <header class="text-center max-w-3xl mx-auto">
                <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Guia
                </h1>
                <p class="text-lg md:text-2xl font-extralight text-neutral-200 px-3 md:px-0">
                    Mini tutorial sobre o funcionamento do site.
                </p>
                <WhiteButton class="mt-12 w-36">
                    <Icon name="solar:notebook-minimalistic-line-duotone" size="1.75rem" />
                </WhiteButton>
            </header>

        </section>

        <section class="flex items-center">

            <header class="text-center max-w-3xl mx-auto">
                <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Equipe
                </h1>
                <p class="text-lg md:text-2xl font-extralight text-neutral-200 px-3 md:px-0">
                    Integrantes do grupo
                </p>
                <WhiteButton class="mt-12 w-36">
                    <Icon name="solar:users-group-two-rounded-line-duotone" size="1.75rem" />
                </WhiteButton>
            </header>

            <BlueBlob class="bottom-1/4 right-3/4 animate-ping" />
            <GreenBlob class="bottom-2/4 right-2/4 animate-ping" />
            <RedBlob class="top-2/4 left-2/4 animate-ping" />
            <YellowBlob class="bottom-1/4 left-3/4 animate-ping" />
            
            <BlueBlob class="bottom-1/4 right-3/4 animate-spin"/>
            <GreenBlob class="bottom-2/4 right-2/4 animate-spin"/>
            <RedBlob class="top-2/4 left-2/4 animate-spin"/>
            <YellowBlob class="bottom-1/4 left-3/4 animate-spin"/>

        </section>

        <section class="flex items-center">

            <header class="text-center max-w-3xl mx-auto">
                <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Orçamento
                </h1>
                <p class="text-lg md:text-2xl font-extralight text-neutral-200 px-3 md:px-0">
                    Preço médio de um projeto e como é calculado seu valor
                </p>
                <WhiteButton class="mt-12 w-36">
                    <Icon name="solar:money-bag-line-duotone" size="1.75rem" />
                </WhiteButton>
            </header>

        </section>

        <section class="flex items-center">

            <header class="text-center max-w-3xl mx-auto">
                <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Contato
                </h1>
                <p class="text-lg md:text-2xl font-extralight text-neutral-200 px-3 md:px-0">
                    Entrar em contato com nossa equipe
                </p>
                <WhiteButton class="mt-12 w-36">
                    <Icon name="solar:phone-rounded-line-duotone" size="1.75rem" />
                </WhiteButton>
            </header>

            <BlueBlob class="bottom-1/4 right-3/4 animate-ping" />
            <GreenBlob class="bottom-2/4 right-2/4 animate-ping" />
            <RedBlob class="top-2/4 left-2/4 animate-ping" />
            <YellowBlob class="bottom-1/4 left-3/4 animate-ping" />
            
            <BlueBlob class="bottom-1/4 right-3/4 animate-spin"/>
            <GreenBlob class="bottom-2/4 right-2/4 animate-spin"/>
            <RedBlob class="top-2/4 left-2/4 animate-spin"/>
            <YellowBlob class="bottom-1/4 left-3/4 animate-spin"/>

        </section>

        <section class="flex items-center">

            <header class="text-center max-w-3xl mx-auto">
                <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Download
                </h1>
                <p class="text-lg md:text-2xl font-extralight text-neutral-200 px-3 md:px-0">
                    Ir para o repositório do projeto
                </p>
                <WhiteButton class="mt-12 w-36">
                    <Icon name="solar:download-minimalistic-bold-duotone" size="1.75rem" />
                </WhiteButton>
            </header>

        </section>

        <!-- * Efeito de escurecer a tela -->
        <div @click="menuAberto = !menuAberto" :class="{ 'hidden': !menuAberto, 'block': menuAberto }"
            class="escurecer fixed inset-0 bg-neutral-900 opacity-50 z-10"></div>
    </main>
</template>

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
    backdrop-filter: blur(10px);
    -webkit-backdrop-filter: blur(10px);
}

#menuMobile {
    filter: blur(5px);
    box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
    backdrop-filter: blur(10px);
    -webkit-backdrop-filter: blur(10px);
    border-left: 1px solid rgba(255, 255, 255, 0.10);
    transform: translate(100%) scaleX(75%);
    transition: all .5s cubic-bezier(0.075, 0.82, 0.165, 1);
    -webkit-transition: all .5s cubic-bezier(0.075, 0.82, 0.165, 1);
    -moz-transition: all .5s cubic-bezier(0.075, 0.82, 0.165, 1);
    -ms-transition: all .5s cubic-bezier(0.075, 0.82, 0.165, 1);
    -o-transition: all .5s cubic-bezier(0.075, 0.82, 0.165, 1);
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
    height: 75vh;
    max-height: 720px;
    transition: all 1s ease;
}

nav {
    transition: all 1s ease;
    border-bottom-color:  rgba(255, 255, 255, 0.10);
}

.text-border {
    -webkit-text-stroke-width: 1px;
    -webkit-text-stroke-color: #fafafa;
}

.escurecer.block {
    animation: fade 1s ease;
}

@keyframes fade {
    from {
        opacity: 0;
    }

    to {
        opacity: .5;
    }
}

@media screen and (max-width: 440px) {
    header h1 {
        font-size: 2.5rem;
        line-height: 2.5rem;
    }
}
</style>