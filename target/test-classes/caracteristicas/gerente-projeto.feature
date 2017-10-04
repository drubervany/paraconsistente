# language: pt
  @GerenteProjetoTeste
  Funcionalidade: Testar o Gerente de Projeto
   
    Esquema do Cenario: Testar cadastro projeto
      Dado que exista o  gerente de projeto "<nome>", "<cpf>" e "<email>"
      E o gerente inicia o cadastro do projeto
	  | nome | descricao| dataInicio | dataFim |            
      Quando realizar o cadastro do projeto      
      Entao faz a tomada de decisao
   
	Exemplos: 
		| nome   |cpf 			| email				   |
		| Danilo | 339325684-54 | drubervany@gmail.com |