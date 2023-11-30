<script setup>

  definePageMeta({
    layout: 'dashboard'
  })

</script>

<template>
  <div class="flex mt-12 gap-12">
    <DefaultCard class="w-1/3">
      <div class="container container-fluid mx-12">
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
    <DefaultCard class="w-2/3">
        <div class="flex gap-12">
        <FormInput name="nome" label="Nome do freelancer"></FormInput>
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
                <div class="list" v-for="user in users" :key="user.id">
                <DefaultCard class="list">
                    {{ user.name }} - {{ user.email }}
                </DefaultCard>
                </div>
            </div>
        </div>
        <div v-else class="mt-8">
            <div class="text-gray-500 text-lg">Nenhum freelancer encontrado</div>

        </div>
        <!-- <div class="freelancers">
            <div v-for="user in users" :key="user.id">
                <TeamCard :name="user.name" :description="user.email"></TeamCard>
            </div>
        </div> -->

      
    </DefaultCard>
  </div>
</template>

HTML
<script>

import { ref, onMounted } from 'vue'
  import { useRouter } from 'vue-router'

  const functionName = ref('')
  const users = ref([])
  const router = useRouter()

  const getUsers = async () => {
    try {
      const response = await fetch(`http://localhost:8080/users/Function/${functionName.value}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });
      if (response.ok) {
        const data = await response.json()
        users.value = data
      } else {
        console.error('Erro ao obter usuários:', response.statusText)
      }
    } catch (error) {
      console.error('Erro ao obter usuários:', error)
    }
  }

  const handleSubmit = async () => {
    functionName.value = document.getElementById('functionName').value
    getUsers()
  }


// definePageMeta({
//     layout: 'dashboard'
// });

// const activeName = ref('freelancers');
// const functionName = ref(''); // Certifique-se de que a variável functionName está definida

// var users = ref([]);

// onMounted(() => {
//     loadTeams();
// });

// function loadTeams() {
//     console.log("Load freelancers");
//     // Certifique-se de importar a função apiFetch de onde ela é definida
//     apiFetch(`/users/Function/${functionName.value}`)
//         .then(res => {
//             users.value = res.data;
//             console.log(res);
//         }).catch(err => {
//             console.log(err);
//         });
// }

// export default {
//     setup() {
//         return {
//             users,
//             loadTeams
//         };
//     }
// };
</script>

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