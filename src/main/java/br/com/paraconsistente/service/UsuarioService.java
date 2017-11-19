package br.com.paraconsistente.service;


import java.util.List;

import br.com.paraconsistente.model.Usuario;

public interface UsuarioService {
	
	Usuario findById(Long id);

	Usuario findByName(String name);

	void saveUsuario(Usuario usuario);

	void updateUsuario(Usuario usuario);

	void deleteUsuarioById(Long id);

	void deleteAllUsuarios();

	List<Usuario> findAllUsuarios();

	boolean isUsuarioExist(Usuario Usuario);

	Usuario findByEmailAndSenha(String email, String senha);
}