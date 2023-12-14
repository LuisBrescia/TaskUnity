<template>
  <div class="flex justify-center mx-auto gap-5 mt-12">
    <DefaultCard class="p-5 h-fit w-96">
      <header class="flex justify-between items-center">
        <span>{{ user.name }}</span>
        <el-button type="info" text circle :icon="ElIconTools" @click="abrirDialogEditarUsuario" />
      </header>
      <hr class="mt-2 mb-5 linha-colorida">
      <section class="text-base">
        <div>{{ user.email  }}</div>
      </section>
    </DefaultCard> 
    <DefaultCard class="p-5 h-fit w-96">
      <header class="flex justify-between items-center">
        <span>Convites</span>
        <el-button type="info" text circle :icon="ElIconTools" />
      </header>
      <hr class="mt-2 mb-5 linha-colorida">
      <DefaultCard v-for="(convite, index) in convites" :key="index" class="text-lg mb-5 p-5">
        <div>
          <div>Remetente: {{ getTasker(convite.owner).name }}</div>
          <div>Mensagem: {{ convite.message }}</div>
        </div>
        <el-row justify="end">
          <el-button 
            type="primary" text round class="mt-5" 
            :icon="ElIconMessage" @click="abrirDialogConvite(convite)"
          >
            AbrirConvite
          </el-button>
        </el-row>
      </DefaultCard>
    </DefaultCard>
  </div>

  <el-dialog v-model="dialogConvite" title="Convite">
    <div>Remetente: {{ getTasker(conviteCopy.owner).name }}</div>
    <div>Mensagem: {{ conviteCopy.message }}</div>
    <div>Tarefa: {{ conviteTask.name }}</div>
    <div>Descricao: {{ conviteTask.description }}</div>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogConvite = false">Cancelar</el-button>
        <el-button type="primary" @click="aceitarConvite">Aceitar</el-button>
      </span>
    </template>
  </el-dialog>

  <el-dialog v-model="dialogEditarUsuario" title="Editar usuário">
    <div>Nome:</div>
    <el-input v-model="userCopy.name" placeholder="Nome do usuário" size="large" />

    <div class="mt-5">Email:</div>
    <el-input v-model="userCopy.email" placeholder="Email do usuário" size="large" />

    <div class="mt-5">Senha:</div>
    <el-input v-model="userCopy.password" placeholder="Senha do usuário" size="large" />

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogEditarUsuario = false">Cancel</el-button>
        <el-button type="primary" @click="editarUsuarioSubmit" :loading="dialogButtonLoading">
          Salvar
        </el-button>
      </span>
    </template>
  </el-dialog>

</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js';

definePageMeta({
  layout: 'dashboard'
})

const userStore = useUserStore();

const dialogButtonLoading = ref(false);
const dialogConvite = ref(false);

const convites = ref({})
convites.value = userStore.convites;
const conviteCopy = ref({})
const conviteTask = ref({})

function abrirDialogConvite(convite) {
  apiFetch(`/tasks/${convite.task}`).then(res => {
    conviteTask.value = res.data;  
    dialogConvite.value = true;
    conviteCopy.value = {...convite};
  })
}

function aceitarConvite() {
  dialogButtonLoading.value = true;

  if (conviteTask.value.tasker == userStore.info.id) {
    ElNotification({
      title: 'Erro',
      message: 'Você já está nesta tarefa',
      type: 'error'
    })
    apagarConvite();
    return;
  }
  
  conviteTask.value.tasker = userStore.info.id;

  apiFetch(`/tasks/${conviteCopy.value.task}`, {
    method: 'PUT',
    body: conviteTask.value
  }).then(res => {
    userStore.tasks.push(res.data);
    ElNotification({
      title: 'Sucesso',
      message: 'Convite aceito com sucesso',
      type: 'success'
    })
    apagarConvite();
  })
}

function apagarConvite() {
  apiFetch(`/convites/${conviteCopy.value.id}`, {
    method: 'DELETE'
  }).then(res => {
    userStore.convites = userStore.convites.filter(convite => convite.id != conviteCopy.value.id);
    convites.value = userStore.convites;
    dialogConvite.value = false;
    dialogButtonLoading.value = false;
    ElNotification({
      title: 'Sucesso',
      message: 'Convite apagado com sucesso',
      type: 'success'
    })
  })
}

const user = ref(userStore.info);
const userCopy = ref({})
const dialogEditarUsuario = ref(false);

function abrirDialogEditarUsuario() {
  userCopy.value = {...user.value}
  dialogEditarUsuario.value = true;
}

function editarUsuarioSubmit() {
  dialogButtonLoading.value = true;
  apiFetch(`/users/${user.value.id}`, {
    method: 'PUT',
    body: userCopy.value
  }).then(res => {
    user.value = res.data;
    userStore.setInfo(res.data);
    dialogEditarUsuario.value = false;
    dialogButtonLoading.value = false;
    ElNotification({
      title: 'Sucesso',
      message: 'Usuário editado com sucesso',
      type: 'success'
    })
  })
}

function getTasker(taskerID) {
  if (taskerID == null) return 'Desconhecido';
  const tasker = userStore.users.find(user => user.id == taskerID);
  return tasker;
}

</script>