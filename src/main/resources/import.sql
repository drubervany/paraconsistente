--
-- Dados iniciais

--
insert into GERENTE(cpf, email, nome)values('33937256881', 'gerente@teste.com', 'Gerente Teste')

insert into CLIENTE(cnpj, email, nome)values('45578205000197', 'cliente@teste.com', 'Cliente Teste')

insert into CFPS(cpf, cnpj, email, nome, numeroPontos, contador)values('33937256881', '45578205000197', 'cliente@teste.com', 'Cliente teste', 10, 'CLIENTE')
insert into CFPS(cpf, email, nome, numeroPontos, contador)values('33937256882', 'cfps2@teste.com', 'CFPS 2 teste', 10, 'FORNECEDOR')
insert into CFPS(cpf, email, nome, numeroPontos, contador)values('33937256883', 'cfps3@teste.com', 'CFPS 3 teste', 10, 'FORNECEDOR')
insert into CFPS(cpf, email, nome, numeroPontos, contador)values('33937256884', 'cfps4@teste.com', 'CFPS 4 teste', 10, 'FORNECEDOR')

insert into USUARIO(cpf, email, nome, senha, cargo, GERENTE_id, CFPS_ID)values('33937256881', 'teste@teste.com.br', 'Usuario GERENTE Teste', '123456', 'GERENTE', 1, 1)
insert into USUARIO(cpf, email, nome, senha, cargo)values('33937256881', 'cfps@teste.com.br', 'Usuario CFPS Teste', '123456', 'CFPS')

insert into PROJETO(nome, descricao, pontosFuncao, cliente_id, gerente_id, status, cfps_id, gce, gco)values('nome', 'descricao', 0, 1, 1, 'PENDENTE', 1, 0, 0)
insert into PROJETO_CFPS(PROJETO_ID, CFPSS_ID)values(1, 1)

insert into FUNCAO(nome, projeto_id, cfps_id)values('Funcao 1', 1, 1)
insert into MEDICAO(projeto_id, cfps_id, funcao_id, qtdeDados, qtdeRegistros, tipo, totalPonfoFuncao)values(1, 1, 1, 1, 1, 'ALI', 7)