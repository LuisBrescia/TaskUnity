# Artefatos relativos à modelagem de dados do projeto

Este diretório mantém os artefatos relativos à modelagem de dados do projeto. 

Os principais documentos a serem produzidos são:


* [`DiagramaEntidadeRelacionamento`](DiagramaEntidadeRelacionamento.png)
	* Apresentar o DER em arquivo editável no formato compatível com a ferramenta utilizada pela equipe.

* [`database_creation_script.sql`](database_creation_script.sql)
	* Script de criação do banco de dados.

* [`database_data_initialization_script.sql`](database_data_initialization_script.sql)
	* Script de inicialização (povoamento) do banco de dados.

<br/>
<br/>

# Acesso ao Banco de Dados (PostgreSQL)
 
#### Internal Database URL:
	postgres://db_taskunity_user:he6DDDqRBtD4EpVrISSVDEW1oFtmiL9m@dpg-ckl8rc3j89us73d4t70g-a/db_taskunity

#### External Database URL:
	postgres://db_taskunity_user:he6DDDqRBtD4EpVrISSVDEW1oFtmiL9m@dpg-ckl8rc3j89us73d4t70g-a.oregon-postgres.render.com/db_taskunity

#### PSQL Command
	PGPASSWORD=he6DDDqRBtD4EpVrISSVDEW1oFtmiL9m psql -h dpg-ckl8rc3j89us73d4t70g-a.oregon-postgres.render.com -U db_taskunity_user db_taskunity

 > BD criado no render https://render.com/docs/databases
