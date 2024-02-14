export default defineNuxtConfig({
    app: {
        head: {
            title: 'Task Unity',
            link: [
                { rel: 'icon', type: 'image/svg', href: '/Iconamoon3d.svg' },
            ]
        }
    },

    css: [
        '~/assets/scss/main.scss',
    ],

    vite: {
        css: {
            preprocessorOptions: {
                scss: {
                    additionalData: `@use "@/assets/scss/element/index.scss" as element;`,
                },
            },
        },
    },

    components: [
        { path: '~/components/alerts', pathPrefix: false },
        { path: '~/components/blobs', pathPrefix: false },
        { path: '~/components/buttons', pathPrefix: false },
        { path: '~/components/cards', pathPrefix: false },
        { path: '~/components/inputs', pathPrefix: false }
    ],

    modules: [
        '@nuxtjs/tailwindcss',
        '@pinia/nuxt',
        'nuxt-icon',
        '@element-plus/nuxt',
        '@nuxtjs/color-mode'
    ],

    elementPlus: {
        importStyle: 'scss',
        themes: ['dark'],
    },

    colorMode: {
        classSuffix: '',
        preference: 'dark',
    }
})
