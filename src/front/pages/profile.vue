<template>
  <div class="max-w-xl flex justify-center mx-auto">
    <DefaultCard class="h-fit p-5 mx-auto w-full mt-12">
      <header class="flex justify-between items-center">
        <span>{{ user.name }}</span>
        <el-button type="info" text circle :icon="ElIconTools" @click="abrirDialogEditarUsuario" />
      </header>
      <hr class="mt-2 mb-5 linha-colorida">

      <pre>{{ convites }}</pre>
    </DefaultCard> 
  </div>

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
const user = ref(userStore.info);
const userCopy = ref({})
const dialogEditarUsuario = ref(false);
const dialogButtonLoading = ref(false);

const convites = ref({})
convites.value = userStore.convites;

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

</script>