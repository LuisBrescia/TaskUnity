<template>
    <div class="input-group">
        <label class="label"><slot /></label>
        <textarea :name="name" :id="name" class="input" required="true" style="padding: 8px 16px 0px"></textarea>
    </div>
</template>

<script setup>
const props = defineProps({
    name: String,
})
</script>