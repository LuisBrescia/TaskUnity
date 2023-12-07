<template>
    <button class="font-bold text-sm md:text-base
    px-5 pt-3 pb-3 rounded 
    uppercase tracking-widest">
    <span class="flex items-center justify-center">
        <slot />
    </span>
    </button>
</template>

<style scoped>
button {
    transition: all .5s ease;
    position: relative;
    overflow: hidden;
    border: 2px solid rgba(244, 63, 94, 0.2);
    background-color: rgba(244, 63, 94, 0.1);
    color: #f43f5e;
}

button.disabled {
    border: 2px solid #f43f5e1a;
    color: #ffffff1d;
}

button:hover {
    transform: translateY(-0.25rem);
    border-color: rgba(244, 63, 94, 0.4);
    background-color: rgba(244, 63, 94, 0.2);
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
