import { defineStore } from 'pinia'

export const useUserStore = defineStore("userStore", {
    state: () => ({
        info: null,
        projects: null,
        tasks: null,
        users: null,
    }),
    getters: {
        getInfo() {
            return this.info
        },

        getProjects() {
            return this.projects
        },

        getTasks() {
            return this.tasks
        },

        getUsers() {
            return this.users
        }
    },
    actions: {

        // async fetchProjects() {
        //     const response = await apiFetch(`/projects?owner=${this.info.id}`)
        //     this.setProjects(response.data)
        // },

        // async fetchTasks() {
        //     const response = await apiFetch(`/tasks?tasker=${this.info.id}`)
        //     this.setTasks(response.data)
        // },

        setInfo(user) {
            this.info = user;
        },

        setProjects(projects) {
            this.projects = projects;
        },

        setTasks(tasks) {
            this.tasks = tasks;
        },

        setUsers(users) {
            this.users = users;
        },

        logout() {
            this.info = null;
            this.projects = null;
            this.tasks = null;
        },
    },
})

if (import.meta.hot) {
  import.meta.hot.accept(acceptHMRUpdate(useUserStore, import.meta.hot))
}