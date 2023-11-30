<script setup>
const router = useRouter();

definePageMeta({
    layout: 'dashboard'
})

window.onload = loadTeams()
var teams = ref([])

function loadTeams() {
    console.log("Load teams")
    apiFetch('/teams')
        .then(res => {
            teams.value = res.data
            console.log(res)
        }).catch(err => {
            console.log(err)
        })
}

function openTeam() {
    router.push(`/teams/${id}`);
}
</script>

<template>
    <main>
        <div class="teams">
            <div name="teams[]" v-for="team in teams">
                <TeamCard :name="team.name" :members="team.members" @click="openTeam(team.id)"></TeamCard>
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