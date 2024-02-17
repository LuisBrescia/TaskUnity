<template>
    <div 
        class="blobs fixed pointer-events-none flex -z-50 justify-center items-center" 
        style="height: 100vh; width: 100vw;"
        :style="`transform: scale(${1 + scrollBlob * 0.0005}); gap: ${scrollBlob * 0.1}px;`"
    >

        <DefaultBlob :color="colors[1]" style="animation-delay: 2s" />
        <DefaultBlob :color="colors[0]" />
        <DefaultBlob :color="colors[2]" style="animation-delay: 3s" />
        <DefaultBlob :color="colors[3]" style="animation-delay: 1s" />
        <DefaultBlob :color="colors[1]" style="animation-delay: 2.5s" />
        <DefaultBlob :color="colors[0]" style="animation-delay: .5s"  />
        <DefaultBlob :color="colors[2]" style="animation-delay: 3.5s" />
        <DefaultBlob :color="colors[3]" style="animation-delay: 1.5s" />
        
        <!-- <DefaultBlob :color="colors[1]" style="animation-delay: 2s" />
        <DefaultBlob :color="colors[0]" />
        <DefaultBlob :color="colors[2]" style="animation-delay: 3s" />
        <DefaultBlob :color="colors[3]" style="animation-delay: 1s" />
        <DefaultBlob :color="colors[1]" style="animation-delay: 2.5s" />
        <DefaultBlob :color="colors[0]" style="animation-delay: .5s"  />
        <DefaultBlob :color="colors[2]" style="animation-delay: 3.5s" />
        <DefaultBlob :color="colors[3]" style="animation-delay: 1.5s" /> -->
    </div>
</template>

<script setup>

const colors = ref(['blue', 'green', 'yellow', 'red']);
const scrollBlob = ref(0);

onMounted(() => {
    setInterval(() => {
        colors.value.push(colors.value.shift());
    }, 1000);
    window.addEventListener('scroll', handleScroll);
    scrollBlob.value = window.innerHeight - window.scrollY;
});

onBeforeUnmount(() => {
    window.removeEventListener('scroll', handleScroll);
});

function handleScroll() {
    scrollBlob.value = window.innerHeight - (window.scrollY * 0.2);
}

</script>