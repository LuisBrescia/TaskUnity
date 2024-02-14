<template>
    <div class="border card rounded-custom afterglow">
        <slot />
    </div>
</template>

<style scoped>
.card {
    border: 2px solid #ffffff1a;
    backdrop-filter: blur(50px);
    -webkit-backdrop-filter: blur(50px);
    transition: all .5s ease;
    overflow: hidden;
}

.card:hover {
    border: 2px solid #ffffff3a;
    border-color: rgba(255, 255, 255, 0.5);
    background: rgba(255, 255, 255, 0.05);
    /* transform: translateY(-0.5rem); */
}

</style>