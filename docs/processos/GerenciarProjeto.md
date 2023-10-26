### 3.3.2 Processo 2 – Gerenciar projeto

O processo de gerenciamento de projeto começa assim que o usuário acessa a tela de projetos. O usuário poderá acessar seus projetos (se já tiver algum) ou criar um novo projeto.

![Exemplo de um Modelo BPMN do PROCESSO 2](../images/processos/GerenciarProjetos.png "Modelo BPMN do Processo 2.")


#### Detalhamento das atividades

* **Acessar tela de projetos:**
    Assim que o usuário acessar tela projetos, sera possível ver quais os projetos que pertence ao usuário e também a opção de criar um novo projeto.

* **Acessar projeto:**
    Se o usuário ja tiver algum projeto cadastro, será possível abrir o detalhamento do projeto, onde terá todas as informações referentes ao projeto.

* **Detalhar as informações do projeto:**
    se o usuário escolher criar um novo projeto, ele sera redirecionado para a tela de criação, onde ele informará todos os detalhes do projeto, como nome, descrição e as ferramentas que serão utilizadas.

* **Confirmar a criação do projeto:**
    assim que o usuário terminar de detalhar o projeto, ele poderá finalizar a criação do projeto.

* **Editar projeto:**
    assim que o usuário abrir o detalhamento do projeto, ele tera uma opção de editar as informações do projeto.

**Acessar pagina inicial**
| **Campo** | **Tipo** | **Restrições** | **Valor default** |
| --------- | -------- | -------------- | ----------------- |
| Projetos  | tabela   |                |                   |

| **Comandos**  | **Destino**  | **Tipo** |
| ------------- | ------------ | -------- |
| criar projeto | detalhamento | default  |


**Acessar projeto**

| **Campo** | **Tipo** | **Restrições** | **Valor default** |
| --------- | -------- | -------------- | ----------------- |
| Projetos  | tabela   |                |                   |

| **Comandos**      | **Destino**  | **Tipo** |
| ----------------- | ------------ | -------- |
| Clicar no projeto | Se inscrever |          |


**Detalhar as informações do projeto**

| **Campo** | **Tipo**       | **Restrições** | **Valor default** |
| --------- | -------------- | -------------- | ----------------- |
| nome      | caixa de texto |                |                   |
| detalhe   | caixa de texto |                |                   |
| objetivo  | caixa de texto |                |                   |
| vagas     | caixa de texto |                |                   |


**Confirmar a criação do projeto**

| **Campo** | **Tipo** | **Restrições** | **Valor default** |
| --------- | -------- | -------------- | ----------------- |
| Projeto   |          |                |                   |

| **Comandos**   | **Destino**       | **Tipo** |
| -------------- | ----------------- | -------- |
| publicar vagas | avaliar candidato |          |


**Editar projeto:**

| **Campo** | **Tipo** | **Restrições** | **Valor default** |
| --------- | -------- | -------------- | ----------------- |
| Projeto   |          |                |                   |

| **Comandos** | **Destino**      | **Tipo** |
| ------------ | ---------------- | -------- |
| inscrever-se | enviar currículo |          |
