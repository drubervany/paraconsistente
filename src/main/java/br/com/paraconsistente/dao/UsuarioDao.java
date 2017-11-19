package br.com.paraconsistente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.model.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	Usuario findByNome(String nome);

	Usuario findByEmailAndSenha(String email, String senha);

}