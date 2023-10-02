// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
    css: ['~/assets/css/main.css'],
    components: [
        { path: '~/components/buttons', pathPrefix: false },
        { path: '~/components/cards', pathPrefix: false },
        { path: '~/components/blobs', pathPrefix: false }
    ],
    modules: [
        '@nuxtjs/tailwindcss'
    ]
})
