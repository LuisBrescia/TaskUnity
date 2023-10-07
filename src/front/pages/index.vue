<script setup>

const menuAberto = ref(false);
const isScrolling = ref(false);
const gradientColor = ref("from-red-400 via-rose-500 to-pink-400");
const fonteAlternativa = ref("font-sans");
let indexCor = 0, indexFonte = 0;

const colors = [
    "from-indigo-400 via-sky-500 to-cyan-400",
    "from-emerald-400 via-green-500 to-lime-400",
    "from-yellow-400 via-amber-500 to-orange-400",
    "from-red-400 via-rose-500 to-pink-400"
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

        <nav class="fixed top-0 z-30 w-full" :class="{ 'nav-blur': isScrolling }">
            <!-- * Menu fixo -->
            <div class="container mx-auto relative overflow-hidden flex items-center justify-between p-3 lg:p-5 xl:rounded-t"
                id="menuFixo">
                <h1
                    class="text-2xl font-black tracking-tight text-neutral-50 cursor-pointer text-border font-sans flex items-center">
                    <Icon name="iconamoon:3d-light" color="white" size="2.75rem" />
                    <span>&nbsp;TASK</span>
                    <span class="text-transparent tracking-normal">UNITY</span>
                </h1>

                <ul class="text-base hidden lg:block">
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
                    <span @click="menuAberto = !menuAberto"
                        class="text-neutral-300 hover:text-white flex items-center cursor-pointer">
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

        <section class="flex items-center">

            <div class="container flex flex-col xl:flex-row items-center mx-auto gap-5 xl:gap-12">

                <div class="flex w-full">
                    <article class="flex-1 rounded-3xl text-center shadow-lg p-5 hidden xl:block">
                        <Icon name="cryptocurrency-color:btg" size="2rem" />
                        <div class="text-xs tracking-wide font-thin mt-3 opacity-50">Seja um</div>
                        <h3 class="text-base uppercase font-bold tracking-widest">Tasker</h3>
                    </article>
                </div>

                <div class="flex w-full">
                    <header class="flex-1 text-center py-8 px-0 md:px-5 sm:rounded-3xl shadow-lg">
                        <h1 class="text-5xl md:text-7xl tracking-tighter font-black mb-12">
                            Desenvolvimento <br />
                            <span class="text-gradient bg-gradient-to-r font-mono" :class="gradientColor">
                                &lt;re-imaginado/&gt;
                            </span>
                        </h1>
                        <p class="text-lg md:text-2xl font-light px-3 md:px-0 max-w-3xl mx-auto">
                            TaskUnity é um site que permite você encontrar e unir pessoas para desenvolver projetos.
                            Monte uma equipe e faça acontecer!
                        </p>
                        <div class="flex gap-5 justify-center">
                            <WhiteButton class="mt-12">Começe agora</WhiteButton>
                        </div>
                    </header>
                </div>

                <div class="flex w-full sm:gap-5 flex-wrap">
                    <article class="flex-1 sm:rounded-3xl text-center shadow-lg p-5 xl:hidden block">
                        <Icon name="cryptocurrency-color:btg" size="2rem" />
                        <div class="text-xs tracking-wide font-thin mt-3 opacity-50">Seja um</div>
                        <h3 class="text-base uppercase font-bold tracking-widest">Tasker</h3>
                    </article>

                    <article class="flex-1 sm:rounded-3xl text-center shadow-lg p-5">
                        <Icon name="cryptocurrency-color:chsb" size="2rem" />
                        <div class="text-xs tracking-wide font-thin mt-3 opacity-50">Seja um</div>
                        <h3 class="text-base uppercase font-bold tracking-widest">MANAGER</h3>
                    </article>
                </div>

            </div>

            <RedBlob class="left-3/4 animate-ping" style="bottom: 20%" />
            <RedBlob class="left-3/4 animate-spin" style="bottom: 20%" />

            <YellowBlob class="animate-ping" style="top: 65%; left: 55%;" />
            <YellowBlob class="animate-spin" style="top: 65%; left: 55%;" />

            <GreenBlob class="animate-ping" style="bottom: 65%; right: 55%;" />
            <GreenBlob class="animate-spin" style="bottom: 65%; right: 55%;" />

            <BlueBlob class="right-3/4 animate-ping" style="top: 20%" />
            <BlueBlob class="right-3/4 animate-spin" style="top: 20%" />

        </section>

        <section id="taskers">

            <h1 class="mb-12 text-center text-5xl md:text-7xl font-black text-gradient bg-gradient-to-r font-mono tracking-tighter"
                :class="gradientColor">
                &lt;Taskers/&gt;
            </h1>
            <!-- <div class="text-center font-light mt-3 mb-12 text-2xl text-neutral-200">
                Exemplos de prestadores de serviços
            </div> -->

            <div class="container mx-auto" id="scroll">
                <div class="flex gap-5 py-5" id="scroll-inner">

                    <article class="border rounded-3xl p-5 text-start shadow">
                        <div class=" bg-white opacity-5 rounded-full mb-3 h-24 aspect-square"></div>
                        <div class="text-2xl font-black tracking-wider">André Hyodo</div>
                        <div class="text-lg text-neutral-200 uppercase font-light">Dublador</div>
                        <div class="text-base mt-3 max-w-xs">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dignissimos reiciendis adipisci cum
                            id,
                            officia dicta?
                        </div>
                    </article>

                    <article class="border rounded-3xl p-5 text-start shadow">
                        <div class=" bg-white opacity-5 rounded-full mb-3 h-24 aspect-square"></div>
                        <div class="text-2xl font-black tracking-wider">Gustavo Pereira</div>
                        <div class="text-lg text-neutral-200 uppercase font-light">Desenvolvedor java</div>
                        <div class="text-base mt-3 max-w-xs">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dignissimos reiciendis adipisci cum
                            id,
                            officia dicta?
                        </div>
                    </article>

                    <article class="border rounded-3xl p-5 text-start shadow">
                        <div class=" bg-white opacity-5 rounded-full mb-3 h-24 aspect-square"></div>
                        <div class="text-2xl font-black tracking-wider">Luís Brescia</div>
                        <div class="text-lg text-neutral-200 uppercase font-light">Designer Gráfico</div>
                        <div class="text-base mt-3 max-w-xs">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dignissimos reiciendis adipisci cum
                            id,
                            officia dicta?
                        </div>
                    </article>

                    <article class="border rounded-3xl p-5 text-start shadow">
                        <div class=" bg-white opacity-5 rounded-full mb-3 h-24 aspect-square"></div>
                        <div class="text-2xl font-black tracking-wider">Luiz Campos</div>
                        <div class="text-lg text-neutral-200 uppercase font-light">Fotógrafo</div>
                        <div class="text-base mt-3 max-w-xs">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dignissimos reiciendis adipisci cum
                            id,
                            officia dicta?
                        </div>
                    </article>

                    <article class="border rounded-3xl p-5 text-start shadow">
                        <div class=" bg-white opacity-5 rounded-full mb-3 h-24 aspect-square"></div>
                        <div class="text-2xl font-black tracking-wider">Marcus Viniciús</div>
                        <div class="text-lg text-neutral-200 uppercase font-light">Desenvolvedor Mobile</div>
                        <div class="text-base mt-3 max-w-xs">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dignissimos reiciendis adipisci cum
                            id,
                            officia dicta?
                        </div>
                    </article>

                    <article class="border rounded-3xl p-5 text-start shadow">
                        <div class=" bg-white opacity-5 rounded-full mb-3 h-24 aspect-square"></div>
                        <div class="text-2xl font-black tracking-wider">André Hyodo</div>
                        <div class="text-lg text-neutral-200 uppercase font-light">Dublador</div>
                        <div class="text-base mt-3 max-w-xs">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dignissimos reiciendis adipisci cum
                            id,
                            officia dicta?
                        </div>
                    </article>

                    <article class="border rounded-3xl p-5 text-start shadow">
                        <div class=" bg-white opacity-5 rounded-full mb-3 h-24 aspect-square"></div>
                        <div class="text-2xl font-black tracking-wider">Gustavo Pereira</div>
                        <div class="text-lg text-neutral-200 uppercase font-light">Desenvolvedor java</div>
                        <div class="text-base mt-3 max-w-xs">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dignissimos reiciendis adipisci cum
                            id,
                            officia dicta?
                        </div>
                    </article>

                    <article class="border rounded-3xl p-5 text-start shadow">
                        <div class=" bg-white opacity-5 rounded-full mb-3 h-24 aspect-square"></div>
                        <div class="text-2xl font-black tracking-wider">Luís Brescia</div>
                        <div class="text-lg text-neutral-200 uppercase font-light">Designer Gráfico</div>
                        <div class="text-base mt-3 max-w-xs">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dignissimos reiciendis adipisci cum
                            id,
                            officia dicta?
                        </div>
                    </article>

                    <article class="border rounded-3xl p-5 text-start shadow">
                        <div class=" bg-white opacity-5 rounded-full mb-3 h-24 aspect-square"></div>
                        <div class="text-2xl font-black tracking-wider">Luiz Campos</div>
                        <div class="text-lg text-neutral-200 uppercase font-light">Fotógrafo</div>
                        <div class="text-base mt-3 max-w-xs">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dignissimos reiciendis adipisci cum
                            id,
                            officia dicta?
                        </div>
                    </article>

                    <article class="border rounded-3xl p-5 text-start shadow">
                        <div class=" bg-white opacity-5 rounded-full mb-3 h-24 aspect-square"></div>
                        <div class="text-2xl font-black tracking-wider">Marcus Viniciús</div>
                        <div class="text-lg text-neutral-200 uppercase font-light">Desenvolvedor Mobile</div>
                        <div class="text-base mt-3 max-w-xs">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dignissimos reiciendis adipisci cum
                            id,
                            officia dicta?
                        </div>
                    </article>

                </div>
            </div>
        </section>

        <section class="flex items-center">

            <header class="text-center max-w-3xl mx-auto p-8 rounded-3xl shadow-lg">
                <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Guia
                </h1>
                <p class="text-lg md:text-2xl font-light px-3 md:px-0">
                    Mini tutorial sobre o funcionamento do site.
                </p>
                <WhiteButton class="mt-12 w-36">
                    <Icon name="solar:notebook-minimalistic-line-duotone" size="1.75rem" />
                </WhiteButton>
            </header>

        </section>

        <section class="flex items-center">

            <header class="text-center max-w-3xl mx-auto p-8 rounded-3xl shadow-lg">
                <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Equipe
                </h1>
                <p class="text-lg md:text-2xl font-light px-3 md:px-0">
                    Integrantes do grupo
                </p>
                <WhiteButton class="mt-12 w-36">
                    <Icon name="solar:users-group-two-rounded-line-duotone" size="1.75rem" />
                </WhiteButton>
            </header>

        </section>

        <section class="flex items-center">

            <header class="text-center max-w-3xl mx-auto p-8 rounded-3xl shadow-lg">
                <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Orçamento
                </h1>
                <p class="text-lg md:text-2xl font-light px-3 md:px-0">
                    Preço médio de um projeto e como é calculado seu valor
                </p>
                <WhiteButton class="mt-12 w-36">
                    <Icon name="solar:money-bag-line-duotone" size="1.75rem" />
                </WhiteButton>
            </header>

        </section>

        <section class="flex items-center">

            <header class="text-center max-w-3xl mx-auto p-8 rounded-3xl shadow-lg">
                <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Contato
                </h1>
                <p class="text-lg md:text-2xl font-light px-3 md:px-0">
                    Entrar em contato com nossa equipe
                </p>
                <WhiteButton class="mt-12 w-36">
                    <Icon name="solar:phone-rounded-line-duotone" size="1.75rem" />
                </WhiteButton>
            </header>

        </section>

        <section class="flex items-center">

            <header class="text-center max-w-3xl mx-auto p-8 rounded-3xl shadow-lg">
                <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                    Download
                </h1>
                <p class="text-lg md:text-2xl font-light px-3 md:px-0">
                    Ir para o repositório do projeto
                </p>
                <WhiteButton class="mt-12 w-36">
                    <Icon name="solar:download-minimalistic-bold-duotone" size="1.75rem" />
                </WhiteButton>
            </header>

        </section>

        <!-- * Efeito de escurecer a tela -->
        <div @click="menuAberto = !menuAberto" :class="{ 'hidden': !menuAberto, 'block': menuAberto }"
            class="escurecer fixed inset-0 bg-black opacity-80 z-10"></div>
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
    backdrop-filter: blur(25px) brightness(0.75);
    -webkit-backdrop-filter: blur(25px) brightness(0.75);
    border-bottom: 2px solid #ffffff1a;
}

