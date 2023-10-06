<template>
    <button class="font-bold text-sm md:text-base border-2
    px-5 pt-3 pb-3 rounded-full
    text-white border-white 
    uppercase tracking-widest shadow">
        <slot />
    </button>
</template>

<style scoped>
button {
    transition: all 0.2s ease;
    position: relative;
    overflow: hidden;
    transition: all 0.2s ease;
    background: linear-gradient(to bottom, #ffffff1d, transparent, #ffffff1d);
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
    background: linear-gradient(to right, transparent 1%, #fff 40%, #fff 60%, transparent 100%);
    opacity: .2;
    transition: transform 1.5s ease;
}

button:hover::before {
    transform: translateX(16rem);
}
</style>
