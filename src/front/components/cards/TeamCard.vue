<template>
    <div style="width: 250px;">
        <DefaultCard class="p-5">
            <div class="flex justify-between items-center">
                <div class="sub-container1">
                    <div class="text-lg font-normal">{{ name }}</div>
                    <div class="text-sm font-thin text-neutral-500 tracking-widest">{{ description }}</div>
                </div>
            </div>
        </DefaultCard>
    </div>
</template>

<script setup>
const props = defineProps({
    name: String,
    description: String
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