<script setup>
definePageMeta({
    layout: 'dashboard'
});

const { teamID } = useRoute().params;
const team = ref([])

apiFetch(`/teams/${teamID}`)
    .then(res => {
        console.log("Load team: ", teamID)
        team.value = res.data
        console.log(res)
    }).catch(err => {
        console.log(err)
    })


</script>

<template>
    <DefaultCard class="p-8">
        <h2 class="text-4xl font-semibold tracking-tighter">{{ team.name }}</h2>
        <hr class="my-2 linha-colorida">
        <h4>Descrição: {{ team.description }}</h4>
        <section style="padding-top: 30px;">
            <h4 class="font-black uppercase">Membros:</h4>
            <ul v-for="member in team.members">
                <li>{{ member.name }} - {{ member.userFunction }}</li>
            </ul>
        </section>
    </DefaultCard>
</template>