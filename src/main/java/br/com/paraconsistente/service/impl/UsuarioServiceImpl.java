package br.com.paraconsistente.service.impl;

import java.util.List;

import br.com.paraconsistente.dao.UsuarioDao;
import br.com.paraconsistente.model.Usuario;
import br.com.paraconsistente.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	public Usuario findById(Long id) {
		return usuarioDao.findOne(id);
	}

	public Usuario findByName(String name) {
		return usuarioDao.findByNome(name);
	}

	public void saveUsuario(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	public void updateUsuario(Usuario usuario) {
		saveUsuario(usuario);
	}

	public void deleteUsuarioById(Long id) {
		usuarioDao.delete(id);
	}

	public void deleteAllUsuarios() {
		usuarioDao.deleteAll();
	}

	public List<Usuario> findAllUsuarios() {
		return usuarioDao.findAll();
	}

	public boolean isUsuarioExist(Usuario usuario) {
		return findByName(usuario.getNome()) != null;
	}

	@Override
	public Usuario findByEmailAndSenha(String email, String senha) {
		return usuarioDao.findByEmailAndSenha(email, senha);
	}

}