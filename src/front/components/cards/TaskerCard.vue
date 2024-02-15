<template>
    <article class="border sm:rounded-2xl p-5 text-center shadow overflow-hidden border-none sm:border-solid">
        <img :src="filename" class="rounded-full mb-3 h-24 aspect-square mx-auto">
        <div class="text-lg uppercase font-light tracking-widest">{{ role }}</div>
        <div class="text-2xl font-black tracking-wider text-rainbow">{{ name }}</div>
        <div class="text-base text-start mt-3 max-w-xs">
            <slot/>
        </div>
    </article>
</template>

<script setup>

const props = defineProps({
    name: String,
    role: String,
    img: String
});

const filename = ref(`/img/profile/${props.img}.jpg`); 

</script>

<style scoped>

    article {
        background: rgb(0, 0, 0);
    }

    article:hover {
        border-color: rgb(64, 64, 64) !important;
        background: rgb(16, 16, 16) !important;
        transform: translateY(-0.5rem);
    }

    .text-rainbow {
        filter: grayscale(1) brightness(1.5);
        transition: all 1s ease;
    }	

    article:hover .text-rainbow {
        filter: grayscale(0) brightness(1);
    }
</style>