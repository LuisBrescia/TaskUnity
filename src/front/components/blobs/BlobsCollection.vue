<template>
    <div class="blobs fixed pointer-events-none" style="height: 100vh; width: 100vw;">
        <BlueBlob class="animate-ping right-full" style="top: 0%;" />
        <BlueBlob class="animate-spin right-full" style="top: 0%;" />
        <GreenBlob class="animate-ping right-full" style="top: 25%;" />
        <GreenBlob class="animate-spin right-full" style="top: 25%;" />
        <YellowBlob class="animate-ping right-full" style="top: 50%;" />
        <YellowBlob class="animate-spin right-full" style="top: 50%;" />
        <RedBlob class="animate-ping right-full" style="top: 75%;" />
        <RedBlob class="animate-spin right-full" style="top: 75%;" />

        <BlueBlob class="animate-ping left-full" style="top: 0%;" />
        <BlueBlob class="animate-spin left-full" style="top: 0%;" />
        <GreenBlob class="animate-ping left-full" style="top: 25%;" />
        <GreenBlob class="animate-spin left-full" style="top: 25%;" />
        <YellowBlob class="animate-ping left-full" style="top: 50%;" />
        <YellowBlob class="animate-spin left-full" style="top: 50%;" />
        <RedBlob class="animate-ping left-full" style="top: 75%;" />
        <RedBlob class="animate-spin left-full" style="top: 75%;" />
    </div>
</template>

<style scoped>
.blobs > * {
    width: 25vh;
    filter: blur(100px);
}
</style>