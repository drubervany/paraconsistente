package br.com.paraconsistente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.model.Projeto;

@Repository
public interface ProjetoDao extends JpaRepository<Projeto, Long> {

	Projeto findByNome(String nome);

}