#menuMobile {
    filter: blur(5px);
    background: linear-gradient(144deg, rgb(0, 0, 15), rgb(0, 15, 15), rgb(15, 0, 15));
    /* backdrop-filter: blur(10px);
    -webkit-backdrop-filter: blur(10px); */
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
    min-height: 100vh;
}

header {
    width: 50rem;
}

#taskers article {
    min-width: 364px;
    backdrop-filter: blur(50px) brightness(0.75) !important;
    -webkit-backdrop-filter: blur(50px) brightness(0.75) !important;
    background-color: rgba(0, 0, 0, .1);
}

#taskers article:hover {
    background-color: rgba(255, 255, 255, .01);
}

article {
    min-width: 10rem;
}

header,
article {
    backdrop-filter: blur(50px) brightness(0.75);
    -webkit-backdrop-filter: blur(50px) brightness(0.75);
    transition: all .5s ease;
    border-top: 2px solid #ffffff1a;
    border-bottom: 2px solid #ffffff1a;
}

header:hover,
article:hover {
    border-color: rgba(255, 255, 255, 0.2);
    background: rgba(255, 255, 255, 0.02);
    transform: translateY(-0.5rem);
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
        border-right: 2px solid #ffffff1a;
        border-left: 2px solid #ffffff1a;
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