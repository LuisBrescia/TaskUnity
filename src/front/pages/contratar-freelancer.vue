<script setup>

definePageMeta({
  layout: 'dashboard'
})

const users = ref([])
const selectUserFunction = ref('todos')
const selectUserFunctionOptions = ref([
  {
    value: 'todos',
    label: 'Todos'
  }
])

apiFetch(`/users`).then((res) => {
  users.value = res.data
  for (let i = 0; i < users.value.length; i++) {
    if (users.value[i].userFunction) {
      selectUserFunctionOptions.value.push({
        value: users.value[i].userFunction,
        label: users.value[i].userFunction
      })
    }
  }
})
.catch((error) => {
  console.error('Erro ao buscar usuários:', error)
})

function buscarUser() {
  apiFetch(`/users/function/${selectUserFunction.value}`).then((res) => {
    users.value = res.data
  })
  .catch((error) => {
    console.error('Erro ao buscar usuários:', error)
  })
}

const route = useRoute();

// Adicionar um botao a cada user mostrado para adicionar ele à equipe com a rota "teams/{teamId}/addMember"
function addToTeam(userId) {
  apiFetch(`/teams/${route.params.teamId}/addMember`, {
    method: 'POST',
    body: {
      userId: userId
    }
  }).then((res) => {
    users.value = res.data
  })
  .catch((error) => {
    console.error('Erro ao adicionar usuario a equipe:', error)
  })
}
</script>

<template>
  <div class="flex mt-12 gap-12">
    <DefaultCard class="w-1/3 p-6">
      <div class="container container-fluid mx-6">
        <div class="grid gap-6">
          <div class="rounded-lg p-0 my-4 shadow-md button col-md-4">
            <SlideButton />
          </div>
          <div class="rounded-lg p-0 my-4 shadow-md button col-md-4">
            <SlideButton />
          </div>
          <div class="rounded-lg p-0 my-4 shadow-md button col-md-4">
            <SlideButton />
          </div>
          <div class="rounded-lg p-0 my-4 shadow-md button col-md-4">
            <SlideButton />
          </div>
        </div>
      </div>
    </DefaultCard>
    <DefaultCard class="w-2/3 p-6">
      <div class="flex gap-12 mb-5">
        <FormInput name="Nome do freelancer" label="Nome do freelancer" />
        <!-- <SelectInput name="Função" label="Função">
          <option value="valor1">developer</option>
          <option value="valor2">Designer</option>
          <option value="valor3">Dublador</option>
          <option value="valor3">Roteirista</option>
          <option value="valor3">Fotógrafo</option>
        </SelectInput> -->
        <div>
          <p class="text-neutral-300 text-lg">Função</p>
          <el-select v-model="selectUserFunction" placeholder="Select" size="large" @change="buscarUser">
            <el-option
              v-for="item in selectUserFunctionOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
        </div>
        <div class="flex justify-end mt-4 ms-auto">
          <WhiteButton @click="handleSubmit">
            Buscar
          </WhiteButton>
        </div>
      </div>
      <!-- <div v-if="users.length > 0">
        <div class="list mt-8">
          <div v-for="user in users" :key="user.id">
            <TeamCard :name="user.name" :Id="user.id" />
          </div>
        </div>
      </div>
      <div v-else class="mt-8">
        <div class="text-gray-500 text-lg">Nenhum freelancer encontrado</div>
      </div> -->

      <DefaultCard v-for="(user, index) in users" :key="index" class="p-3 my-1 flex justify-between">

        <div>
          <div class="text-lg text-white">{{ user.name }}</div>
          <div class="text-base text-neutral-300">Funcao: {{ user.userFunction ? user.userFunction : "Nao especificado" }}</div>
        </div>
        
        <div>
          <BlueButton @click="addToTeam(user.id)">
            Adicionar na equipe
          </BlueButton>
        </div>

      </DefaultCard>
    </DefaultCard>
  </div>
</template>

<style scoped>
.button {
  width: 100%;
  height: 100px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.list {
  margin-top: 10px;
}

.container {
  padding: 0px;
  margin: 0;
  flex-direction: column;
  align-items: center;
}

.add-function {
  width: 100px;
  height: 50px;
  margin-left: 10%;
  margin-top: 10%;
  align-self: center;
}
</style>