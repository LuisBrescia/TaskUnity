<script scoped>
const { teamID } = useRoute().params;

window.onload = loadTeam()
const team = ref([])

function loadTeam(){
    console.log("Load team")
    apiFetch(`/teams/${teamID}`)
        .then(res => {
            team.value = res.data
            console.log(res)
        }).catch(err => {
            console.log(err)
        })
}

definePageMeta({
    layout: 'dashboard'
});


</script>

<template>
<DefaultCard>{{ team.name }}</DefaultCard>
</template>