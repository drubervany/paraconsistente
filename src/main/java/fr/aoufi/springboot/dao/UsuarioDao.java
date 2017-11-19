package fr.aoufi.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.aoufi.springboot.model.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	Usuario findByNome(String nome);

	Usuario findByEmailAndSenha(String email, String senha);

}