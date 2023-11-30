<template>
    <main class="flex">
        <form action="/projects" class="form">
            <FormInput name="nome">Nome da Equipe</FormInput>
            <TextAreaInput name="descricao">Descrição</TextAreaInput>
            <div>
                <label id="membersLabel" class="label">Membros (0)</label>
                <div class="members">
                    <div name="membros[]" v-for="member in members">
                        <TaskerFormCard :name="member.name" :role="member.role"
                            :removeClick="() => { removeMember(member); changeMembersLabel() }">
                        </TaskerFormCard>
                    </div>
                    <WhiteButton @click="addMember(); changeMembersLabel()" type="button" style="width: 250px;">
                        <Icon name="tdesign:add" />
                    </WhiteButton>
                </div>
            </div>
            <div>
                <NuxtLink :to="isMembersEmpty() ? null : { path: '/contratar-freelancer', query: { members: members.length } }">
                    <BlueButton type="button" @click="isMembersEmpty() ? alertSearchMembers() : null">
                        Buscar Taskers
                    </BlueButton>
                </NuxtLink>
            </div>
            <div>
                <WhiteButton @click="createTeam">Criar Equipe</WhiteButton>
            </div>
        </form>
    </main>
</template>

<script setup>
definePageMeta({
    layout: 'dashboard'
})

var members = ref([])

function addMember() {
    members.value.push({ name: "Membro", role: "Função" })
}

function removeMember(member) {
    members.value.splice(members.value.indexOf(member), 1)
}

function changeMembersLabel() {
    document.getElementById("membersLabel").innerHTML = `Membros (${members.value.length})`
}

function isMembersEmpty() {
    if (members.value.length > 0) {
        return false
    }
    return true
}

function alertSearchMembers() {
    alert("Adicione ao menos um membro.")
}

function createTeam() {
    console.log(document.getElementById('nome').value)
    apiFetch('/teams', {
        method: 'POST',
        body: {
            name: document.getElementById('nome').value,
            description: document.getElementById('descricao').value,
            members: members.value
        }
    })
        .then((res) => {
            console.log(res)

            if (res.status == 200) {
                router.push('/profile');
            } else {
                status.value = res.data
            }

        }).catch((err) => {
            console.log(err)
        })

}
</script>

<style scoped>
.form {
    display: flex;
    flex-direction: column;
    gap: 20px;
}

.members {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    gap: 10px;
}
</style>