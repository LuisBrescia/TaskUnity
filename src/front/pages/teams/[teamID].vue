<script setup>
definePageMeta({
    layout: 'dashboard'
});

const router = useRouter();
const userStore = useUserStore();
const { teamID } = useRoute().params;
const team = ref([])
var showMemberSelect = ref(false)
var selectedUser = ref()

apiFetch(`/teams/${teamID}`)
    .then(res => {
        console.log("Load team: ", teamID)
        team.value = res.data
        console.log(res)
    }).catch(err => {
        console.log(err)
    })

function editTeam() {
    apiFetch(`/teams/${teamID}`, {
        method: 'PUT',
        body: {
            name: document.getElementById('nome').value,
            description: document.getElementById('descricao').value,
            members: team.value.members
        }
    }).then((res) => {
        console.log(res)
        ElNotification({
            title: 'Sucesso',
            message: 'Equipe editada com sucesso',
            type: 'success'
        });
        router.push('/teams');
    }).catch((err) => {
        console.log(err)
    })
}

function deleteTeam() {
    if (confirm("Deseja realmente excluir a equipe atual?")) {
        apiFetch(`/teams/${teamID}`, {
            method: 'DELETE',
        }).then((res) => {
            console.log(res)
            ElNotification({
                title: 'Sucesso',
                message: 'Equipe excluida com sucesso',
                type: 'success'
            });
            router.push('/teams');
        }).catch((err) => {
            console.log(err)
        })
    }
}

function fieldsAreValid() {
    console.log(document.getElementById('nome').value)
    if (document.getElementById('nome').value == "") {
        alert("Digite um nome para a equipe.")
        return false
    }
    if (document.getElementById('descricao').value == "") {
        alert("Digite uma descrição para a equipe.")
        return false
    }
    return true
}

function removeMember(member) {
    team.value.members.splice(team.value.members.indexOf(member), 1)
}

function addMember() {
    let members = team.value.members
    for(var memberIndex in members){
        if(members[memberIndex].id == selectedUser.value.id){
            alert("O usuário selecionado já se encontra na equipe.")
            return
        }
    }
    team.value.members.push(selectedUser.value)
    showMemberSelect.value = false
}

</script>

<template>
    <DefaultCard class="p-8">
        <InputText value="Nome da Equipe" :model-value="team.name" id="nome"></InputText>
        <InputText value="Descrição" :model-value="team.description" id="descricao"></InputText>
        <section style="padding-bottom: 20px;">
            <h4 class="font-black uppercase text">Membros:</h4>
            <ul v-for="member in team.members">
                <div class="flex items-center">
                    <li class="text" style="padding-right: 10px;">{{ member.name }}</li>
                    <RemoveButton @click="removeMember(member)"></RemoveButton>
                </div>
            </ul>
        </section>
        <WhiteButton @click="showMemberSelect = true" type="button" style="width: 250px;">
            Adicionar Membro
        </WhiteButton>
        <div class="flex" style="gap: 10px; padding-top: 20px;">
            <BlueButton @click="fieldsAreValid() ? editTeam() : null">Salvar Alterações</BlueButton>
            <RedButton @click="deleteTeam()">Excluir Equipe</RedButton>
        </div>
    </DefaultCard>

    <el-dialog v-model="showMemberSelect" title="Adicionar membro">
        <div class="my-5">
            <header>Tasker</header>
            <el-select v-model="selectedUser" placeholder="Escolha um tasker" value-key="id">
                <el-option v-for="user in userStore.users" :key="user.id" :label="user.name" :value="user" />
            </el-select>
        </div>

        <template #footer>
            <el-row class="dialog-footer" justify="space-between">
                <div>
                    <el-button @click="showMemberSelect = false">Cancelar</el-button>
                    <el-button type="primary" @click="addMember()" :loading="dialogButtonLoading">
                        Salvar
                    </el-button>
                </div>
            </el-row>
        </template>
    </el-dialog>

    <NuxtLink to="/teams">
        <div class="fixed bottom-0 right-0 m-5 backdrop-brightness-50 rounded-custom">
            <DefaultCard class="px-5 py-3">
                <header class="text-2xl">Voltar</header>
            </DefaultCard>
        </div>
    </NuxtLink>
</template>

<style scoped>
.text {
    font-size: 1.1rem;
}
</style>