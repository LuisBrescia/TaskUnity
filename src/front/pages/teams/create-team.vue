<template>
    <main class="flex form">
        <FormInput name="Nome"></FormInput>
        <TextAreaInput name="Descricao">Descrição</TextAreaInput>
        <div>
            <label id="membersLabel" class="label">Membros (0)</label>
            <div class="members">
                <div name="membros[]" v-for="member in members">
                    <TaskerFormCard :name="member.name" :role="member.role"
                        :removeClick="() => { removeMember(member); changeMembersLabel() }">
                    </TaskerFormCard>
                </div>
                <WhiteButton @click="showMemberSelect = true" type="button" style="width: 250px;">
                    <Icon name="tdesign:add" />
                </WhiteButton>
            </div>
        </div>
        <div>
            <WhiteButton @click="fieldsAreValid() ? createTeam() : null">Criar Equipe</WhiteButton>
        </div>
    </main>

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
</template>

<script setup>
definePageMeta({
    layout: 'dashboard'
})

const router = useRouter();
const userStore = useUserStore();
const user = ref(userStore.info);
var showMemberSelect = ref(false)
var selectedUser = ref()
var members = ref([])

function addMember() {
    members.value.push(selectedUser.value)
    showMemberSelect.value = false
}

function removeMember(member) {
    members.value.splice(members.value.indexOf(member), 1)
}

function changeMembersLabel() {
    document.getElementById("membersLabel").innerHTML = `Membros (${members.value.length})`
}

function createTeam() {
    apiFetch('/teams', {
        method: 'POST',
        body: {
            name: document.getElementById('Nome').value,
            description: document.getElementById('Descricao').value,
            owner: user.value.id,
            members: members.value
        }
    }).then((res) => {
        console.log(res)
        ElNotification({
            title: 'Sucesso',
            message: 'Equipe criada com sucesso',
            type: 'success'
        });
        router.push('/teams');
    }).catch((err) => {
        console.log(err)
    })
}

function fieldsAreValid() {
    if (document.getElementById('Nome').value == "") {
        alert("Digite um nome para a equipe.")
        return false
    }
    if (document.getElementById('Descricao').value == "") {
        alert("Digite uma descrição para a equipe.")
        return false
    }
    if (members.value.length < 1) {
        alert("Adicione ao menos um membro.")
        return false
    }
    return true
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
    max-width: 780px;
}
</style>