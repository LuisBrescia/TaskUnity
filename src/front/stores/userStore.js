import { defineStore } from 'pinia'

export const useUserStore = defineStore({
    state: () => ({
        userInfo: [],
        userProjects: [],
        userTasks: [],
    }),
    actions: {
        async fetchUser(userId) {
            const response = await apiFetch(`/users/${userId}`)
            this.setUserInfo(response.data)
        },

        async fetchUserProjects(userId) {
            const response = await apiFetch(`/projects?owner=${userId}`)
            this.setUserProjects(response.data)
        },

        async fetchUserTasks(userId) {
            const response = await apiFetch(`/tasks?owner=${userId}`)
            this.setUserTasks(response.data)
        },

        setUserInfo(user) {
            this.userInfo = user
        },

        setUserProjects(projects) {
            this.userProjects = projects
        },

        setUserTasks(tasks) {
            this.userTasks = tasks
        },

        logout() {
            this.userInfo = []
            this.userProjects = []
            this.userTasks = []
        },
    },
})

if (import.meta.hot) {
  import.meta.hot.accept(acceptHMRUpdate(useUserStore, import.meta.hot))
}