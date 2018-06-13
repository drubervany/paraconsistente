# language: pt
  @GerenteProjetoTeste
  Funcionalidade: Testar o Gerente de Projeto
   
    Esquema do Cenario: Testar cadastro projeto
      Dado que exista o  gerente de projeto "<nome>", "<cpf>" e "<email>"
      E o gerente inicia o cadastro do projeto
	  | nome | descricao| dataInicio | dataFim |            
	  E o gerente contrata os especialistas
	  |1 | nome | cpf | email |
	  |2 | nome | cpf | email |
	  |3 | nome | cpf | email |
	  E os especialistas analisam o projeto
	  Entao os especialistas fazem a medicao
	  |1 | id | ali | aie | ce | ee | se | tiposDado | tiposRegistro | arquivoReferenciado | 
	  |2 | id | ali | aie | ce | ee | se | tiposDado | tiposRegistro | arquivoReferenciado |
	  |3 | id | ali | aie | ce | ee | se | tiposDado | tiposRegistro | arquivoReferenciado |
	  Entao o ponto de função levantando são:
      Entao o gerente de projeto faz a analise da medição e a tomada de decisao
   
     
   
	Exemplos: 
		| nome   |cpf 			| email				   |
		| Danilo | 339325684-54 | drubervany@gmail.com |