<template>
    <button class="font-bold text-base border-2
    px-5 pt-3 pb-3 rounded-full
    text-neutral-50 border-neutral-50
    uppercase tracking-widest">
        <slot />
    </button>
</template>

<style scoped>
button {
    position: relative;
    overflow: hidden;
    transition: all 0.2s ease;
    background: linear-gradient(to right, #22c55e22 1%, transparent 40%, transparent 60%, #eab30822 100%);
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
    opacity: .5;
    transition: transform 1.5s ease;
}

button:hover::before {
    transform: translateX(15em);
}
</style>
