## 4. Projeto da solução

### 4.1. Diagrama de classes

![Diagrama de classes](../images/Diagrama%20de%20classes/taskunity_der.drawio.png "Diagrama de classes")

#### Detalhamento do diagrama

* **Usuário:**
    Possui os dados do usuário do sistema, podendo ser contratante ou freelancer.
* **Equipe:**
    Possui os dados da Equipe a ser criada, reunindo todos os freelancers que irão trabalhar em conjunto no projeto.
* **Projeto:**
    Possui os dados do projeto criado pelo contratante, onde serão reunidas as Equipes criadas para trabalhar em determinado projeto.

### 4.2. Modelo de dados

_O modelo entidade-relacionamento (MER) é uma representação visual das principais entidades e relacionamentos em um aplicativo.
Ele ajudará a entender a estrutura dos dados e como as informações são organizadas no Task Unity_ 

![Diagrama de Entidade Relacionamento](/docs/images/Diagrama%20de%20classes/taskunity_mer.png 'Diagrama de Entidade Relacionamento')

### 4.3. Tecnologias

| **Dimensão**   | **Tecnologia**  |
| ---            | ---             |
| Versionamento  | Git             |
| Front end      | Vue.js          |
| Front end      | Tailwindcss     |
| Back end       | Java SpringBoot |
| Log do sistema | Log4J           |
| Teste          | JUnit           |
| Deploy         | Vercel          |


### 4.4. Guias de estilo

## Identidade Visual

#### **Geral:**

- Site predominantemente escuro
- Paleta utiliza todo o espectro de cor (arco-íris)
- Branco bastante presente como cor complementar

#### **Tipografia:**
  
- Raleway
- Tailwind sans
- Tailwind serif
- Tailwind mono

#### **Ícones:**

 - module nuxt-icon

#### **Favicon:**

- iconamoon:3d-light

## Técnicas Utilizadas

#### **Glassmorphism:**

- Header
- Article
- UserCard
- WhiteButton
- Navbar

#### **Neomorphism:**
- BlueBlob
- GreenBlob
- RedBlob
- YellowBlob

## Cores

#### **Fundo:**

 - background: linear-gradient(144deg, rgb(0, 0, 15), rgb(0, 15, 15),  rgb(15, 15, 0),  rgb(15, 0, 15), rgb(0, 0, 15));

#### **Principais:**

- Azul: #3b82f6
- Verde: #22c55e
- Vermelho: #ef4444
- Amarelo: #eab308
- Neutro claro: #fafafa
- Neutro escuro: #0f0f0f

## Layouts

#### **Default:**

- /
- /projects/<parametro>

#### **Dashboard:**

- /profile
- /tasks
- /projects

## Aspectos de responsividade

#### **Menu mobile:**
- Lateral, abrindo da direita para a esquerda

#### **Dashboard**
- Localizado no inferior da tela

Apresente os estilos CSS criados para cada um dos elementos apresentados.
Outras seções podem ser adicionadas neste documento para apresentar padrões de componentes, de menus, etc.

### **Homepage**

![Homepage](../images/Telas/telaHome.PNG)

> **Links Úteis**:
>
> - [Como criar um guia de estilo de design da Web](https://edrodrigues.com.br/blog/como-criar-um-guia-de-estilo-de-design-da-web/#)
> - [CSS Website Layout (W3Schools)](https://www.w3schools.com/css/css_website_layout.asp)
> - [Website Page Layouts](http://www.cellbiol.com/bioinformatics_web_development/chapter-3-your-first-web-page-learning-html-and-css/website-page-layouts/)
> - [Perfect Liquid Layout](https://matthewjamestaylor.com/perfect-liquid-layouts)
> - [How and Why Icons Improve Your Web Design](https://usabilla.com/blog/how-and-why-icons-improve-you-web-design/)
