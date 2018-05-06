package br.com.paraconsistente.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.paraconsistente.model.Usuario;
import br.com.paraconsistente.service.UsuarioService;
import br.com.paraconsistente.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiUsuarioController {

	public static Logger logger = LoggerFactory.getLogger(RestApiUsuarioController.class);

	@Autowired
	UsuarioService usuarioService;

	// -------------------Retrieve All
	// Usuarios---------------------------------------------

	@RequestMapping(value = "/usuarios/", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listAllUsuarios() {
		List<Usuario> usuarios = usuarioService.findAllUsuarios();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Usuario------------------------------------------

	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUsuario(@PathVariable("id") long id) {
		logger.info("Fetching Usuario with id {}", id);
		Usuario usuario = usuarioService.findById(id);
		if (usuario == null) {
			logger.error("Usuario with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Usuario with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "/usuarios/{email}/{senha}", method = RequestMethod.GET)
	public ResponseEntity<?> getUsuario(@PathVariable("email") String email, @PathVariable("senha") String senha) {

		logger.info("Fetching Usuario with id {} e {}", email, senha);
		Usuario usuario = usuarioService.findByEmailAndSenha(email, senha);
		if (usuario == null) {
			logger.error("Usuario with id {} not found.", email);
			return new ResponseEntity<>(new CustomErrorType("Usuario with id " + email + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	// -------------------Create a
	// Usuario-------------------------------------------

	@RequestMapping(value = "/usuarios/", method = RequestMethod.POST)
	public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Usuario : {}", usuario);

		if (usuarioService.isUsuarioExist(usuario)) {
			logger.error("Unable to create. A Usuario with name {} already exist", usuario.getNome());
			return new ResponseEntity<>(
					new CustomErrorType(
							"Unable to create. A Usuario with name " + usuario.getNome() + " already exist."),
					HttpStatus.CONFLICT);
		}
		usuarioService.saveUsuario(usuario);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/usuario/{id}").buildAndExpand(usuario.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Usuario
	// ------------------------------------------------

	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario) {
		logger.info("Updating Usuario with id {}", id);

		Usuario currentUsuario = usuarioService.findById(id);

		if (currentUsuario == null) {
			logger.error("Unable to update. Usuario with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Unable to upate. Usuario with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUsuario.setNome(usuario.getNome());

		usuarioService.updateUsuario(currentUsuario);
		return new ResponseEntity<Usuario>(currentUsuario, HttpStatus.OK);
	}

	// ------------------- Delete a
	// Usuario-----------------------------------------

	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUsuario(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Usuario with id {}", id);

		Usuario usuario = usuarioService.findById(id);
		if (usuario == null) {
			logger.error("Unable to delete. Usuario with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Unable to delete. Usuario with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		usuarioService.deleteUsuarioById(id);
		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Usuarios-----------------------------

	@RequestMapping(value = "/usuarios/", method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> deleteAllUsuarios() {
		logger.info("Deleting All Usuarios");

		usuarioService.deleteAllUsuarios();
		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}

}