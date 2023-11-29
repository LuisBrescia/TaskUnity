<template>
    <article class="border rounded p-5 text-center shadow">
        <img :src="filename" class="rounded-full mb-3 h-24 aspect-square mx-auto">
        <div class="text-lg uppercase font-light tracking-widest">{{ role }}</div>
        <div class="text-2xl font-black tracking-wider">{{ name }}</div>
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

const filename = ref(`/img/${props.img}.jpg`); 

</script>