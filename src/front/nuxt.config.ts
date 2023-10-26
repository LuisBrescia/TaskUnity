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
        { path: '~/components/buttons', pathPrefix: false },
        { path: '~/components/cards', pathPrefix: false },
        { path: '~/components/blobs', pathPrefix: false },
        { path: '~/components/inputs', pathPrefix: false }
    ],

    modules: [
        '@nuxtjs/tailwindcss',
        'nuxt-icon',
        '@element-plus/nuxt',
        '@nuxtjs/supabase',
        '@nuxtjs/color-mode',
    ],

    elementPlus: {
        icon: 'ElIcon',
        importStyle: 'scss',
        themes: ['dark'],
    },

    colorMode: {
        classSuffix: '',
        preference: 'dark',
    },
})
