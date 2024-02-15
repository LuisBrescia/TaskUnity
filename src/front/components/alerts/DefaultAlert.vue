<template>
    <div class="border rounded-custom flex items-center relative" :class="`${type} ${hidden}`">
        <section class="mr-3">
            <Icon :name="icon[type]" size="3rem" />
        </section>
        <section>
            <header class="font-bold text-lg md:text-xl">{{ message }}</header>
            <p class="text-base">
                {{ description }}
            </p>
        </section>
        <!-- botao de fechar -->
        <Icon class="cursor-pointer" name="ph:x-circle" size="1.5rem" @click="fechaAlert" />    
    </div>
</template>

<script setup>

import { ref } from 'vue';

// const time = ref(150);
const hidden = ref('');

function fechaAlert() {
    hidden.value = 'fechado';
    remove();
}

const icon = {
    warning: 'ph:warning-duotone',
    success: 'ph:check-circle-duotone',
    error: 'ph:x-circle-duotone',
    info: 'ph:info-duotone'
};
const props = defineProps({
    type: {
        type: String,
        default: ''
    },
    description: {
        type: String,
        default: ''
    },
    message: {
        type: String,
        default: ''
    }
});

// setInterval(() => {
//     time.value--;
// }, 1000);

function remove() {
    setInterval(() => {
        hidden.value = 'hidden';
    }, 2000);
}

</script>

<style scoped lang="scss">

$warning: #eab308;
$success: #198754;
$error: #dc3545;
$info: #0d6efd;

$colors: (
    warning: $warning,
    success: $success,
    error: $error,
    info: $info
);

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

.success {
    border: 2px solid #22c55e33;
    background-color: #22c55e1a;
    color: #22c55e;
}

.error {
    border: 2px solid #f43f5e33;
    background-color: #f43f5e1a;
    color: #f43f5e;
}

.info {
    border: 2px solid #0ea5e933;
    background-color: #0ea5e91a;
    color: #0ea5e9;
}

.warning {
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
    }
}

.success .cursor-pointer:hover {
    filter: drop-shadow(0 0 0.5rem #22c55e) brightness(1.2);
}

.error .cursor-pointer:hover {
    filter: drop-shadow(0 0 0.5rem #f43f5e) brightness(1.2);
}

.info .cursor-pointer:hover {
    filter: drop-shadow(0 0 0.5rem #0ea5e9) brightness(1.2);
}

.warning .cursor-pointer:hover {
    filter: drop-shadow(0 0 0.5rem #eab308) brightness(1.2);
}

</style>