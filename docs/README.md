# :city_sunrise: Task Unity

* **André Teiichi Santos Hyodo, dehyodo@gmail.com**

* **Gustavo Pereira de Oliveira, gpo0251588@gmail.com**

* **Luís Felipe Teixeira Dias Brescia, luisfelipebrescia@gmail.com**

* **Luiz Felipe Campos de Morais, lfcamposdemorais@gmail.com**

* **Marcus Vinícius Carvalho de Oliveira, marcuscarvalhodeoliveira@gmail.com**

---

Professores:

* **José Laerte Pires Xavier Junior**

* **Luiz Henrique da Costa Silva**

---

_Curso de Engenharia de Software, Unidade Coaração Eucaristíco_

_Instituto de Informática e Ciências Exatas – Pontifícia Universidade Católica de Minas Gerais (PUC MINAS), Belo Horizonte – MG – Brasil_

---

_**Resumo**. Escrever aqui o resumo. O resumo deve contextualizar rapidamente o trabalho, descrever seu objetivo e, ao final, 
mostrar algum resultado relevante do trabalho (até 10 linhas)._

---

## 1. Introdução

### 1.1 Contextualização

No cenário atual, sabe-se que mais de 60% dos brasileiros aderiram ao trabalho freelancer no último ano. Existem apps que possibilitam a busca de serviços para que os freelancers se candidatem(Fiverr, 99freelas,Upwork), porém percebemos que a complexidade dos projetos muitas vezes exige habilidades variadas, com isto, surge uma necessidade crucial no gerenciamento eficaz de equipes de freelancers. O crescente mercado de freelancing tem transformado a maneira como as tarefas são realizadas, mas enfrentar desafios complexos e multifacetados exige mais do que apenas individualidade. Projetos que requerem a contribuição de múltiplos freelancers exigem um sistema eficiente para gerencia-los.

### 1.2 Problema

Diante dessas demandas crescentes, torna-se evidente que os atuais métodos de gerenciamento de freelancers não atendem adequadamente às complexidades de equipes virtuais formadas por profissionais independentes. Gerenciar tarefas, comunicação e colaboração em um ambiente de projeto multifacetado muitas vezes resulta em confusão, desorganização e, em última instância, em resultados abaixo do potencial.

### 1.3 Objetivo geral

O objetivo geral deste projeto é desenvolver o sistema Task Unity, que visa fornecer uma solução eficaz para o gerenciamento de freelancers, gerenciando eles não como entidades isoladas, mas sim como uma equipe independente. Permitindo que os gerentes de projeto organizem e coordenem a colaboração entre freelancers de maneira eficiente, garantindo o alinhamento de tarefas, o monitoramento do progresso e a comunicação eficaz.

#### 1.3.1 Objetivos específicos

* Desenvolvimento do Sistema: Criar uma plataforma online robusta que facilite o gerenciamento de equipes virtuais de freelancers, com recursos específicos para alocação de tarefas, acompanhamento de prazos e comunicação integrada.
* Implementação de Recursos de Colaboração: Introduzir ferramentas de comunicação e colaboração que otimizem o fluxo de informações entre os membros da equipe, possibilitando a coordenação eficaz e o compartilhamento de recursos.

### 1.4 Justificativas

O desenvolvimento do sistema Task Unity é justificado pela crescente número de projetos independentes, e pela necessidade de uma abordagem eficaz no gerenciamento de equipes de freelancers. A plataforma não apenas otimizará a coordenação entre os membros da equipe, mas também contribuirá para o aumento da produtividade e a qualidade do resultado final. A capacidade de atribuir tarefas, monitorar o progresso e facilitar a comunicação em uma plataforma centralizada será crucial para enfrentar os desafios atuais do gerenciamento de equipes virtuais. Ao oferecer uma solução abrangente e eficaz, o Task Unity tem o potencial de melhorar significativamente a eficiência, a colaboração e a qualidade dos projetos em um ambiente de trabalho freelance em constante evolução.

## 2. Participantes do processo

