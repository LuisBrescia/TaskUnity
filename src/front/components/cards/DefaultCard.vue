<template>

    <div class="border p-5 card rounded-3xl">
        <slot />
    </div>
</template>

<style scoped>

.card {
    border: 2px solid #ffffff1a;
    backdrop-filter: blur(50px) brightness(0.75);
    -webkit-backdrop-filter: blur(50px) brightness(0.75);
    transition: all .5s ease;
}
.card:hover {
    border: 2px solid #ffffff3a;
    border-color: rgba(255, 255, 255, 0.2);
    background: rgba(255, 255, 255, 0.05);
    transform: translateY(-0.5rem);
}


</style>