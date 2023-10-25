<template>
    <DefaultCard>
        <div class="flex justify-between items-center">
            <div class="sub-container1">
                <div class="text-lg font-normal">{{ name }}</div>
                <div class="text-sm font-thin text-neutral-500 tracking-widest">{{ role }}</div>
            </div>
            <RemoveButton></RemoveButton>
        </div>
    </DefaultCard>
</template>

<script setup>
const props = defineProps({
    name: String,
    role: String
})
</script>

<style scoped>
.sub-container1 {
    padding-right: 20px;
}
</style>