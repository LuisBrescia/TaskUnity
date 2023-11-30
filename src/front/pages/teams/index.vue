<template>
    <main>
        <div class="teams">
            <div name="teams[]" v-for="team in teams">
            <TeamCard :name="team.name" :description="team.description" />
        </div>
        </div>
        <NuxtLink to="/teams/create-team" style="padding-top: 10px;">
            <WhiteButton>Criar Equipe</WhiteButton>
        </NuxtLink>
    </main>
</template>

<script setup>
const activeName = ref('myTeams');

definePageMeta({
    layout: 'dashboard'
})

const teams = ref({})

apiFetch('/teams').then(res => {
    teams.value = res.data
    console.log(res)
    }).catch(err => {
        console.log(err)
    })
    
</script>

<style scoped>
.teams {
    display: grid;
    grid-auto-flow: column;
    gap: 10px;
}
</style>