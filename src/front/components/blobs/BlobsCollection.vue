<template>
    <div class="blobs fixed pointer-events-none hidden sm:block z-0" style="height: 100vh; width: 100vw;">
        <DefaultBlob :color="colors[0]" class="right-full" style="top: 0%;" />
        <!-- <DefaultBlob :color="colors[0]" class="animate-spin right-full" style="top: 0%;" /> -->
        <DefaultBlob :color="colors[1]" class="right-full" style="top: 25%; animation-delay: 2s" />
        <!-- <DefaultBlob :color="colors[1]" class="animate-spin right-full" style="top: 25%; animation-delay: 0.5s" /> -->
        <DefaultBlob :color="colors[2]" class="right-full" style="top: 50%; animation-delay: 3s" />
        <!-- <DefaultBlob :color="colors[2]" class="animate-spin right-full" style="top: 50%; animation-delay: 0.75s" /> -->
        <DefaultBlob :color="colors[3]" class="right-full" style="top: 75%; animation-delay: 1s" />
        <!-- <DefaultBlob :color="colors[3]" class="animate-spin right-full" style="top: 75%; animation-delay: 0.25s" /> -->

        <DefaultBlob :color="colors[0]" class="left-full" style="top: 0%;" />
        <!-- <DefaultBlob :color="colors[0]" class="animate-spin left-full" style="top: 0%;" /> -->
        <DefaultBlob :color="colors[1]" class="left-full" style="top: 25%; animation-delay: 2s" />
        <!-- <DefaultBlob :color="colors[1]" class="animate-spin left-full" style="top: 25%; animation-delay: 0.5s" /> -->
        <DefaultBlob :color="colors[2]" class="left-full" style="top: 50%; animation-delay: 3s" />
        <!-- <DefaultBlob :color="colors[2]" class="animate-spin left-full" style="top: 50%; animation-delay: 0.75s" /> -->
        <DefaultBlob :color="colors[3]" class="left-full" style="top: 75%; animation-delay: 1s" />
        <!-- <DefaultBlob :color="colors[3]" class="animate-spin left-full" style="top: 75%; animation-delay: 0.25s" /> -->
    </div>
</template>

<script setup>

const colors = ref(['blue', 'green', 'yellow', 'red']);
// const colors = ref(['black', 'black', 'black', 'black']);

// onMounted(() => {
//     setInterval(() => {
//         colors.value.push(colors.value.shift());
//     }, 4000);
// });

</script>