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

import br.com.paraconsistente.model.Projeto;
import br.com.paraconsistente.service.ProjetoService;
import br.com.paraconsistente.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiProjetoController {

	public static Logger logger = LoggerFactory.getLogger(RestApiProjetoController.class);

	@Autowired
	ProjetoService projetoService;

	// -------------------Retrieve All
	// Projetos---------------------------------------------

	@RequestMapping(value = "/projetos/", method = RequestMethod.GET)
	public ResponseEntity<List<Projeto>> listAllProjetos() {
		List<Projeto> projetos = projetoService.findAllProjetos();
		if (projetos.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Projeto>>(projetos, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Projeto------------------------------------------

	@RequestMapping(value = "/projetos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProjeto(@PathVariable("id") long id) {
		logger.info("Fetching Projeto with id {}", id);
		Projeto projeto = projetoService.findById(id);
		if (projeto == null) {
			logger.error("Projeto with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Projeto with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Projeto>(projeto, HttpStatus.OK);
	}

	// -------------------Create a
	// Projeto-------------------------------------------

	@RequestMapping(value = "/projetos/", method = RequestMethod.POST)
	public ResponseEntity<?> createProjeto(@RequestBody Projeto projeto, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Projeto : {}", projeto);

		if (projetoService.isProjetoExist(projeto)) {
			logger.error("Unable to create. A Projeto with name {} already exist", projeto.getNome());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A Projeto with name " + projeto.getNome() + " already exist."),
					HttpStatus.CONFLICT);
		}
		projetoService.saveProjeto(projeto);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/projetos/{id}").buildAndExpand(projeto.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Projeto
	// ------------------------------------------------

	@RequestMapping(value = "/projetos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProjeto(@PathVariable("id") long id, @RequestBody Projeto projeto) {
		logger.info("Updating Projeto with id {}", id);

		Projeto currentProjeto = projetoService.findById(id);

		if (currentProjeto == null) {
			logger.error("Unable to update. Projeto with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Projeto with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentProjeto.setNome(projeto.getNome());
		currentProjeto.setCfps(currentProjeto.getCfps());
		currentProjeto.setPontosFuncao(projeto.getPontosFuncao());

		projetoService.updateProjeto(currentProjeto);
		return new ResponseEntity<Projeto>(currentProjeto, HttpStatus.OK);
	}

	// ------------------- Delete a
	// Projeto-----------------------------------------

	@RequestMapping(value = "/projetos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProjeto(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Projeto with id {}", id);

		Projeto projeto = projetoService.findById(id);
		if (projeto == null) {
			logger.error("Unable to delete. Projeto with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Projeto with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		projetoService.deleteProjetoById(id);
		return new ResponseEntity<Projeto>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Projetos-----------------------------

	@RequestMapping(value = "/projetos/", method = RequestMethod.DELETE)
	public ResponseEntity<Projeto> deleteAllProjetos() {
		logger.info("Deleting All Projetos");

		projetoService.deleteAllProjetos();
		return new ResponseEntity<Projeto>(HttpStatus.NO_CONTENT);
	}

}