<template>
    <div class="select-group">
        <label class="label">{{ name }}</label>
        <select name="" id="" class="select" required= "true"><slot /></select>
    </div>
</template>

<script setup>
const props = defineProps({
    name: String,
})
</script>

<style scoped>
.select {
    max-width: 190px;
    height: 44px;
    background-color: #181818;
    border-radius: .5rem;
    padding: 0 1rem;
    border: 2px solid transparent;
    font-size: 1rem;
    transition: border-color .3s cubic-bezier(.25, .01, .25, 1) 0s, color .3s cubic-bezier(.25, .01, .25, 1) 0s, .2s cubic-bezier(.25, .01, .25, 1) 0s;
}

.label {
    display: block;
    margin-bottom: .3rem;
    font-size: 1rem;
    font-weight: bold;
    color: #D3D3D3;
    transition: color .3s cubic-bezier(.25, .01, .25, 1) 0s;
}

.select:hover,
.select:focus,
.select-group:hover .input {
    outline: none;
    border-color: #ffffffff;
}

.select-group:hover .label,
.select:focus {
    color: #ffffffff;
}
</style>