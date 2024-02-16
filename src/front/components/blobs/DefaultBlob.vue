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
    black: 'from-gray-800 via-gray-600 to-gray-400'
}

// red .25
// green .5
// yellow .75

</script>

<style scoped>

/* span.from-red-800 {
    animation-delay: 0.25s;
}

span.from-emerald-800 {
    animation-delay: 0.5s;
}

span.from-orange-600 {
    animation-delay: 0.75s;
} */

span {
    width: 150px;
    aspect-ratio: 1;
    border-radius: 9999px;
    position: absolute;
    z-index: -1;
    filter: blur(50px);
    /* animation: move 8s infinite linear; */
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