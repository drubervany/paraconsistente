package fr.aoufi.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.aoufi.springboot.model.Projeto;

@Repository
public interface ProjetoDao extends JpaRepository<Projeto, Long> {

	Projeto findByNome(String nome);

}