<template>
    <div 
        class="blobs fixed pointer-events-none hidden sm:flex -z-50 justify-center items-center overflow-visible" 
        style="height: 100vh; width: 100vw;"
        :style="`transform: scale(${1 + scrollBlob * 0.0005}); gap: ${scrollBlob * 0.1}px;`"
    >
        <DefaultLine :color="colors[1]" style="animation-delay: 2s" />
        <DefaultLine :color="colors[0]" />
        <DefaultLine :color="colors[2]" style="animation-delay: 3s" />
        <DefaultLine :color="colors[3]" style="animation-delay: 1s" />

        <DefaultLine :color="colors[1]" style="animation-delay: 2.5s" />
        <DefaultLine :color="colors[0]" style="animation-delay: .5s"  />
        <DefaultLine :color="colors[2]" style="animation-delay: 3.5s" />
        <DefaultLine :color="colors[3]" style="animation-delay: 1.5s" />
    </div>

    <div 
        class="blobs fixed pointer-events-none flex sm:hidden -z-50 justify-center items-center gap-3" 
        style="height: 100vh; width: 100vw;"
        :style="`transform: scale(${1 + scrollBlob * 0.0005});`"
    >
        <DefaultLine :color="colors[1]" style="animation-delay: 2s" />
        <DefaultLine :color="colors[0]" />
        <DefaultLine :color="colors[2]" style="animation-delay: 3s" />
        <DefaultLine :color="colors[3]" style="animation-delay: 1s" />
        <DefaultLine :color="colors[1]" style="animation-delay: 2.5s" />
        <DefaultLine :color="colors[0]" style="animation-delay: .5s"  />
        <DefaultLine :color="colors[2]" style="animation-delay: 3.5s" />
        <DefaultLine :color="colors[3]" style="animation-delay: 1.5s" />
        
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
    scrollBlob.value = window.innerHeight - (window.scrollY * 0.25);
}

</script>