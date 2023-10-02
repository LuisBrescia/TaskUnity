<template>
    <main class="flex">
        <div class="flex flex-col w-fit h-screen p-5 gap-5 uppercase">
            <NuxtLink class="hover:bg-rose-500 p-3 rounded-md" to="/profile">Profile</NuxtLink>
            <NuxtLink class="hover:bg-rose-500 p-3 rounded-md" to="/tasks">Tasks</NuxtLink>
            <NuxtLink class="hover:bg-rose-500 p-3 rounded-md" to="/projects">Projects</NuxtLink>
            <NuxtLink class="hover:bg-rose-500 p-3 rounded-md" to="/">Sair</NuxtLink>
        </div>
        <div class="w-full flex justify-center items-center">
            <slot />

        </div>
    </main>
</template>