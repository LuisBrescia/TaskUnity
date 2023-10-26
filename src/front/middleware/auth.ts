export default defineNuxtRouteMiddleware((to) =>{
    const user = useSupabaseUser()

    if(!user.value && to.path === '/notes') {
        navigateTo('/login')
    } else if(user.value && to.path === '/'){
        navigateTo('/profile')
    }


})