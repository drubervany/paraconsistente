package br.com.paraconsistente.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.paraconsistente.model.Gerente;
import br.com.paraconsistente.service.GerenteService;
import br.com.paraconsistente.util.CustomErrorType;

@Controller
@RestController
@RequestMapping("/api/gerentes/")
public class RestApiGerenteController {

	public static Logger logger = LoggerFactory.getLogger(RestApiGerenteController.class);

	@Autowired
	GerenteService gerenteService;


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Gerente>> listAllGerentes() {
		List<Gerente> gerentes = gerenteService.findAllGerentes();
		if (gerentes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Gerente>>(gerentes, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getGerente(@PathVariable("id") long id) {
		logger.info("Fetching Gerente with id {}", id);
		Gerente gerente = gerenteService.findById(id);
		if (gerente == null) {
			logger.error("Gerente with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Gerente with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createGerente(@RequestBody Gerente gerente, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Gerente : {}", gerente);

		if (gerenteService.isGerenteExist(gerente)) {
			logger.error("Unable to create. A Gerente with name {} already exist", gerente.getNome());
			return new ResponseEntity<>(
					new CustomErrorType(
							"Unable to create. A Gerente with name " + gerente.getNome() + " already exist."),
					HttpStatus.CONFLICT);
		}
		gerenteService.saveGerente(gerente);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/gerentes/{id}").buildAndExpand(gerente.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateGerente(@PathVariable("id") long id, @RequestBody Gerente gerente) {
		logger.info("Updating Gerente with id {}", id);

		Gerente currentGerente = gerenteService.findById(id);

		if (currentGerente == null) {
			logger.error("Unable to update. Gerente with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Unable to upate. Gerente with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentGerente.setNome(gerente.getNome());

		gerenteService.updateGerente(currentGerente);
		return new ResponseEntity<Gerente>(currentGerente, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteGerente(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Gerente with id {}", id);

		Gerente gerente = gerenteService.findById(id);
		if (gerente == null) {
			logger.error("Unable to delete. Gerente with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Unable to delete. Gerente with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		gerenteService.deleteGerenteById(id);
		return new ResponseEntity<Gerente>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Gerente> deleteAllGerentes() {
		logger.info("Deleting All Gerentes");

		gerenteService.deleteAllGerentes();
		return new ResponseEntity<Gerente>(HttpStatus.NO_CONTENT);
	}
}