package br.com.paraconsistente.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.enuns.StatusProjetoEnum;
import br.com.paraconsistente.model.Projeto;

@Repository
public interface ProjetoDao extends JpaRepository<Projeto, Long> {

	Projeto findByNome(String nome);

	List<Projeto> findByStatus(StatusProjetoEnum status);

}