<template>
    <div class="card rounded-custom">
        <slot />
    </div>
</template>

<style scoped>
.card {
    border-color: #ffffff1a;
    border-width: 2px;
    backdrop-filter: brightness(0);
    transition: all .5s ease;
}

@media (min-width: 640px) {
    .card:hover {
        border-color: #ffffff3a;
        background: #0f0f0f;
    }
}

</style>