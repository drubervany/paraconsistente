--
-- Dados iniciais
--

insert into CARGO(nome)values('Gerente')
insert into CARGO(nome)values('CFPS')

insert into USUARIO(cpf, email, nome, senha, cargo_id)values('33937256881', 'teste@teste.com.br', 'Usuario Teste', '123456', 1)
insert into USUARIO(cpf, email, nome, senha, cargo_id)values('33937256881', 'cfps@teste.com.br', 'Usuario CFPS Teste', '123456', 2)

insert into CLIENTE(cnpj, email, nome)values('45578205000197', 'cliente@teste.com', 'Cliente Teste')

insert into GERENTE(cpf, email, nome)values('33937256881', 'gerente@teste.com', 'Gerente Teste')

insert into CFPS(cpf, email, nome, numeroPontos)values('33937256881', 'cfps1@teste.com', 'CFPS 1 teste', 10)
insert into CFPS(cpf, email, nome, numeroPontos)values('33937256881', 'cfps2@teste.com', 'CFPS 2 teste', 10)
insert into CFPS(cpf, email, nome, numeroPontos)values('33937256881', 'cfps3@teste.com', 'CFPS 3 teste', 10)
insert into CFPS(cpf, email, nome, numeroPontos)values('33937256881', 'cfps4@teste.com', 'CFPS 4 teste', 10)

insert into PROJETO(nome, descricao, pontosFuncao, cliente_id, gerente_id, status, cfps_id)values('nome', 'descricao', 0, 1, 1, 'CADASTRADO', 1)
insert into PROJETO_CFPS(PROJETO_ID, CFPSS_ID)values(1, 1)

insert into FUNCAO(nome)values('Funcao 1')
insert into MEDICAO(projeto_id, cfps_id, funcao_id, qtdeDados, qtdeRegistros, tipo, totalPonfoFuncao)values(1, 1, 1, 1, 1, 'ALI', 7)