<script setup>

    definePageMeta({
        layout: 'dashboard'
    })

</script>

<template>
    <div class="flex mt-12 gap-12 buttom" >
        <DefaultCard>
            <div class="container mx-8 px-8 py-10 max-w-md">
                <div class="grid gap-6">
                
                <div class="bg-white rounded-lg p-6 shadow-md">
                    <SlideButton></SlideButton>
                </div>

                
                <div class="bg-white rounded-lg p-6 shadow-md">
                    <SlideButton></SlideButton>
                </div>

                
                <div class="bg-white rounded-lg p-6 shadow-md">
                    <SlideButton></SlideButton>
                </div>

                
                <div class="bg-white rounded-lg p-6 shadow-md">
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
                <FormInput name="descricao">Tempo de experiência</FormInput><br>
                <WhiteButton>Buscar</WhiteButton>

            </div>
            
        </DefaultCard>
    </div>

</template>

<style scoped>
.buttom{
    width: 100%;
    height: 70%;
}
</style>
