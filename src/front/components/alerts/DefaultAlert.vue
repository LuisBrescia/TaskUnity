<template>
    <div class="border rounded-custom flex items-center relative" :class="`${type} ${hidden}`">
        <section class="mr-3">
            <Icon name="ph:warning-duotone" size="3rem" />
        </section>
        <section>
            <header class="font-bold text-lg md:text-xl">Aviso!</header>
            <p class="text-base">
                Servidor sendo inicializado, estimativa de {{ time }} segundos.
            </p>
        </section>
        <!-- botao de fechar -->
        <Icon class="cursor-pointer" name="ph:x-circle" size="1.5rem" @click="fechaAlert" />    
    </div>
</template>

<script setup>

import { ref } from 'vue';

const time = ref(150);
const message = ref('Aguarde');
const hidden = ref('');

function fechaAlert() {
    hidden.value = 'fechado';
    remove();
}

const props = defineProps({
    type: {
        type: String,
        default: 'warning'
    },
    description: {
        type: String,
        default: ''
    }
});

setInterval(() => {
    time.value--;
}, 1000);

function remove() {
    setInterval(() => {
        hidden.value = 'hidden';
    }, 2000);
}

</script>

<style scoped lang="scss">
div {
    transition: all .8s ease-in-out;
    position: relative;
    max-height: 96px;
    min-height: 0;
    padding: 1.25rem 1.25rem;
}

div.fechado {
    transform: translateY(-5rem);
    filter: blur(5px);
    max-height: 0;
    padding: 0 1.25rem;
    opacity: 0;
}

div.warning {
    border: 2px solid #eab30833;
    background-color: #eab3081a;
    color: #eab308;
}

.cursor-pointer {
    position: absolute;
    right: 10px;
    top: 10px;
    transition: all .5s ease;
    &:hover {
        transform: scale(1.1);
        filter: drop-shadow(0 0 0.5rem #eab308) brightness(1.2);
    }
}
</style>