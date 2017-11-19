--
-- Dados iniciais
--

-- =================================================================================================
-- Projetos
insert into CARGO(nome)values('Gerente')

insert into USUARIO(cpf, email, nome, senha, cargo_id)values('33937256881', 'teste@teste.com.br', 'Usuario Teste', '123456', 1)
insert into USUARIO(cpf, email, nome, senha, cargo_id)values('33937256881', 'drubervany@gmail.com', 'Danilo Rubervany Dias', 'da212324', 1)

insert into CLIENTE(cnpj, email, nome)values('45578205000197', 'drubervany@gmail.com', 'Danilo Rubervany Dias')
insert into GERENTE(cpf, email, nome)values('33937256881', 'drubervany@gmail.com', 'Danilo Rubervany Dias')
insert into CFPS(cpf, email, nome, numeroPontos)values('33937256881', 'drubervany@gmail.com', 'Danilo Rubervany Dias', 10)
insert into MEDICAO(arquivoReferenciado, aie, ali, ce, ee, se, tiposDado, tiposRegistro)values('arquivoReferenciado', 1, 2, 3, 4, 5, 'tiposDado', 'tiposRegistro')
insert into PROJETO(nome, descricao, pontosFuncao, cliente_id, gerente_id, mediacao_id)values('nome', 'descricao', 10, 1, 1, 1)
insert into PROJETO_CFPS(PROJETO_ID, CFPS_ID)values(1, 1)
