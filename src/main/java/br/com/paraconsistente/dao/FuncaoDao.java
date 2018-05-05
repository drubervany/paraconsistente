package br.com.paraconsistente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.model.Funcao;

@Repository
public interface FuncaoDao extends JpaRepository<Funcao, Long> {

	Funcao findByNome(String tipoFuncao);

}