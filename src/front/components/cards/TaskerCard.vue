<template>
    <article class="border rounded-custom p-5 text-center shadow overflow-hidden">
        <img :src="filename" class="rounded-full mb-3 h-24 aspect-square mx-auto">
        <div class="text-lg uppercase font-light tracking-widest">{{ role }}</div>
        <div class="text-2xl font-black tracking-wider text-rainbow">{{ name }}</div>
        <div class="text-base text-start mt-3 max-w-xs">
            <slot/>
        </div>
        <!-- <RedBlob class="animate-ping left-3/4" style="top: 75%;" />
        <YellowBlob class="animate-ping left-3/4" style="top: 50%;" />
        <BlueBlob class="animate-ping right-3/4" style="top: 25%;" />
        <GreenBlob class="animate-ping right-3/4" style="top: 0%;" /> -->
    </article>
</template>

<script setup>

const props = defineProps({
    name: String,
    role: String,
    img: String
});

const filename = ref(`/img/${props.img}.jpg`); 

</script>

<style scoped>

    article:hover {
        border-color: rgba(255, 255, 255, 0.2);
        background: rgba(255, 255, 255, 0.02);
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