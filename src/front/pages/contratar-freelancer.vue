<script setup>
definePageMeta({
  layout: 'contratar-freelancer'
})

const users = ref([])

onMounted(() => {
  const functionName = document.getElementById('functionName').value
  fetch(`/users/Function/${functionName}`)
    .then((response) => response.json())
    .then((data) => {
      users.value = data
    })
    .catch((error) => {
      console.error('Erro ao buscar usuários:', error)
    })
})

const handleSubmit = async () => {
  const functionName = document.getElementById('functionName').value
    if (functionName) {
    await fetch(`/users/Function/${functionName}`)
        .then((response) => response.json())
        .then((data) => {
        users.value = data
        })
        .catch((error) => {
        console.error('Erro ao buscar usuários:', error)
        })
    }
}

// Adicionar um botao a cada user mostrado para adicionar ele à equipe com a rota "teams/{teamId}/addMember"
</script>

<template>
  <div class="flex mt-12 gap-12">
    <DefaultCard class="w-1/3 p-6">
      <div class="container container-fluid mx-6">
        <div class="grid gap-6">
          <div class="rounded-lg p-0 my-4 shadow-md button col-md-4">
            <SlideButton></SlideButton>
          </div>
          <div class="rounded-lg p-0 my-4 shadow-md button col-md-4">
            <SlideButton></SlideButton>
          </div>
          <div class="rounded-lg p-0 my-4 shadow-md button col-md-4">
            <SlideButton></SlideButton>
          </div>
          <div class="rounded-lg p-0 my-4 shadow-md button col-md-4">
            <SlideButton></SlideButton>
          </div>
        </div>
      </div>
    </DefaultCard>
    <DefaultCard class="w-2/3 p-6">
      <div class="flex gap-12">
        <FormInput name="Nome do freelancer" label="Nome do freelancer"></FormInput>
        <SelectInput name="Função" label="Função" id="functionName">
          <option value="valor1">developer</option>
          <option value="valor2">Designer</option>
          <option value="valor3">Dublador</option>
          <option value="valor3">Roteirista</option>
          <option value="valor3">Fotógrafo</option>
        </SelectInput>
        <div class="flex justify-end mt-4">
          <WhiteButton @click="handleSubmit">Buscar</WhiteButton>
        </div>
      </div>
      <div v-if="users.length > 0">
        <div class="mt-8">
          <div class="list">
            <div v-for="user in users" :key="user.id">
              <TeamCard :name="user.name" :Id="user.id"></TeamCard>
            </div>
          </div>
        </div>
      </div>
      <div v-else class="mt-8">
        <div class="text-gray-500 text-lg">Nenhum freelancer encontrado</div>
      </div>
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

