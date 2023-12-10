<template>
    <DefaultCard class="cursor-pointer overflow-auto w-full p-5" style="min-width: 360px; height: 360px;">
        <h2 class="text-4xl font-semibold tracking-tighter center">{{ name }}</h2>
        <hr class="my-2 linha-colorida">
        <section>
            <h4 class="font-black uppercase">Membros:</h4>
            <ul v-for="member in members">
                <li>{{ member.name }}</li>
            </ul>
        </section>
    </DefaultCard>
</template>

<script setup>
const props = defineProps({
    name: String,
    members: Array
})
</script>

<style scoped>
.sub-container1 {
    padding-right: 20px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
</style>