<template>
    <div class="card rounded-custom border-none sm:border-solid">
        <slot />
    </div>
</template>

<style scoped>
.card {
    border-color: #ffffff1a;
    border-width: 2px;
    backdrop-filter: brightness(0);
    -webkit-backdrop-filter: brightness(0);
    transition: all .5s ease;
}

@media (min-width: 640px) {
    .card:hover {
        border-color: #ffffff3a;
        background: rgba(255, 255, 255, 0.05);
    }
}

</style>