Os participantes do sistema serão constituidos por **contratantes** e **freelancers**. Sendo que os usuários do tipo contratante irão criar seus projetos e contratar com base em suas necessidades, já os freelancers terão como principal função oferecer suas habilidades e prestar seus serviços. Suas atividades estão descritas a seguir:

**Contratante**

    Cria projeto na plataforma
    Contrata freelancers
    Gerencia membros da equipe
    Interage com membros da equipe
    
**Freelancer**

    Publica seu serviço na plataforma
    Aceita ou recusa ofertas
    Após seu serviço ser contratado, interage com contratante e/ou membros da equipe

## 3. Modelagem do processo de negócio

### 3.1. Análise da situação atual

Atualmente, o serviço de freelancer acontece das seguintes maneiras:

- **Sites de contratação de freelancers**: nesses sites, o prestador de serviços(freelancer), entra e publica um anúncio de seus serviços ou produtos, para que assim um contratante possa pagar pelo próprio site e receber o que havia sido acordado, atualmente nenhum desses sites permite o gerenciamento de um projeto dentro de suas respectivas plataformas.
  
- **Marketplaces de Nicho**: Além dos grandes sites de contratação de freelancers, existem também marketplaces de nicho que se concentram em áreas específicas, como design gráfico, redação técnica, tradução, desenvolvimento de aplicativos e muito mais. Esses marketplaces podem oferecer uma experiência mais especializada para ambas as partes, mas a especialização em um nicho específico pode limitar as oportunidades de trabalho para os freelancers e também Comparados a grandes plataformas, os marketplaces de nicho podem ter menos tráfego e, consequentemente, menos visibilidade.
  
- **Anúncios nas redes sociais**: pode ocorrer de um freelancer publicar um anúncio nas redes sociais sobre o serviço que está prestando, para que assim algum contratante entre em contato com ele para que possam discutir valores, método de pagamento e até mesmo prazos de entrega, o grande problema com esse método do jeito que é hoje é a falta de credibilidade, a rede social não pode oferecer a integração com métodos de pagamento e um gerenciamento feito para o serviço de freelancers que uma aplicação feita para isso pode oferecer.


### 3.2. Descrição geral da proposta

A proposta do **Taskunity** consiste em facilitar a gerência de projetos feitos por freelancers, visto que busca eliminar a dificuldade na troca de informações que ocorre ao tentar criar um projeto com vários freelancers de áreas diferentes. O taskunity busca unificar todas as informações do projeto em um só lugar, facilitar a comunicação do contratante com os freelancers participantes, a gerência dos mesmos e até a contratação de novos freelancers. Com isso, o fluxo da aplicação seguirá as seguintes etapas:

**Contratante**:
- O usuário se cadastra, fornecendo dados básicos como nome, email, senha, cpf, telefone e data de nascimento.
- Após isso, cria o seu projeto na plataforma, contendo título, descrição do projeto, número de freelancers necessários e habilidades necessárias de cada freelancer.
- Ele poderá buscar por freelancers com as habilidades requisitadas e contratá-los caso queira.
- Também poderá aceitar solicitações de freelancers para participarem do projeto e contratá-los caso queira.
- Após formada a equipe, poderá se comunicar com todos os freelancers em um só lugar, contendo um chat geral do projeto e chats individuais entre cada participante.
- Poderá também gerir os membros da equipe, adicionando novos, excluindo atuais, mudando os cargos, etc.
- Ao finalizado o projeto, o contratante finaliza o projeto no sistema.

**Freelancer**:
- O usuário se cadastra, fornecendo dados básicos como nome, email, senha, cpf, telefone, data de nascimento, valor cobrado por seus serviços.
- Após isso, seu perfil será exibido na plataforma e poderá ser solicitado para participar de novos projetos.
- Ele poderá buscar por projetos estejam necessitando de suas habilidades e solicitar para participar destes projetos.
- Após isso, o usuário poderá interagir a partir do projeto criado pelo contratante e realizar suas tarefas.
- Ao finalizado o projeto, aguarde a finalização do contratante no sistema.

