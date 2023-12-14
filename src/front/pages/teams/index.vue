<script setup>
definePageMeta({
    layout: 'dashboard'
})

const userStore = useUserStore();
const user = ref(userStore.info);

var teams = ref([])

apiFetch(`/teams/userId/${user.value.id}`)
    .then(res => {
        console.log("Load teams from user: " + user.value.id)
        teams.value = res.data
        console.log(res)
    }).catch(err => {
        console.log(err)
    })
</script>

<template>
    <main>
        <div class="teams">
            <div name="teams[]" v-for="team in teams">
                <NuxtLink :to="`/teams/${team.id}`">
                    <TeamCard :name="team.name" :members="team.members"></TeamCard>
                </NuxtLink>
            </div>
        </div>
        <NuxtLink to="/teams/create-team">
            <WhiteButton>Criar Equipe</WhiteButton>
        </NuxtLink>
    </main>
</template>

<style scoped>
.teams {
    display: grid;
    grid-auto-flow: column;
    gap: 10px;
}
</style>