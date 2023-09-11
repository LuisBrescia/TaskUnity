### 3.3.2 Processo 2 – Gerenciar projeto

O processo de gerenciar projeto começa com a criação de um projeto, onde o usuário especifica os detalhes. Em seguida, vagas são abertas para freelancers, que podem se candidatar e ser selecionados com base em suas habilidades e experiência.

![Exemplo de um Modelo BPMN do PROCESSO 2](../images/processo-2-gerenciar-projeto.png "Modelo BPMN do Processo 2.")


#### Detalhamento das atividades

* **Acessar pagina inicial:**
    Após efetuarem o login, os usuários são redirecionados para a página inicial, onde têm a oportunidade de visualizar projetos existentes e criar novos projetos.

* **Procurar projeto:**
    Ao acessar a página inicial, os usuários, especialmente freelancers, têm a possibilidade de explorar projetos nos quais desejam contribuir.

* **Detalhar projeto:**
    Nesta etapa, o usuário contratante adiciona todos os detalhes do projeto, incluindo seu nome, especificações, objetivos e outros elementos essenciais.

<<<<<<< Updated upstream
#

### **Nome da atividade 1**
=======
* **Abrir vagas parar freelancers:**
    O usuário contratante abre as vagas necessárias para o desenvolvimento do projeto, especificando as habilidades e os requisitos necessários para cada vaga.
>>>>>>> Stashed changes

* **Se inscrever para vaga:**
    Uma vez que um freelancer encontra um projeto que lhe interessa, ele se inscreve para a vaga e envia seu currículo, demonstrando seu interesse e qualificações.

* **Adicionar freelancer ao projeto:**
    O usuário contratante tem a capacidade de revisar os perfis dos candidatos, verificar suas habilidades, experiência e avaliações de projetos anteriores, antes de selecionar os freelancers mais adequados para as vagas disponíveis.


<<<<<<< Updated upstream
### **Nome da atividade 2**
=======
**Acessar pagina inicial**
>>>>>>> Stashed changes

| **Campo** | **Tipo** | **Restrições** | **Valor default** |
| --------- | -------- | -------------- | ----------------- |
| Projetos  | tabela   |                |                   |

| **Comandos**  | **Destino**  | **Tipo** |
| ------------- | ------------ | -------- |
| criar projeto | detalhamento | default  |


**Procurar projeto**

| **Campo** | **Tipo** | **Restrições** | **Valor default** |
| --------- | -------- | -------------- | ----------------- |
| Projetos  | tabela   |                |                   |

| **Comandos**      | **Destino**  | **Tipo** |
| ----------------- | ------------ | -------- |
| Clicar no projeto | Se inscrever |          |


**Detalhar projeto**

| **Campo** | **Tipo**       | **Restrições** | **Valor default** |
| --------- | -------------- | -------------- | ----------------- |
| nome      | caixa de texto |                |                   |
| detalhe   | caixa de texto |                |                   |
| objetivo  | caixa de texto |                |                   |
| vagas     | caixa de texto |                |                   |


**Abrir vagas parar freelancers**

| **Campo** | **Tipo** | **Restrições** | **Valor default** |
| --------- | -------- | -------------- | ----------------- |
| Projeto   |          |                |                   |

| **Comandos**   | **Destino**       | **Tipo** |
| -------------- | ----------------- | -------- |
| publicar vagas | avaliar candidato |          |


**Se inscrever para vaga**

| **Campo** | **Tipo** | **Restrições** | **Valor default** |
| --------- | -------- | -------------- | ----------------- |
| Projeto   |          |                |                   |

| **Comandos** | **Destino**      | **Tipo** |
| ------------ | ---------------- | -------- |
| inscrever-se | enviar currículo |          |


**Adicionar freelancer ao projeto**

| **Campo** | **Tipo** | **Restrições** | **Valor default** |
| --------- | -------- | -------------- | ----------------- |
| Projeto   |          |                |                   |

| **Comandos**         | **Destino**      | **Tipo** |
| -------------------- | ---------------- | -------- |
| contratar freelancer | fim da aplicação |          |