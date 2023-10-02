<template>

    <div class="border p-3 rounded-lg border-rose-500">
        <h3 class="text-2xl">
            {{  title  }}
        </h3>
        <p>
            {{ description  }}
        </p>
    </div>
        
</template>


<script setup>

const props = defineProps({
    title: String,
    description: String
})

</script>