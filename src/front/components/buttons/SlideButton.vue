<template>
    <a class="rounded-lg  relative w-full h-10 cursor-pointer flex items-center border border-green-500 bg-green-500 group hover:bg-green-500 active:bg-green-500 active:border-green-500" href="{{ route('process.create') }}">
    <span class="text-gray-200 font-semibold ml-8 transform ">Função</span>
    <span class="absolute right-0 h-full w-10 rounded-lg bg-green-500 flex items-center justify-center transform group-hover:translate-x-0 group-hover:w-full transition-all duration-300">
        <svg class="svg w-8 text-white" fill="none" height="24" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
        <line x1="12" x2="12" y1="5" y2="19"></line>
        <line x1="5" x2="19" y1="12" y2="12"></line>
        </svg>
    </span>
    </a>
</template>

<style scoped>
    .rounded-lg .text-gray-200,
  .rounded-lg .svg {
    width: 100%;
    height: 100%;
  }
</style>