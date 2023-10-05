<script setup>

const gradientColor = ref("from-red-500 via-rose-300 to-pink-500");
const fonteAlternativa = ref("font-sans");
let indexCor = 0, indexFonte = 0;

const colors = [
    "from-indigo-500 via-sky-300 to-cyan-500",
    "from-emerald-500 via-green-300 to-lime-500",
    "from-yellow-500 via-amber-300 to-orange-500",
    "from-red-500 via-rose-300 to-pink-500"
]
const fonts = [
    "font-sans",
    "font-serif",
    "font-mono"
]

setInterval(() => {

    gradientColor.value = colors[indexCor]
    fonteAlternativa.value = fonts[indexFonte]

    if (indexCor < colors.length - 1) indexCor++
    else indexCor = 0

    if (indexFonte < fonts.length - 1) indexFonte++
    else indexFonte = 0

}, 750);

const menuAberto = ref(false);

</script>

<template>
    <div class="xl:px-24 xl:mb-12 bg-black xl:bg-white">
        <nav class="xl:mt-12 xl:container mx-auto xl:bg-black sticky top-0 z-30 xl:rounded-t shadow">
            <!-- * Menu fixo -->
            <div class="relative overflow-hidden flex items-center justify-between p-3 lg:p-5 xl:rounded-t" id="menuFixo">
                <h1
                    class="text-2xl lg:text-4xl font-black tracking-tight text-neutral-50 cursor-pointer borda-texto font-sans">
                    TASK<span class="text-transparent tracking-normal">UNITY</span>
                </h1>

                <ul class="text-base text-neutral-200 hidden lg:block">
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

                <BlueBlob class="bottom-0 right-0 hidden TEST-xl:inline" />
                <RedBlob class="bottom-0 left-0 hidden TEST-xl:inline" />
                <YellowBlob class="bottom-1/2 hidden TEST-xl:inline" style="left:27.5%" />
                <GreenBlob class="top-1/2 hidden TEST-xl:inline" style="right:27.5%" />
            </div>

            <!-- * Menu mobile-->
            <div id="menuMobile" :class="{ 'pointer-events-none': !menuAberto, 'active': menuAberto }"
                class="lg:opacity-0 absolute text-neutral-100 top-0 right-0 z-50 p-4 h-screen">

                <div class="flex items-center gap-2 mb-12 text-xl justify-between ps-3">
                    <span class="text-xl font-bold tracking-widest">MENU</span>
                    <span @click="menuAberto = !menuAberto" class="flex items-center cursor-pointer">
                        <Icon name="mdi:close" size="1.75rem" />
                    </span>
                </div>

                <ul class="text-base flex flex-col gap-5 font-normal uppercase text-neutral-200 ps-3 pe-24">
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

            <!-- * Escurecer -->
            <div @click="menuAberto = !menuAberto" :class="{ 'hidden': !menuAberto, 'block': menuAberto }"
                class="escurecer fixed inset-0 bg-neutral-900 opacity-50 z-10">
            </div>
        </nav>

        <main class="overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded-b h-screen">
            <section class="mx-auto flex items-center">

                <header class="text-center max-w-3xl mx-auto">
                    <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                        Desenvolvimento <br />
                        <span id="trocaCor" class="text-gradient bg-gradient-to-r font-mono" :class="gradientColor">
                            &lt;<span id="trocaFonte" :class="fonteAlternativa">re-imaginado</span>/&gt;
                        </span>
                    </h1>
                    <p class="text-lg md:text-2xl font-extralight text-neutral-200 px-3 md:px-0">
                        TaskUnity é um site que permite você encontrar e unir pessoas para desenvolver projetos.
                        Monte uma equipe e faça acontecer!
                    </p>
                    <WhiteButton class="mt-12">Começe já</WhiteButton>
                </header>

                <BlueBlob class="bottom-1/4 right-3/4" />
                <GreenBlob class="bottom-2/4 right-2/4" />
                <RedBlob class="top-2/4 left-2/4" />
                <YellowBlob class="bottom-1/4 left-3/4" />

            </section>
        </main>

        <main class="xl:mt-12 xl:overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <section class="mx-auto flex items-center">

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

                <RedBlob class="bottom-1/4 left-3/4" />
                <BlueBlob class="bottom-2/4 left-2/4" />
                <YellowBlob class="top-2/4 right-2/4" />
                <GreenBlob class="bottom-1/4 right-3/4" />

            </section>
        </main>

        <main class="xl:mt-12 xl:overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <section class="mx-auto flex items-center">

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

                <RedBlob class="bottom-1/4 right-3/4" />
                <YellowBlob class="bottom-2/4 right-2/4" />
                <BlueBlob class="top-2/4 left-2/4" />
                <GreenBlob class="bottom-1/4 left-3/4" />

            </section>
        </main>

        <main class="xl:mt-12 xl:overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <section class="mx-auto flex items-center">

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

                <RedBlob class="bottom-1/4 left-3/4" />
                <YellowBlob class="bottom-2/4 left-2/4" />
                <BlueBlob class="top-2/4 right-2/4" />
                <GreenBlob class="bottom-1/4 right-3/4" />

            </section>
        </main>

        <main class="xl:mt-12 xl:overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <section class="mx-auto flex items-center">

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

                <RedBlob class="bottom-1/4 right-3/4" />
                <BlueBlob class="bottom-2/4 right-2/4" />
                <GreenBlob class="top-2/4 left-2/4" />
                <YellowBlob class="bottom-1/4 left-3/4" />


            </section>
        </main>

        <main class="xl:mt-12 xl:overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <section class="mx-auto flex items-center">

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

                <RedBlob class="bottom-1/4 left-3/4" />
                <BlueBlob class="bottom-2/4 left-2/4" />
                <GreenBlob class="top-2/4 right-2/4" />
                <YellowBlob class="bottom-1/4 right-3/4" />

            </section>
        </main>
    </div>
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

#menuFixo:first-child {
    backdrop-filter: blur(10px);
    -webkit-backdrop-filter: blur(10px);
    border-bottom: 1px solid rgba(255, 255, 255, 0.25);
}

#menuMobile {
    filter: blur(5px);
    box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
    backdrop-filter: blur(10px);
    -webkit-backdrop-filter: blur(10px);
    border-left: 1px solid rgba(255, 255, 255, 0.25);
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

main {
    transform: skewX(0deg);
    transition: all 1s ease;
    background-color: black;
}

section {
    position: relative;
    height: 75vh;
    max-height: 720px;
    transition: all 1s ease;
}

nav {
    transition: all 1s ease;
}

.borda-texto {
    -webkit-text-stroke-width: 1px;
    -webkit-text-stroke-color: #fafafa;
}

@media screen and (max-width: 440px) {
    header h1 {
        font-size: 2.5rem;
        line-height: 2.5rem;
    }
}

/* 
<span class="text-gradient bg-gradient-to-r from-indigo-500 via-sky-500 to-cyan-500">TA</span>
<span class="text-gradient bg-gradient-to-r from-emerald-500 via-green-500 to-lime-500">SK</span>
<span class="text-gradient bg-gradient-to-r from-yellow-500 via-amber-500 to-orange-500">UNI</span>
<span class="text-gradient bg-gradient-to-r from-red-500 via-rose-500 to-pink-500">TY</span> 
*/
</style>