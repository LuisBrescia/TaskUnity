<template>
    <button class="font-bold text-sm md:text-base
    px-5 pt-3 pb-3 rounded-full 
    uppercase tracking-widest shadow flex items-center justify-center">
        <slot />
    </button>
</template>

<style scoped>
button {
    transition: all .5s ease;
    position: relative;
    overflow: hidden;
    border: 2px solid #ffffff1a;
    color: #fff;
}

button.disabled {
    border: 2px solid #ffffff1a;
    color: #ffffff1d;
}

button:hover {
    transform: translateY(-0.25rem);
    border-color: rgba(255, 255, 255, 0.2);
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
