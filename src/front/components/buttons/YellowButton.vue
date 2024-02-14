<template>
    <button class="font-bold text-sm md:text-base
    px-5 pt-3 pb-3 rounded-custom 
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
    border: 2px solid #eab30833;
    background-color: #eab3081a;
    color: #eab308;
}

button.disabled {
    border: 2px solid #eab3081a;
    color: #ffffff1d;
}

button:hover {
    transform: translateY(-0.25rem);
    border-color: #eab30866;
    background-color: #eab30833;
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
