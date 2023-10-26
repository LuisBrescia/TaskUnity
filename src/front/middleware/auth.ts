export default defineNuxtRouteMiddleware((to) =>{
    const user = useSupabaseUser()

    if(!user.value && to.path === '/profile') {
        navigateTo('/')
    } else if(user.value && to.path === '/'){
        navigateTo('/profile')
    }

})