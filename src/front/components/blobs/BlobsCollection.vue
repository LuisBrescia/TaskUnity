<template>
    <div class="blobs fixed pointer-events-none hidden sm:block" style="height: 100vh; width: 100vw;">
        <!-- <DefaultBlob color="blue" class="animate-ping right-full" style="top: 0%;" />
        <DefaultBlob color="blue" class="animate-spin right-full" style="top: 0%;" />
        <DefaultBlob color="green" class="animate-ping right-full" style="top: 25%;" />
        <DefaultBlob color="green" class="animate-spin right-full" style="top: 25%;" />
        <DefaultBlob color="yellow" class="animate-ping right-full" style="top: 50%;" />
        <DefaultBlob color="yellow" class="animate-spin right-full" style="top: 50%;" />
        <DefaultBlob color="red" class="animate-ping right-full" style="top: 75%;" />
        <DefaultBlob color="red" class="animate-spin right-full" style="top: 75%;" />

        <DefaultBlob color="blue" class="animate-ping left-full" style="top: 0%;" />
        <DefaultBlob color="blue" class="animate-spin left-full" style="top: 0%;" />
        <DefaultBlob color="green" class="animate-ping left-full" style="top: 25%;" />
        <DefaultBlob color="green" class="animate-spin left-full" style="top: 25%;" />
        <DefaultBlob color="yellow" class="animate-ping left-full" style="top: 50%;" />
        <DefaultBlob color="yellow" class="animate-spin left-full" style="top: 50%;" />
        <DefaultBlob color="red" class="animate-ping left-full" style="top: 75%;" />
        <DefaultBlob color="red" class="animate-spin left-full" style="top: 75%;" /> -->

        <DefaultBlob :color="colors[0]" class="animate-ping right-full" style="top: 0%;" />
        <!-- <DefaultBlob :color="colors[0]" class="animate-spin right-full" style="top: 0%;" /> -->
        <DefaultBlob :color="colors[1]" class="animate-ping right-full" style="top: 25%; animation-delay: 0.5s" />
        <!-- <DefaultBlob :color="colors[1]" class="animate-spin right-full" style="top: 25%; animation-delay: 0.5s" /> -->
        <DefaultBlob :color="colors[2]" class="animate-ping right-full" style="top: 50%; animation-delay: 0.75s" />
        <!-- <DefaultBlob :color="colors[2]" class="animate-spin right-full" style="top: 50%; animation-delay: 0.75s" /> -->
        <DefaultBlob :color="colors[3]" class="animate-ping right-full" style="top: 75%; animation-delay: 0.25s" />
        <!-- <DefaultBlob :color="colors[3]" class="animate-spin right-full" style="top: 75%; animation-delay: 0.25s" /> -->

        <DefaultBlob :color="colors[0]" class="animate-ping left-full" style="top: 0%;" />
        <!-- <DefaultBlob :color="colors[0]" class="animate-spin left-full" style="top: 0%;" /> -->
        <DefaultBlob :color="colors[1]" class="animate-ping left-full" style="top: 25%; animation-delay: 0.5s" />
        <!-- <DefaultBlob :color="colors[1]" class="animate-spin left-full" style="top: 25%; animation-delay: 0.5s" /> -->
        <DefaultBlob :color="colors[2]" class="animate-ping left-full" style="top: 50%; animation-delay: 0.75s" />
        <!-- <DefaultBlob :color="colors[2]" class="animate-spin left-full" style="top: 50%; animation-delay: 0.75s" /> -->
        <DefaultBlob :color="colors[3]" class="animate-ping left-full" style="top: 75%; animation-delay: 0.25s" />
        <!-- <DefaultBlob :color="colors[3]" class="animate-spin left-full" style="top: 75%; animation-delay: 0.25s" /> -->
    </div>
</template>

<script setup>

const colors = ref(['blue', 'green', 'yellow', 'red']);

onMounted(() => {
    setInterval(() => {
        colors.value.push(colors.value.shift());
    }, 1000);
});

</script>

<style scoped>
.blobs > * {
    width: 20vh;
    filter: blur(100px);
}
</style>