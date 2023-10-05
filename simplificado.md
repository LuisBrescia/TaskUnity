# **TaskUnity**

```Site para montar uma equipe de desenvolvedores```

#

# **Páginas:**

```Luís Brescia```
### **Homepage**
> Nenhum processo é executado nessa página
- Apresenta o que é o TaskUnity e como ele funciona.
- Na página inicial, terá um botão de login, que levará para a página de login.

Obs: Subir arquivo index.vue em \src\front\pages\

#

```Luiz Felipe```
### **Login**
> [Processo Gerenciar Login](/docs/processos/GerenciarLogin.md) (1/2 pessoa)
- Usuário poderá entrar com uma conta já existente ou criar uma nova.
- Ao entrar com uma conta já existente, será requisitado o email e a senha.
- Ao criar uma nova conta, será requisitado o nome, email, data de nascimento, senha e confirmação de senha.

Obs: Subir arquivo login.vue em \src\front\pages\

#

```Luiz Felipe```
### **Profile** > Dashboard como layout
> [Processo Gerenciar Perfil](/docs/processos/GerenciarPerfil.md) (1/2 pessoa)
- Esta tela usará o layout do dashboard por padrão "\src\front\layout\dashboard.vue"
- Usuário poderá editar seu perfil, alterando nome, senha, foto de perfil, e habilidades.

Obs: Subir arquivo profile.vue em \src\front\pages\
        
#

```André Hyodo```
### **Tasks** > Dashboard como layout
> [Processo Gerenciar Tarefas](/docs/processos/GerenciarTarefas.md) (1 pessoa)
- Esta tela usará o layout do dashboard por padrão "\src\front\layout\dashboard.vue"
-  Terá uma seção que contém as tarefas que aquele usuário está encarregado de fazer, deverá ser possível ordenar, seja por 'tempo para entregar', 'ordem alfabética', 'duração estimada'
- Deverá ter uma seção destinada a encontrar tarefas novas

Obs: Subir arquivo tasks.vue em \src\front\pages\

#

```Gustavo Pereira```
### **Projects** > Dashboard como layout
> [Processo Gerenciar Projetos](/docs/processos/GerenciarProjetos.md) (1 pessoa)
- Esta tela usará o layout do dashboard por padrão "\src\front\layout\dashboard.vue"
- Exibe os projetos que aquele usuário é proprietário.
- Deverá ter um botão para criar um novo projeto.
- Ao clicar em novo projeto, será requisitado o nome do projeto, uma descrição, e possíveis tecnologias a serem utilizadas.
- Ao clicar em um projeto já existente, será exibido um modal as informações do projeto, como nome, descrição, teconologias, e os membros do projeto, terá um botão 'abrir'.

Obs: Subir arquivo projects.vue em \src\front\pages\

#

```Marcus Vinicius & Luís Brescia```
### **Desenvolvimento do projeto**
> [Processo Gerenciar Desenvolvivento](/docs/processos/GerenciarDesenvolvimento.md) (2 pessoas)
- Tela após um projeto ser aberto.
- Será dividido em criar tarefas e gerenciar equipe.
- Aqui terá um botão 'configurações' que servirá para editar as informações do projeto, como nome, descrição, tecnologias, e membros.

    **Marcus Vinicius:**
- Na seção gerenciar equipe será possível adicionar novos membros, editar cargo, e remove-los.

    **Luís Brescia:**
- Na seção tarefas será possivel criar tarefas estimando seu tempo, e designa-las para um membro da equipe.

# **Layouts:**

### **Dashboard**

- Será aplicado as páginas de Profile, Tasks e Projects.

#