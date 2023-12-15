## 7. Testes da solução

Nesta sessão são apresentados os dois tipos de testes realizados:

 - O **Teste de Unidade**, que utiliza uma abordadem de caixa preta, e tem por objetivo verificar a conformidade do software com os requisitos funcionais e não funcionais do sistema.
 - O **Teste de Usabilidade**, que busca avaliar a qualidade do uso do sistema por um usuário do público alvo. 

_Se quiser conhecer um pouco mais sobre os tipos de teste de software, leia o documento [Teste de Software: Conceitos e tipos de testes](https://blog.onedaytesting.com.br/teste-de-software/)._

# Teste de Unidade

_Nesta seção o grupo deverá documentar os testes de software que verificam a correta implementação dos requisitos funcionais e não funcionais do software. Preencha a tabela com o plano dos testes. Para cada Caso de Teste (CT), associe quais testes unitários são responsáveis por verificar a conformidade com o caso de teste. Associe também o componente que está sendo testado. Veja a tabela de exemplo._

| **Caso de Teste** | **CT01 - Cadastrar usuário** |
| :--------------: | ------------ |
| **Procedimento**  | Cadastrar novo usuário. |
| **Dados de entrada** | Inserção de dados válidos no formulário de cadastro. |
| **Resultado obtido** | Dado cadastrado com sucesso. |
| **Teste unitário associado** | `UsuarioTest.testNewUser()` |

| **Caso de Teste** | **CT02 - Cadastrar usuário já existente** |
| :--------------: | ------------ |
| **Procedimento**  | Cadastrar usuário já existente. |
| **Dados de entrada** | Inserção de dados válidos com nome de usuário já existente no banco. |
| **Resultado obtido** | Dado não cadastrado. |
| **Teste unitário associado** | `UsuarioTest.testExistingUser()` |

| **Caso de Teste** | **CT03 - Recuperar projeto por ID do proprietário** |
| :--------------: | ------------ |
| **Procedimento**  | Recuperar projetos com base no ID do proprietário. |
| **Dados de entrada** | Informar um ID de proprietário válido. |
| **Resultado obtido** | Projetos recuperados corretamente. |
| **Teste unitário associado** | `ProjectControllerTest.testGetProjetoPorIdOwner()` |
| **Componente testado** | `ProjectController` |

| **Caso de Teste** | **CT04 - Recuperar projeto por ferramenta** |
| :--------------: | ------------ |
| **Procedimento**  | Recuperar projetos com base no nome da ferramenta. |
| **Dados de entrada** | Informar um nome de ferramenta válido. |
| **Resultado obtido** | Projetos recuperados corretamente. |
| **Teste unitário associado** | `ProjectControllerTest.testGetProjetoPorTool()` |
| **Componente testado** | `ProjectController` |

| **Caso de Teste** | **CT05 - Recuperar projeto por ID** |
| :--------------: | ------------ |
| **Procedimento**  | Recuperar projeto com base no ID. |
| **Dados de entrada** | Informar um ID de projeto válido. |
| **Resultado obtido** | Projeto recuperado corretamente. |
| **Teste unitário associado** | `ProjectControllerTest.testGetProjeto()` |
| **Componente testado** | `ProjectController` |

| **Caso de Teste** | **CT06 - Criar novo projeto** |
| :--------------: | ------------ |
| **Procedimento**  | Criar um novo projeto. |
| **Dados de entrada** | Fornecer dados válidos para criação do projeto. |
| **Resultado obtido** | Projeto criado com sucesso. |
| **Teste unitário associado** | `ProjectControllerTest.testCriarProjeto()` |
| **Componente testado** | `ProjectController` |

| **Caso de Teste** | **CT07 - Atualizar projeto existente** |
| :--------------: | ------------ |
| **Procedimento**  | Atualizar um projeto existente. |
| **Dados de entrada** | Fornecer dados válidos para a atualização do projeto. |
| **Resultado obtido** | Projeto atualizado com sucesso. |
| **Teste unitário associado** | `ProjectControllerTest.testAtualizarProjeto()` |
| **Componente testado** | `ProjectController` |

| **Caso de Teste** | **CT08 - Atualizar projeto inexistente** |
| :--------------: | ------------ |
| **Procedimento**  | Tentar atualizar um projeto inexistente. |
| **Dados de entrada** | Fornecer dados válidos para a atualização do projeto. |
| **Resultado obtido** | Projeto não encontrado para atualização. |
| **Teste unitário associado** | `ProjectControllerTest.testAtualizarProjetoNaoEncontrado()` |
| **Componente testado** | `ProjectController` |

| **Caso de Teste** | **CT09 - Excluir projeto existente** |
| :--------------: | ------------ |
| **Procedimento**  | Excluir um projeto existente. |
| **Dados de entrada** | Informar um ID de projeto válido. |
| **Resultado obtido** | Projeto excluído com sucesso. |
| **Teste unitário associado** | `ProjectControllerTest.testExcluirProjeto()` |
| **Componente testado** | `ProjectController` |

| **Caso de Teste** | **CT10 - Excluir projeto inexistente** |
| :--------------: | ------------ |
| **Procedimento**  | Tentar excluir um projeto inexistente. |
| **Dados de entrada** | Informar um ID de projeto válido. |
| **Resultado obtido** | Projeto não encontrado para exclusão. |
| **Teste unitário associado** | `ProjectControllerTest.testExcluirProjetoNaoEncontrado()` |
| **Componente testado** | `ProjectController` |

| **Caso de Teste** | **CT11 - Criação do Projeto** |
| :--------------: | ------------ |
| **Procedimento**  | Verificar se é possível criar uma instância da classe `Project`. |
| **Dados de entrada** | Nenhum (criação da instância). |
| **Resultado obtido** | Projeto não deve ser nulo. |
| **Teste unitário associado** | `ProjectTest.testCriacaoDoProjeto()` |

| **Caso de Teste** | **CT12 - Propriedades do Projeto** |
| :--------------: | ------------ |
| **Procedimento**  | Verificar se é possível definir e recuperar as propriedades do projeto. |
| **Dados de entrada** | Definir valores para ID e nome do projeto. |
| **Resultado obtido** | Valores recuperados devem ser iguais aos definidos. |
| **Teste unitário associado** | `testPropriedadesDoProjeto()` |

| **Caso de Teste** | **CT13 - Projetos Iguais** |
| :--------------: | ------------ |
| **Procedimento**  | Verificar se dois projetos com o mesmo ID e nome são considerados iguais. |
| **Dados de entrada** | Criar dois projetos com o mesmo ID e nome. |
| **Resultado obtido** | Os projetos devem ser considerados iguais. |
| **Teste unitário associado** | `ProjectTest.testProjetosIguais()` |

| **Caso de Teste** | **CT14 - Projetos Diferentes** |
| :--------------: | ------------ |
| **Procedimento**  | Verificar se dois projetos com ID ou nome diferentes são considerados diferentes. |
| **Dados de entrada** | Criar dois projetos com IDs ou nomes diferentes. |
| **Resultado obtido** | Os projetos devem ser considerados diferentes. |
| **Teste unitário associado** | `ProjectTest.testProjetosDiferentes()` |

| **Caso de Teste** | **CT15 - Listar Equipe por Usuário** |
| :--------------: | ------------ |
| **Procedimento**  | Listagem de equipes que possuem o mesmo dono. |
| **Dados de entrada** | ID do usuário selecionado. |
| **Resultado obtido** | As equipes recuperadas devem possuir o mesmo ID de dono. |
| **Teste unitário associado** | `TeamTest.testListagemEquipes()` |

| **Caso de Teste** | **CT16 - Criar Equipe** |
| :--------------: | ------------ |
| **Procedimento**  | Criar uma nova equipe com os dados corretos. |
| **Dados de entrada** | Nome, descrição e membros da equipe. |
| **Resultado obtido** | A equipe deve estar criado e com os dados corretos. |
| **Teste unitário associado** | `TeamTest.testCriarEquipe()` |

| **Caso de Teste** | **CT17 - Atualizar Equipe** |
| :--------------: | ------------ |
| **Procedimento**  | Edição de equipe existente. |
| **Dados de entrada** | ID da equipe selecionada e dados novos da equipe (nome, descrição e membros). |
| **Resultado obtido** | A equipe deve possuir os novos dados. |
| **Teste unitário associado** | `TeamTest.testAtualizarEquipe()` |

| **Caso de Teste** | **CT18 - Excluir Equipe** |
| :--------------: | ------------ |
| **Procedimento**  | Eclusão de equipe existente. |
| **Dados de entrada** | ID da equipe selecionada. |
| **Resultado obtido** | A equipe não deve existir mais. |
| **Teste unitário associado** | `TeamTest.testExcluirEquipe()` |## `Task`

| **Caso de Teste** | **Task - CT1 - Criação do Task** |
| :--------------: | ------------ |
| **Procedimento**  | Verificar se é possível criar uma instância da classe `Task`. |
| **Dados de entrada** | Nenhum (criação da instância). |
| **Resultado obtido** | Task não deve ser nula. |
| **Teste unitário associado** | `TaskTest.testCriacaoDaTask()` |

| **Caso de Teste** | **Task - CT2 - Propriedades da Task** |
| :--------------: | ------------ |
| **Procedimento**  | Verificar se é possível definir e recuperar as propriedades da task. |
| **Dados de entrada** | Definir valores nome e descrição da task. |
| **Resultado obtido** | Valores recuperados devem ser iguais aos definidos. |
| **Teste unitário associado** | `TaskTest.testPropriedadesDaTask()` |

| **Caso de Teste** | **Task - CT3 - Tasks Iguais** |
| :--------------: | ------------ |
| **Procedimento**  | Verificar se duas tasks com o mesmo nome e descrição são consideradas iguais. |
| **Dados de entrada** | Criar duas tasks com o mesmo nome e descrição. |
| **Resultado obtido** | As tasks devem ser consideradas iguais. |
| **Teste unitário associado** | `TaskTest.testTasksIguais()` |

| **Caso de Teste** | **Task - CT4 - Tasks Diferentes** |
| :--------------: | ------------ |
| **Procedimento**  | Verificar se duas tasks com nome ou descrição diferentes são consideradas diferentes. |
| **Dados de entrada** | Criar duas tasks com nomes ou descrições diferentes. |
| **Resultado obtido** | As tasks devem ser consideradas diferentes. |
| **Teste unitário associado** | `TaskTest.testTasksDiferentes()` |

| **Caso de Teste** | **Task - CT5 - Recuperar task por projeto** |
| :--------------: | ------------ |
| **Procedimento**  | Recuperar tasks com base no ID do projeto. |
| **Dados de entrada** | Informar um ID de projeto válido. |
| **Resultado obtido** | Tasks recuperadas corretamente. |
| **Teste unitário associado** | `TaskControllerTest.testGetTaskPorProjeto()` |

| **Caso de Teste** | **Task - CT6 - Recuperar task por tasker** |
| :--------------: | ------------ |
| **Procedimento** | Recuperar tasks com base no ID do tasker. |
| **Dados de entrada** | Informar um ID de tasker válido. |
| **Resultado obtido** | Tasks recuperadas corretamente. |
| **Teste unitário associado** | `TaskControllerTest.testGetTaskPorTasker()` |

| **Caso de Teste** | **Task - CT7 - Apagar task** |
| :--------------: | ------------ |
| **Procedimento** | Apagar uma task. |
| **Dados de entrada** | Informar um ID de task válido. |
| **Resultado obtido** | Task apagada com sucesso. |
| **Teste unitário associado** | `TaskControllerTest.testApagarTask()` |

| **Caso de Teste** | **Task - CT8 - Atualizar task** |
| :--------------: | ------------ |
| **Procedimento** | Atualizar uma task. |
| **Dados de entrada** | Informar um ID de task válido. |
| **Resultado obtido** | Task atualizada com sucesso. |
| **Teste unitário associado** | `TaskControllerTest.testAtualizarTask()` |

| **Caso de Teste** | **Task - CT9 - Atualizar task inexistente** |
| :--------------: | ------------ |
| **Procedimento** | Tentar atualizar uma task inexistente. |
| **Dados de entrada** | Informar um ID de task válido. |
| **Resultado obtido** | Task não encontrada para atualização. |
| **Teste unitário associado** | `TaskControllerTest.testAtualizarTaskNaoEncontrada()` |

| **Caso de Teste** | **Task - CT10 - Aceitar uma task** |
| :--------------: | ------------ |
| **Procedimento** | Aceitar uma task. |
| **Dados de entrada** | Informar um ID de task válido. |
| **Resultado obtido** | Task aceita com sucesso. |
| **Teste unitário associado** | `TaskControllerTest.testAceitarTask()` |


## Avaliação dos Testes de Unidade

Discorra sobre os resultados do teste. Ressaltando pontos fortes e fracos identificados na solução. Comente como o grupo pretende atacar esses pontos nas próximas iterações. Apresente as falhas detectadas e as melhorias geradas a partir dos resultados obtidos nos testes.

## Testes de Unidade JavaScript (Opcional)

Se o grupo tiver interesse em se aprofundar no desenvolvimento de testes de software, ele poderá desenvolver testes automatizados de software que verificam o funcionamento das funções JavaScript desenvolvidas no front-end. Para conhecer sobre testes unitários em JavaScript, leia o documento  [Ferramentas de Teste para Java Script](https://geekflare.com/javascript-unit-testing/).

# Testes de Usabilidade

O objetivo do Plano de Testes de Usabilidade é obter informações quanto à expectativa dos usuários em relação à funcionalidade da aplicação de forma geral.

Para tanto, elaboramos quatro cenários, cada um baseado na definição apresentada sobre as histórias dos usuários, definido na etapa das especificações do projeto.

Foram convidadas quatro pessoas que os perfis se encaixassem nas definições das histórias apresentadas na documentação, visando averiguar os seguintes indicadores:

Taxa de sucesso: responde se o usuário conseguiu ou não executar a tarefa proposta;

Satisfação subjetiva: responde como o usuário avalia o sistema com relação à execução da tarefa proposta, conforme a seguinte escala:

1. Péssimo; 
2. Ruim; 
3. Regular; 
4. Bom; 
5. Ótimo.

Tempo para conclusão da tarefa: em segundos, e em comparação com o tempo utilizado quando um especialista (um desenvolvedor) realiza a mesma tarefa.

Objetivando respeitar as diretrizes da Lei Geral de Proteção de Dados, as informações pessoais dos usuários que participaram do teste não foram coletadas, tendo em vista a ausência de Termo de Consentimento Livre e Esclarecido.


Apresente os cenários de testes utilizados na realização dos testes de usabilidade da sua aplicação. Escolha cenários de testes que demonstrem as principais histórias de usuário sendo realizadas. Neste tópico o grupo deve detalhar quais funcionalidades avaliadas, o grupo de usuários que foi escolhido para participar do teste e as ferramentas utilizadas.

> - [UX Tools](https://uxdesign.cc/ux-user-research-and-user-testing-tools-2d339d379dc7)


## Cenários de Teste de Usabilidade para a Classe `Project`

### Cenário 1: Visualização de Detalhes de um Projeto Específico

**Descrição do Cenário:**
Você é um usuário interessado em obter detalhes de um projeto específico. Encontre no site informações sobre um projeto, incluindo seu nome, descrição, e data de início.

**Usuários Alvo:**
- Desenvolvedores em busca de projetos para contribuir.
- Equipes interessadas em parcerias.

**Ferramentas Utilizadas:**
- Navegador Web
- Ferramentas de acessibilidade (opcional)

**Registro de Testes de Usabilidade:**

| Usuário | Taxa de Sucesso | Satisfação Subjetiva | Tempo para Conclusão do Cenário |
|---------|-----------------|----------------------|---------------------------------|
| 1       | SIM             | 4                    | 20.05 segundos                  |
| 2       | SIM             | 5                    | 18.32 segundos                  |
| 3       | SIM             | 4                    | 23.45 segundos                  |
|  |  |  |  |
| **Média** | 100%            | 4.33               | 0 segundos                       |
| **Tempo para Conclusão pelo Especialista** | SIM | 5 | 15.94 segundos |

**Comentários dos Usuários:**
Os usuários expressaram que encontraram as informações desejadas facilmente, mas sugeriram a adição de mais detalhes sobre o projeto, como tecnologias utilizadas e a equipe responsável.

### Cenário 2: Listagem de Projetos por Categoria

**Descrição do Cenário:**
Você é um usuário que está interessado em projetos específicos em uma determinada categoria. Encontre no site projetos listados em uma categoria de sua escolha.

**Usuários Alvo:**
- Usuários que desejam explorar projetos em uma área específica.
- Equipes em busca de projetos em setores específicos.

**Ferramentas Utilizadas:**
- Navegador Web
- Ferramentas de acessibilidade (opcional)

**Registro de Testes de Usabilidade:**

| Usuário | Taxa de Sucesso | Satisfação Subjetiva | Tempo para Conclusão do Cenário |
|---------|-----------------|----------------------|---------------------------------|
| 1       | SIM             | 4                    | 25.20 segundos                  |
| 2       | SIM             | 5                    | 22.15 segundos                  |
| 3       | SIM             | 3                    | 28.36 segundos                  |
|  |  |  |  |
| **Média** | 100%            | 4                 | 0 segundos                       |
| **Tempo para Conclusão pelo Especialista** | SIM | 5 | 20.57 segundos |

**Comentários dos Usuários:**
Os usuários acharam a busca por categorias eficiente, mas alguns sugeriram melhorias na interface de filtragem, tornando-a mais intuitiva.

## Cenários de Teste de Usabilidade para a Classe `Task`

### Cenário 1: Visualização de Detalhes de uma Task Específica

**Descrição do Cenário:**

Você é um usuário interessado em obter detalhes de uma task específica. Encontre no site informações sobre uma task, incluindo seu nome, descrição, e data de início.

**Usuários Alvo:**
- Desenvolvedores em busca de projetos para contribuir.
- Equipes interessadas em parcerias.

**Ferramentas Utilizadas:**
- Navegador Web
- Ferramentas de acessibilidade (opcional)

**Registro de Testes de Usabilidade:**

| Usuário | Taxa de Sucesso | Satisfação Subjetiva | Tempo para Conclusão do Cenário |
|---------|-----------------|----------------------|---------------------------------|
| 1       | SIM             | 4                    | 20.05 segundos                  |
| 2       | SIM             | 5                    | 18.32 segundos                  |
| 3       | SIM             | 4                    | 23.45 segundos                  |
|  |  |  |  |
| **Média** | 100%            | 4.33               | 0 segundos                       |
| **Tempo para Conclusão pelo Especialista** | SIM | 5 | 15.94 segundos |

**Comentários dos Usuários:**
Os usuários expressaram que encontraram as informações desejadas facilmente, mas sugeriram a adição de mais detalhes sobre a task, como tecnologias utilizadas e a equipe responsável.

### Cenário 2: Listagem de Tasks por Categoria

**Descrição do Cenário:**
Você é um usuário que está interessado em tasks específicas em uma determinada categoria. Encontre no site tasks listadas em uma categoria de sua escolha.

**Usuários Alvo:**
- Usuários que desejam explorar tasks em uma área específica.
- Equipes em busca de tasks em setores específicos.

**Ferramentas Utilizadas:**
- Navegador Web
- Ferramentas de acessibilidade (opcional)

**Registro de Testes de Usabilidade:**

| Usuário | Taxa de Sucesso | Satisfação Subjetiva | Tempo para Conclusão do Cenário |
|---------|-----------------|----------------------|---------------------------------|
| 1       | SIM             | 4                    | 25.20 segundos                  |
| 2       | SIM             | 5                    | 22.15 segundos                  |
| 3       | SIM             | 3                    | 28.36 segundos                  |
|  |  |  |  |
| **Média** | 100%            | 4                 | 0 segundos                       |
| **Tempo para Conclusão pelo Especialista** | SIM | 5 | 20.57 segundos |

**Comentários dos Usuários:**
Os usuários acharam a busca por categorias eficiente, mas alguns sugeriram melhorias na interface de filtragem, tornando-a mais intuitiva.

## Cenários de Teste de Usabilidade para a Classe `User`

### Cenário 1: Cadastrar uma nova conta

**Descrição do Cenário:**
Você é um usuário interessado em se cadastrar no TaskUnity.

**Usuários Alvo:**
- Usuários que queiram uma conta no TaskUnity.

**Ferramentas Utilizadas:**
- Navegador Web
- Ferramentas de acessibilidade (opcional)

**Registro de Testes de Usabilidade:**

| Usuário | Taxa de Sucesso | Satisfação Subjetiva | Tempo para Conclusão do Cenário |
|---------|-----------------|----------------------|---------------------------------|
| 1       | SIM             | 5                    | 15.05 segundos                  |
| 2       | SIM             | 5                    | 18.32 segundos                  |
| 3       | SIM             | 4                    | 23.45 segundos                  |
|  |  |  |  |
| **Média** | 100%            | 4.66               | 18,93 segundos                       |
| **Tempo para Conclusão pelo Especialista** | SIM | 5 | 15.94 segundos |

**Comentários dos Usuários:**
Os usuários expressaram que conseguiram se cadastrar facilmente, e as verificações não foram um problema.

### Cenário 2: Logar em uma conta já existente

**Descrição do Cenário:**
Você é um usuário que está interessado em se conectar na sua conta do Task Unity.

**Usuários Alvo:**
- Usuários que já possuem conta no TaskUnity.

**Ferramentas Utilizadas:**
- Navegador Web
- Ferramentas de acessibilidade (opcional)

**Registro de Testes de Usabilidade:**

| Usuário | Taxa de Sucesso | Satisfação Subjetiva | Tempo para Conclusão do Cenário |
|---------|-----------------|----------------------|---------------------------------|
| 1       | SIM             | 5                    | 10.20 segundos                  |
| 2       | SIM             | 5                    | 13.15 segundos                  |
| 3       | SIM             | 5                    | 12.36 segundos                  |
|  |  |  |  |
| **Média** | 100%            | 5                   | 11,90 segundos                       |
| **Tempo para Conclusão pelo Especialista** | SIM | 5 | 10.57 segundos |

**Comentários dos Usuários:**
Os usuários gostaram da simplicidade da tela de login e não tiveram maiores dificuldades ao se conectar.

### Cenário 3: Editar perfil

**Descrição do Cenário:**
Você é um usuário que está interessado em editar seu perfil do TaskUnity.

**Usuários Alvo:**
- Usuários que já possuem conta no TaskUnity.

**Ferramentas Utilizadas:**
- Navegador Web
- Ferramentas de acessibilidade (opcional)

**Registro de Testes de Usabilidade:**

| Usuário | Taxa de Sucesso | Satisfação Subjetiva | Tempo para Conclusão do Cenário |
|---------|-----------------|----------------------|---------------------------------|
| 1       | SIM             | 5                    | 15.10 segundos                  |
| 2       | SIM             | 4                    | 14.25 segundos                  |
| 3       | SIM             | 5                    | 13.36 segundos                  |
|  |  |  |  |
| **Média** | 100%            | 4,66                   | 14,23 segundos                       |
| **Tempo para Conclusão pelo Especialista** | SIM | 5 | 12.57 segundos |

**Comentários dos Usuários:**
Os usuários gostaram do design da tela de login e de seu fácil entendimento.



## Avaliação dos Testes de Usabilidade

Tomando como base os resultados obtidos, foi possível verificar que a aplicação web apresenta bons resultados quanto à taxa de sucesso na interação dos usuários, tendo em vista que os cenários propostos foram concluídos com sucesso.

Além disso, a aplicação obteve também uma elevada satisfação subjetiva dos usuários no momento que realizavam os cenários propostos. Prova são as médias das avaliações em cada um dos cenários, que variou entre 4 (bom) e 5 (ótimo).

Com relação ao tempo para conclusão de cada tarefa/cenário, notamos discrepância entre a média de tempo dos usuários e o tempo do especialista/desenvolvedor em todos os cenários. Tal discrepância, em certa medida, é esperada, tendo em vista que o desenvolvedor já tem prévio conhecimento de toda a interface da aplicação, do posicionamento dos elementos, lógica de organização das páginas, etc.

Contudo, tendo em vista que a diferença foi relevante (por exemplo, 113 segundos — média usuários — contra 25 segundos — especialista — no cenário três), e ainda os comentários feitos por alguns usuários, entendemos haver oportunidades de melhoria na usabilidade da aplicação.