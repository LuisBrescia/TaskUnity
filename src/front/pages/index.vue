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
    <div class="xl:px-24">
        <main class="overflow-hidden xl:mt-12 xl:h-fit xl:container mx-auto shadow-2xl shadow-black xl:rounded h-screen">
            <nav class="xl:border-b border-neutral-200 mx-auto py-3 px-5 xl:p-8 flex items-center justify-between">

                <h1 class="text-2xl lg:text-4xl font-black tracking-tight text-neutral-50 cursor-pointer borda-texto">
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
                    <Icon name="solar:sort-horizontal-line-duotone" color="white" size="2rem" />
                </div>

                <div id="menu" :class="{ 'pointer-events-none': !menuAberto, 'active': menuAberto }"
                    class=" lg:opacity-0 absolute text-neutral-100 top-0 right-0 z-20 p-4">

                    <div class="flex items-center gap-2 mb-5 text-xl justify-between ps-3">
                        <span class="text-xl font-bold tracking-widest">MENU</span>
                        <span @click="menuAberto = !menuAberto" class="flex items-center cursor-pointer">
                            <Icon name="mdi:close" size="1.75rem" />
                        </span>
                    </div>

                    <ul class="text-sm flex flex-col gap-4 font-extralight uppercase text-neutral-200 ps-3 pe-24">
                        <li class="hover:text-white"><a href="#">Guia</a></li>
                        <li class="hover:text-white"><a href="#">Equipe</a></li>
                        <li class="hover:text-white"><a href="#">Orçamento</a></li>
                        <li class="hover:text-white"><a href="#">Contato</a></li>
                        <li class="hover:text-white"><a href="#">Download</a></li>
                    </ul>

                    <NuxtLink to="/login">
                        <WhiteButton class="mt-6 w-full">Entrar</WhiteButton>
                    </NuxtLink>
                </div>

                <div @click="menuAberto = !menuAberto" :class="{ 'hidden': !menuAberto, 'block': menuAberto }"
                    class="escurecer fixed inset-0 bg-black opacity-25 z-10">
                </div>
            </nav>

            <section class="mx-auto flex items-center">

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

#menu {
    filter: blur(5px);
    background: linear-gradient(to right, #22c55e11 1%, transparent 25%, transparent 75%, #eab30811 100%);
    box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
    backdrop-filter: blur(7.5px) brightness(1.2);
    -webkit-backdrop-filter: blur(7.5px);
    border-bottom: 1px solid rgba(255, 255, 255, 0.15);
    border-left: 1px solid rgba(255, 255, 255, 0.15);
    border-radius: 0 0 0 1rem;
    transform: translate(100%);
    transition: all 1s cubic-bezier(0.075, 0.82, 0.165, 1);
}

#menu.active {
    filter: blur(0px);
    transform: translate(0);
}

#menu li::after {
    margin-left: 0;
}

#menu ul li:hover::after {
    width: 5%;
}

.escurecer.block {
    animation: fade 1s ease;
}

@keyframes fade {
    from {
        opacity: 0;
    }

    to {
        opacity: .25;
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

.borda-texto{
-webkit-text-stroke-width: 1px;
-webkit-text-stroke-color: #fff;
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