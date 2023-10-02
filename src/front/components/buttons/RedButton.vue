<template>

    <button 
    class="bg-rose-500 hover:bg-rose-600 px-5 py-3 rounded-md uppercase font-extrabold text-2xl shadow text-red-50">
        <slot/>
    </button>

</template>

<style scoped>

button {
    transition: all 0.2s ease;
}

</style>
