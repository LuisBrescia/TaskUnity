<script setup>

const gradientColor = ref("from-red-500 via-rose-500 to-pink-500")
let index = 0

setInterval(() => {
    const colors = [
        "from-indigo-500 via-sky-500 to-cyan-500",
        "from-emerald-500 via-green-500 to-lime-500",
        "from-yellow-500 via-amber-500 to-orange-500",
        "from-red-500 via-rose-500 to-pink-500"
    ]
    gradientColor.value = colors[index]
    if (index < colors.length - 1) index++
    else index = 0
}, 750);

const menuAberto = ref(false);

</script>

<template>
    <div class="xl:px-24 xl:mb-12">
        <main class="xl:mt-12 overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <nav class="xl:border-b border-neutral-200 mx-auto py-3 px-5 xl:p-8 flex items-center justify-between">

                <h1 class="text-2xl lg:text-4xl font-black tracking-tight text-neutral-50 cursor-pointer borda-texto">
                    TASK<span class="text-transparent tracking-normal">UNITY</span>
                </h1>

                <ul class="text-base text-neutral-200 hidden lg:block">
                    <li class="inline-block mx-5 hover:text-white hover:-skew-x-12">
                        <NuxtLink to="#">Guia</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white hover:-skew-x-12">
                        <NuxtLink to="#">Equipe</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white hover:-skew-x-12">
                        <NuxtLink to="#">Orçamento</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white hover:-skew-x-12">
                        <NuxtLink to="#">Contato</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white hover:-skew-x-12">
                        <NuxtLink to="#">Download</NuxtLink>
                    </li>
                </ul>

                <NuxtLink to="/login" class="p-0 m-0 hidden lg:block">
                    <WhiteButton>Entrar</WhiteButton>
                </NuxtLink>

                <div @click="menuAberto = !menuAberto" class="lg:hidden cursor-pointer">
                    <Icon name="solar:hamburger-menu-outline" color="white" size="2rem" />
                </div>

                <!-- * Menu mobile-->
                <div id="menu" :class="{ 'pointer-events-none': !menuAberto, 'active': menuAberto }"
                    class="lg:opacity-0 absolute text-neutral-100 top-0 right-0 z-20 p-4 h-screen">

                    <div class="flex items-center gap-2 mb-12 text-xl justify-between ps-3">
                        <span class="text-xl font-bold tracking-widest">MENU</span>
                        <span @click="menuAberto = !menuAberto" class="flex items-center cursor-pointer">
                            <Icon name="mdi:close" size="1.75rem" />
                        </span>
                    </div>

                    <ul class="text-base flex flex-col gap-5 font-normal uppercase text-neutral-200 ps-3 pe-24">
                        <li class="hover:text-white hover:-skew-x-12"><a href="#">Guia</a></li>
                        <li class="hover:text-white hover:-skew-x-12"><a href="#">Equipe</a></li>
                        <li class="hover:text-white hover:-skew-x-12"><a href="#">Orçamento</a></li>
                        <li class="hover:text-white hover:-skew-x-12"><a href="#">Contato</a></li>
                        <li class="hover:text-white hover:-skew-x-12"><a href="#">Download</a></li>
                    </ul>

                    <NuxtLink to="/login">
                        <WhiteButton class="mt-12 w-full">Entrar</WhiteButton>
                    </NuxtLink>
                </div>

                <div @click="menuAberto = !menuAberto" :class="{ 'hidden': !menuAberto, 'block': menuAberto }"
                    class="escurecer fixed inset-0 bg-neutral-900 opacity-50 z-10">
                </div>
            </nav>
            <section class="mx-auto flex items-center xl:border-t border-neutral-200">

                <header class="text-center max-w-3xl mx-auto">
                    <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tight font-black mb-12">
                        Desenvolvimento <br />
                        <span id="trocaCor" class="text-gradient bg-gradient-to-r" :class="gradientColor">
                            &lt; re-imaginado /&gt;
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

        <main class="xl:mt-12 overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <section class="mx-auto flex items-center xl:border-t border-neutral-200">

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

        <main class="xl:mt-12 overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <section class="mx-auto flex items-center xl:border-t border-neutral-200">

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

        <main class="xl:mt-12 overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <section class="mx-auto flex items-center xl:border-t border-neutral-200">

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

        <main class="xl:mt-12 overflow-hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <section class="mx-auto flex items-center xl:border-t border-neutral-200">

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

        <main class="overflow-xl:mt-12 hidden xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <section class="mx-auto flex items-center xl:border-t border-neutral-200">

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
    width: 60%;
}

#menu {
    filter: blur(5px);
    background: linear-gradient(to right, #22c55e11 1%, transparent 25%, transparent 75%, #eab30811 100%);
    box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
    backdrop-filter: blur(7.5px);
    -webkit-backdrop-filter: blur(7.5px);
    border-left: 1px solid rgba(255, 255, 255, 0.10);
    transform: translate(100%) scaleX(75%);
    transition: all .5s cubic-bezier(0.075, 0.82, 0.165, 1);
    -webkit-transition: all .5s cubic-bezier(0.075, 0.82, 0.165, 1);
    -moz-transition: all .5s cubic-bezier(0.075, 0.82, 0.165, 1);
    -ms-transition: all .5s cubic-bezier(0.075, 0.82, 0.165, 1);
    -o-transition: all .5s cubic-bezier(0.075, 0.82, 0.165, 1);
}

#menu.active {
    filter: blur(0px);
    transform: translate(0);
}

#menu li::after {
    margin-left: 0;
}

#menu ul li:hover::after {
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