### 3.3. Modelagem dos processos

[PROCESSO 1 - Nome do Processo](processo-1-nome-do-processo.md "Detalhamento do Processo 1.")

[PROCESSO 2 - Nome do Processo](processo-2-nome-do-processo.md "Detalhamento do Processo 2.")

[PROCESSO 3 - Nome do Processo](processo-3-nome-do-processo.md "Detalhamento do Processo 3.")

[PROCESSO 4 - Nome do Processo](processo-4-nome-do-processo.md "Detalhamento do Processo 4.")

[PROCESSO 5 - Nome do Processo](processo-5-nome-do-processo.md "Detalhamento do Processo 5.")

[PROCESSO 6 - Nome do Processo](processo-6-nome-do-processo.md "Detalhamento do Processo 6.")

## 4. Projeto da solução

O documento a seguir apresenta o detalhamento do projeto da solução. São apresentadas cinco seções que descrevem, respectivamente: diagrama de classes, diagrama de componentes, diagrama de entidade-relacionamento, tecnologias utilizadas e guias de estilo.

[Projeto da solução](solution-design.md "Detalhamento do Projeto da solução: classes, componentes, der, tecnologias e guias de estilo.")


## 5. Indicadores de desempenho

O documento a seguir apresenta os indicadores de desempenho dos processos.

[Indicadores de desempenho dos processos](performance-indicators.md)


## 6. Interface do sistema

A sessão a seguir apresenta a descrição do produto de software desenvolvido. 

[Documentação da interface do sistema](interface.md)

## 7. Testes

A sessão a seguir apresenta a descrição dos testes de unidade e testes de usabilidade realizados. 

[Testes do sistema](tests.md)

## 8. Conclusão

_Apresente aqui a conclusão do seu trabalho. Discussão dos resultados obtidos no trabalho, onde se verifica as observações pessoais de cada aluno. Poderá também apresentar sugestões de novas linhas de estudo._

# REFERÊNCIAS

_Como um projeto de software não requer revisão bibliográfica, a inclusão das referências não é obrigatória. No entanto, caso você deseje incluir referências relacionadas às tecnologias, padrões, ou metodologias que serão usadas no seu trabalho, relacione-as de acordo com a ABNT._

_Verifique no link abaixo como devem ser as referências no padrão ABNT:_

http://www.pucminas.br/imagedb/documento/DOC\_DSC\_NOME\_ARQUI20160217102425.pdf


**[1.1]** - _ELMASRI, Ramez; NAVATHE, Sham. **Sistemas de banco de dados**. 7. ed. São Paulo: Pearson, c2019. E-book. ISBN 9788543025001._

**[1.2]** - _COPPIN, Ben. **Inteligência artificial**. Rio de Janeiro, RJ: LTC, c2010. E-book. ISBN 978-85-216-2936-8._

**[1.3]** - _CORMEN, Thomas H. et al. **Algoritmos: teoria e prática**. Rio de Janeiro, RJ: Elsevier, Campus, c2012. xvi, 926 p. ISBN 9788535236996._

**[1.4]** - _SUTHERLAND, Jeffrey Victor. **Scrum: a arte de fazer o dobro do trabalho na metade do tempo**. 2. ed. rev. São Paulo, SP: Leya, 2016. 236, [4] p. ISBN 9788544104514._

**[1.5]** - _RUSSELL, Stuart J.; NORVIG, Peter. **Inteligência artificial**. Rio de Janeiro: Elsevier, c2013. xxi, 988 p. ISBN 9788535237016._



# APÊNDICES


_Atualizar os links e adicionar novos links para que a estrutura do código esteja corretamente documentada._


## Apêndice A - Código fonte

[Código do front-end](../src/front) -- repositório do código do front-end

[Código do back-end](../src/back)  -- repositório do código do back-end


## Apêndice B - Apresentação final


[Slides da apresentação final](presentations/arquivo.pdf)


[Vídeo da apresentação final](video/arquivo.mp4)






