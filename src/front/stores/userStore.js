import { defineStore } from 'pinia'

export const useUserStore = defineStore("userStore", {
    state: () => ({
        info: [],
        projects: [],
        tasks: [],
        users: [],
        convites: [],
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
        },
        getConvites() {
            return this.convites
        },
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

        setConvites(convites) {
            this.convites = convites;
        },

        logout() {
            this.info = [];
            this.projects = [];
            this.tasks = [];
            this.users = [];
            this.convites = [];
        },
    },
})

if (import.meta.hot) {
  import.meta.hot.accept(acceptHMRUpdate(useUserStore, import.meta.hot))
}