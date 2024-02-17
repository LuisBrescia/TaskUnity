<template>
    <span class="bg-gradient-to-r" :class="gradient[color]" />
</template>

<script setup>

const props = defineProps({
    color: {
        type: String,
        default: 'black'
    }
});

const gradient = {
    red: 'from-red-800 via-rose-600 to-pink-400',
    blue: 'from-indigo-800 via-sky-600 to-cyan-400',
    green: 'from-emerald-800 via-green-600 to-lime-400',
    yellow: 'from-orange-600 via-amber-500 to-yellow-300',
    black: 'from-black via-neutral-950 to-black'
}

</script>

<style scoped>

span {
    width: 2px;
    height: 60vh;
    border-radius: 100%;
    z-index: -9999;
    /* animation: ping 1s cubic-bezier(0, 0, 0.2, 1) infinite; */
    animation: ping 4s linear infinite;
    transition: all 1s ease;
    filter: brightness(0);
}

span:hover {
    animation: none !important;
    filter: blur(0px) invert(1) brightness(1.5) contrast(1.5) saturate(1.5) hue-rotate(180deg);
}

/* span::before {
    content: ' ';
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 100%;
    height: 100%;
    border-radius: 100%;
    background: inherit;
    filter: blur(10px);
    animation: move 4s linear infinite;
    transition: all 1s;
} */

/* @keyframes ping {
    75%, 100% {
        filter: brightness(0) blur(10px);
        opacity: 0;
    }
} */

@keyframes ping {
    0% {
        filter: brightness(0) blur(5px); 
        transform: translateX(-5rem) scaleY(0.5);
    }
    5% {
        filter: brightness(1) blur(0px);
    }
    50% {
        transform: translateX(0) scaleY(1);
    }
    100% {
        filter: brightness(0) blur(5px);   
        transform: translateX(5rem);
    }
}

@keyframes move {
    from {
        transform: scale(1) rotate(0);
        filter: blur(0px);
    }
    50% {
        transform: scale(1) rotate(180deg) skewX(0);
        filter: blur(200px);
    }
    to {
        transform: scale(1) rotate(360deg);
        filter: blur(0px);
    }
}

</style>