<template>
    <NuxtLayout>
        <main class="flex justify-center mx-5 h-screen items-center">
            <div class="max-w-2xl p-12 text-center">
                <h1 class="text-rainbow text-9xl font-black">{{ error.statusCode }}</h1>
                <h3 class="text-4xl font-black mt-5 mb-12">{{ error.statusMessage }}</h3>
                <WhiteButton @click="handleError">Página inicial</WhiteButton>
            </div>
        </main>
    </NuxtLayout>
</template>

<script setup>
const error = useError();

function handleError() {
    clearError({
        redirect: '/',
    });
};
</script>