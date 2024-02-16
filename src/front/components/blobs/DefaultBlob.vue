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
    width: 25vh;
    aspect-ratio: 1;
    border-radius: 9999px;
    position: absolute;
    z-index: -1;
    filter: blur(100px);
    /* animation: ping 1s cubic-bezier(0, 0, 0.2, 1) infinite; */
    animation: ping 4s linear infinite;
}

/* @keyframes ping {
    75%, 100% {
        transform: scale(2);
        opacity: 0;
    }
} */

@keyframes ping {
    0% {
        transform: scale(1);
        opacity: 1;
    }
    50% {
        transform: scale(2);
    }
    60% {
        transform: scale(1);
        opacity: 0;
    }
    100% {
        transform: scale(1);
        opacity: 1;
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