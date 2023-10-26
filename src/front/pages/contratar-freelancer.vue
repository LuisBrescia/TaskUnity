<script setup>

    definePageMeta({
        layout: 'dashboard'
    })

</script>

<template>
    <div class="flex mt-12 gap-12" >
        <DefaultCard>
            <div class="container mx-8 px-8 py-10 max-w-md ">
                <div class="grid gap-6 ">
                
                    <div class="rounded-lg p-6 shadow-md buttom">
                        <SlideButton></SlideButton>
                    </div>

                    
                    <div class="rounded-lg p-6 shadow-md buttom">
                        <SlideButton></SlideButton>
                    </div>

                    
                    <div class="rounded-lg p-6 shadow-md buttom">
                        <SlideButton></SlideButton>
                    </div>

                    
                    <div class="rounded-lg p-6 shadow-md buttom">
                        <SlideButton></SlideButton>
                    </div>

                </div>
            </div>
        </DefaultCard>
        <DefaultCard>
            <div class="flex mt-12 gap-12">
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
    width: 100%;
    height: 70%;
    display: flex;
    align-items: center;
    justify-content: center;
}

.list{
    margin-top: 10px;
}

</style>
