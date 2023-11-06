<script setup>

    definePageMeta({
        layout: 'dashboard'
    })

</script>

<template>
    <div class="flex mt-12 gap-12" >
        <DefaultCard>
            <div class="container container-fluid mx-8 max-w-md ">
                <div class="container-selectFunction flex mx-2 max-w-md ">
                    <SelectInput name="Função">
                        <option value="valor1">Developer</option>
                        <option value="valor2" selected>Designer</option>
                        <option value="valor3">Dublador</option>
                        <option value="valor3">Roteirista</option>
                        <option value="valor3">Fotógrafo</option>
                    </SelectInput>
                    <WhiteButton class="add-function p-0 m-0">
                        <Icon name="tdesign:add" />
                    </WhiteButton>
                </div>
                <div class="grid gap-6 ">
                
                    <div class="rounded-lg p-0 my-4 shadow-md buttom col-md-12">
                        <SlideButton></SlideButton>
                    </div>

                    
                    <div class="rounded-lg p-0 my-4 shadow-md buttom col-md-12">
                        <SlideButton></SlideButton>
                    </div>

                    
                    <div class="rounded-lg p-0 my-4 shadow-md buttom col-md-12">
                        <SlideButton></SlideButton>
                    </div>

                    
                    <div class="rounded-lg p-0 my-4 shadow-md buttom col-md-12">
                        <SlideButton></SlideButton>
                    </div>

                </div>
            </div>
        </DefaultCard>
        <DefaultCard>
            <div class="flex gap-12">
                <FormInput name="nome">Nome do freelancer</FormInput><br>
                <SelectInput name="Tempo de experiência">
                    <option value="valor1">Até 1 ano</option>
                    <option value="valor2" selected>De 1 a 3 anos</option>
                    <option value="valor3">Mais de 3 anos</option>
                </SelectInput>
                <FormInput name="descricao">Especialização</FormInput><br>
                <WhiteButton>Buscar</WhiteButton>

            </div>

            <DefaultCard class="list">
                <DefaultCard class="list">Freelancer 1</DefaultCard>
                <DefaultCard class="list">Freelancer 2</DefaultCard>
                <DefaultCard class="list">Freelancer 3</DefaultCard>
                <DefaultCard class="list">Freelancer 4</DefaultCard>
                <DefaultCard class="list">Freelancer 5</DefaultCard>
            </DefaultCard>
            
        </DefaultCard>
    </div>

</template>

<style scoped>
.buttom{
    width: 100%;
    height: 70%;
    display: flex;
    align-items: center;
    justify-content: center;
}


.list{
    margin-top: 10px;
}

.container-selectFunction {
    margin-bottom: 10px;
    display: flex;
}

.container {
    padding: 0px;
    margin: 0;
    flex-direction: column;
    align-items: center;
}

.add-function{
    width: 100px;
    height: 50px;
    margin-left: 10%;
    margin-top: 10%;
    align-self: center;
}

</style>
