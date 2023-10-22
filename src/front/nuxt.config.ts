// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
    app: {
        head: {
            title: 'Task Unity',
            link: [
                { rel: 'icon', type: 'image/svg', href: '/Iconamoon3d.svg' },
            ]
        }
    },

    css: ['~/assets/css/main.css'],
    components: [
        { path: '~/components/buttons', pathPrefix: false },
        { path: '~/components/cards', pathPrefix: false },
        { path: '~/components/blobs', pathPrefix: false },
        { path: '~/components/inputs', pathPrefix: false }
    ],
    modules: [
        '@nuxtjs/tailwindcss',
        'nuxt-icon'
    ]
})
