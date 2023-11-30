<template>
    <div class="form-container">
        <form class="form" @submit.prevent="handleSubmit">
            <div class="form-group">
                <label for="name">Nome do projeto</label>
                <input type="text" id="name" required="">
            </div>
            <div class="form-group">
                <label for="textarea">Descrição</label>
                <textarea id="textarea" rows="10" cols="50" required=""></textarea>
            </div>
            <div class="form-group">
                <label for="textarea">Ferramentas</label>
                <textarea id="tools" rows="10" cols="50" required=""></textarea>
            </div>
            <button>
                <span class="button_top"> Criar </span>
            </button>

            <div v-if="projectCreated" class="success-message">
                Projeto criado com sucesso!
            </div>
            <!-- <el-row>
                <el-tag v-for="tag in dynamicTags" :key="tag.name" :type="tag.type" class="mx-1" closable
                    :disable-transitions="false" @close="handleClose(tag)">
                    {{ tag.name }}
                </el-tag>

                <el-input v-if="inputVisible" ref="InputRef" v-model="inputValue" class="ml-1 w-20" size="small"
                    @keyup.enter="handleInputConfirm" @blur="handleInputConfirm" />

                <el-button v-else class="button-new-tag ml-1" size="small" @click="showInput">
                    + New Tag
                </el-button>
            </el-row> -->

        </form>
    </div>
</template>

<script setup>

definePageMeta({
    layout: 'dashboard'
})

import { ref, onMounted } from 'vue';

const projectCreated = ref(false);
const router = useRouter();

const handleSubmit = async () => {
    const name = document.getElementById('name').value;
    const description = document.getElementById('textarea').value;
    const tools = document.getElementById('tools').value;
    const owner = 1; //temporariamente!!!

    const data = {
        name,
        description,
        tools,
        owner
    };

    try {
        const response = await fetch('http://localhost:8080/projects', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        if (response.ok) {
            projectCreated.value = true;

            // Redirecionar para a tela de projetos após 2 segundos
            setTimeout(() => {
                router.push('/projects');
            }, 2000);
        } else {
            console.error('Erro ao criar o projeto:', response.statusText);
        }
    } catch (error) {
        console.error('Erro ao criar o projeto:', error);
    }
};

onMounted(() => {
    
});

// const inputValue = ref('')
// const inputVisible = ref(false)
// const InputRef = ref(null)

// const dynamicTags = ref([
//     { name: 'Flutter', type: '' },
//     { name: 'Vue', type: 'success' },
//     { name: 'Blender', type: 'error' },
//     { name: 'Javascript', type: 'warning' },
//     { name: 'Laravel', type: 'danger' },
// ])

// const handleClose = (tag) => {
//     dynamicTags.value.splice(dynamicTags.value.indexOf(tag), 1)
// }

// const showInput = () => {
//     inputVisible.value = true
//     nextTick(() => {
//         InputRef.value.input.focus()
//     })
// }

// const handleInputConfirm = () => {
//     if (inputValue.value) {

//         let tag = {
//             name: inputValue.value,
//             type: 'success'
//         }

//         dynamicTags.value.push(tag)
//     }
//     inputVisible.value = false
//     inputValue.value = ''
// }

</script>

<style scoped>

.success-message {
    color: green;
    margin-top: 10px;
}
.form-container {
    width: 400px;
    background: linear-gradient(#212121, #212121) padding-box,
        linear-gradient(145deg, transparent 35%, #e81cff, #40c9ff) border-box;
    border: 2px solid transparent;
    padding: 32px 24px;
    font-size: 14px;
    font-family: inherit;
    color: white;
    display: flex;
    flex-direction: column;
    gap: 20px;
    box-sizing: border-box;
    border-radius: 16px;
    background-size: 200% 100%;
    animation: gradient 5s ease infinite;
}

@keyframes gradient {
    0% {
        background-position: 0% 50%;
    }

    50% {
        background-position: 100% 50%;
    }

    100% {
        background-position: 0% 50%;
    }
}

.form-container button:active {
    scale: 0.95;
}

.form-container .form {
    display: flex;
    flex-direction: column;
    gap: 20px;
}

.form-container .form-group {
    display: flex;
    flex-direction: column;
    gap: 2px;
}

.form-container .form-group label {
    display: block;
    margin-bottom: 5px;
    color: #717171;
    font-weight: 600;
    font-size: 12px;
}

.form-container .form-group input {
    width: 100%;
    padding: 12px 16px;
    border-radius: 8px;
    color: #fff;
    font-family: inherit;
    background-color: transparent;
    border: 1px solid #414141;
}

.form-container .form-group textarea {
    width: 100%;
    padding: 12px 16px;
    border-radius: 8px;
    resize: none;
    color: #fff;
    height: 96px;
    border: 1px solid #414141;
    background-color: transparent;
    font-family: inherit;
}

.form-container .form-group input::placeholder {
    opacity: 0.5;
}

.form-container .form-group input:focus {
    outline: none;
    border-color: #e81cff;
}

.form-container .form-group textarea:focus {
    outline: none;
    border-color: #e81cff;
}

.form-container .form-submit-btn {
    display: flex;
    align-items: flex-start;
    justify-content: center;
    align-self: flex-start;
    font-family: inherit;
    color: #717171;
    font-weight: 600;
    width: 40%;
    background: #313131;
    border: 1px solid #414141;
    padding: 12px 16px;
    font-size: inherit;
    gap: 8px;
    margin-top: 8px;
    cursor: pointer;
    border-radius: 6px;
}

.form-container .form-submit-btn:hover {
    background-color: #fff;
    border-color: #fff;
}

button {
    /* Variables */
    --button_radius: 0.75em;
    --button_color: #e8e8e8;
    --button_outline_color: #000000;
    font-size: 17px;
    font-weight: bold;
    border: none;
    border-radius: var(--button_radius);
    background: var(--button_outline_color);
}

.button_top {
    display: block;
    box-sizing: border-box;
    border: 2px solid var(--button_outline_color);
    border-radius: var(--button_radius);
    padding: 0.75em 1.5em;
    background: linear-gradient(to bottom right, #fb7185, #f43f5e);
    color: var(--button_outline_color);
    transform: translateY(-0.2em);
    transition: transform 0.1s ease;
}

button:hover .button_top {
    transform: translateY(-0.33em);
}

button:active .button_top {
    transform: translateY(0);
}
</style>