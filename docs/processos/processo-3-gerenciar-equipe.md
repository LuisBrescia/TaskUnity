### 3.3.3 Processo 3 – Gerenciar equipe

A gerência de equipe abrange a criação, visualização e edição da equipe. Ao criar a equipe será necessário preencher os campos "título", "descrição" e "membros" (onde membros possuirão seus respectivos cargos). Após criada sua equipe, o usuário poderá gerenciar os membros da mesma.

![Modelo BPMN do processo 3](/docs/images/processo-3-gerenciar-equipe.png "Modelo BPMN do processo gerência de equipe.")

#### Detalhamento das atividades

**Atividades dos contratantes:**

* **Acessar tela de equipe:**
    Quando o usuário está logado e tem um projeto criado, têm a possibilidade de entrar na tela de equipe.

* **Criar equipe:**
    Caso o usuário não possua uma equipe poderá criar uma. Ao preencher suas informações e confirmar, o usuário é redirecionado para a tela principal de equipe.

* **Solicitar entrada participante:**
    O usuário poderá solicitar entrada de freelancers, deixando pendente a entrada(ou não) do freelancer.

* **Editar participante:**
    O dono do projeto tem a possibilidade de editar os participantes já existentes.

* **Remover participante:**
  O dono do projeto tem a possibilidade de remover um ou mais participantes do projeto.

**Atividade do freelancer:**

* **Aceitar/Recusar participação:**
    Ao ser solicitado para entrar na equipe, o freelancer tem a possibilidade de aceitar ou recusar a solicitação.


**Acessar tela de equipe**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| título          | Caixa de Texto   |                |                   |
| descrição       | Caixa de Texto   |                |                   |
| membros         | Tabela           |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| editar               | início processo de editar      | edit              |


**Criar equipe**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| título          | Caixa de Texto   |                |                   |
| descrição       | Caixa de Texto   |                |                   |
| membros         | Área de texto    |                |                   |
| cargos          | Seleção única    |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| criar                | fim processo criar             | default           |
| cancelar             | cancelar processo criar        | cancel            |


**Solicitar entrada participante**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| freelancer      | Caixa de Texto   |                |                   |
| cargo           | Seleção única    |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| solicitar            | fim processo solicitar         | default           |
| cancelar             | cancelar processo solicitar    | cancel            |


**Editar participante**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| freelancer      | Caixa de Texto   |                |                   |
| cargo           | Seleção única    |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| editar               | fim processo editar            | default           |
| cancelar             | cancelar processo editar       | cancel            |


**Remover participante**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| freelancer      | Caixa de Texto   |                |                   |
| cargo           | Seleção única    |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| remover              | fim processo remover           | default           |
| cancelar             | cancelar processo remover      | cancel            |

**Aceitar/Recusar participação**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| deseja aceitar  | Caixa de Texto   |                |                   |

| **Comandos**         |  **Destino**                      | **Tipo**          |
| ---                  | ---                               | ---               |
| aceitar              | fim processo aceitar/recusar      | default           |
| recusar              | cancelar processo aceitar/recusar | cancel            |