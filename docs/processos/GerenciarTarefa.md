# 3.3.5 Processo 5 - Gerenciar perfil

### Este processo é responsável por lidar com quaisquer alterações no perfil do usuário, como foto de perfil, nome, senha, habilidades, experiências profissionais, etc... 

<!-- > **Autor:** Luís Brescia -->

#

![BPMN Gerenciar Perfil](../images/processos/GerenciarTarefas.png)

## Detalhamento das atividades

> Obs: algumas sugestões abaixo, processo ainda não foi discutido com o grupo.

### **Pesquisar por uma nova tarefa** (Freelancer)

    Usuário insere parametros de busca como preço oferecido e habilidades requisistadas, e é carregada para ele uma lista de tarefas que se encaixam nos parâmetros de busca, tarefas essas que em sua atribuição, foi selecionado a opção "abrir para o público" pelo dono do projeto.

    Nesta lista, para cada item tarefa será exibido nome da tarefa, preço oferecido, e habilidades requisitadas.

### **Selecionar tarefa e enviar candidatura** (Freelancer)

    Ao usuário clicar em uma tarefa a qual se interessou, é exibido um modal com mais informações sobre ela, como descrição detalhada, dono do projeto e prazo para entrega, além de um botão "candidatar-se", junto com um campo para o usuário inserir uma mensagem para o dono do projeto.

    Ao clicar em "candidatar-se", tarefa é redirecionada para a seção "candidaturas pendentes", na própria tela de tarefas.

### **Visualizar Solicitação de tarefas** (Freelancer)

    Nesta aba o freelancer tem as opção de cancelar candidatura para uma tarefa, e aceitar ou recusar uma solicitação de tarefa.

### **Cancelar Candidatura** (Freelancer)

    Ao clicar em "cancelar candidatura", a tarefa é removida da seção "candidaturas pendentes".

### **Aceitar/Recusar proposta** (Freelancer)

    Ao clicar em "aceitar proposta", a tarefa é removida da seção "candidaturas pendentes", e é adicionada na seção "tarefas em andamento".

    Ao clicar em "recusar proposta", a tarefa é removida da seção "candidaturas pendentes".

### **Selecionar umas das tarefas já atribuídas a ele** (Freelancer)

    Na aba "Minhas Tarefas", freelancer pode escolher uma das tarefas já atribuídas a ele, e clicar em "iniciar tarefa", para começar a trabalhar nela.

### **Adicionar mensagem à tarefa** (Freelancer)

    Freelancer dicionar uma mensagem à tarefa, para se comunicar com o dono do projeto, funciona semelhante ao trello.

### **Marcar tarefa como concluída** (Freelancer)

    Ao marcar tarefa como concluída, dono do projeto deve aceitar ou recusar a conclusão da tarefa.

### **Cria tarefa na edição do projeto** (Dono do projeto)

    Dono do projeto cria uma tarefa com devidas informações, como nome, descrição, preço oferecido, prazo para entrega, e habilidades requisitadas. Ele escolhe entre mandar aquela tarefa como proposta para um freelancer em específico, ou abrir para o público, para que qualquer freelancer possa se candidatar.

### **Analisar Candidatura** (Dono do projeto)

    Dono do projeto analisa candidatura de um freelancer, e pode aceitar ou recusar a proposta.

### **Analizar tarefa** (Dono do projeto)

    Dono do projeto analisa tarefa, e pode aceitar ou recusar a conclusão da tarefa.

