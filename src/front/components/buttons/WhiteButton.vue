<template>
    <button class="font-bold text-sm md:text-base border-2
    px-5 pt-3 pb-3 rounded-full
    text-white border-white hover:border-green-300 hover:text-green-300 
    uppercase tracking-widest">
        <slot />
    </button>
</template>

<style scoped>
button {
    transition: all 0.2s ease;
    position: relative;
    overflow: hidden;
    transition: all 0.2s ease;
    background: linear-gradient(to right, #0ea5e940 1%, transparent 40%, transparent 60%, #be627240 100%);
}

button:hover {
    transform: translateY(-2px);
}

button:active {
    transform: translateY(0);
}

button::before {
    filter: blur(25px);
    content: "";
    position: absolute;
    left: -5rem;
    width: 4rem;
    height: 100%;
    top: 0;
    background: linear-gradient(to right, transparent 1%, #eab308 40%, #eab308 60%, transparent 100%);
    opacity: .5;
    transition: transform 1.5s ease;
}

button:hover::before {
    transform: translateX(16rem);
}
</style>
