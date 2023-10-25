<template>
    <div class="input-group">
        <label class="label"><slot /></label>
        <input :name="name" :id="name" class="input" required="true"/>
    </div>
</template>

<script setup>
const props = defineProps({
    name: String,
})
</script>

<style>
.input {
    width: 250px;
    max-width: 250px;
    min-height: 44px;
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

.input-group{
    width: 250px;
}

.input:hover,
.input:focus,
.input-group:hover .input {
    outline: none;
    border-color: #ffffffff;
}

.input-group:hover .label,
.input:focus {
    color: #ffffffff;
}
</style>