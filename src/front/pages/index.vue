<template>

    <div class="xl:px-24">
        <main class="overflow-hidden my-12 h-fit container mx-auto shadow-2xl shadow-neutral-700">

            <nav class="border-b border-neutral-200 mx-auto p-5 flex items-center justify-between px-12 pt-8">

                <h1 class="text-4xl font-black tracking-tighter text-neutral-50">TASK<span class="font-normal">UNITY</span></h1>

                <ul class="text-base text-neutral-200 hidden md:block">
                    <li class="inline-block mx-5 hover:text-white">
                        <NuxtLink to="#">Guia</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white">
                        <NuxtLink to="#">Changelog</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white">
                        <NuxtLink to="#">Orçamento</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white">
                        <NuxtLink to="#">Extension</NuxtLink>
                    </li>
                    <li class="inline-block mx-5 hover:text-white">
                        <NuxtLink to="#">Download</NuxtLink>
                    </li>
                </ul>

                <NuxtLink to="/login" class="p-0 m-0">
                    <WhiteButton>Entrar</WhiteButton>
                </NuxtLink>
            </nav>

            <section class="mx-auto flex items-center">

                <header class="text-center max-w-3xl mx-auto">
                    <h1 class="text-neutral-50 text-5xl md:text-7xl tracking-tighter font-black mb-12">
                        Desenvolvimento <br />
                        re-imaginado
                    </h1>
                    <p class="text-lg md:text-2xl font-extralight  text-neutral-200 tracking-tight">
                        TaskUnity é um site que permite você encontrar e unir pessoas para desenvolver projetos.
                        Monte uma equipe e faça acontecer!
                    </p>
                    <WhiteButton class="mt-12">Começe já</WhiteButton>
                </header>

                <BlueBlob class="bottom-1/4 right-3/4" />
                <GreenBlob class="bottom-2/4 right-2/4" />
                <RedBlob class="top-2/4 left-2/4" />
                <YellowBlob class="top-1/4 left-3/4" />

            </section>
        </main>
    </div>

    <div class="container mx-auto">
        
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

main {
    transform: skewX(0);
    transition: all 1s ease;
    background-color: black;
    border-bottom-right-radius: 100%; 
    border-bottom-left-radius: 100%;
    border-top-right-radius: 10%;
    border-top-left-radius: 10%;
}

section {
    position: relative;
    height: 75vh;
    max-height: 720px;
}
</style>