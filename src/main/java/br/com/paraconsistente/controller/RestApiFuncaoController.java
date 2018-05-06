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

import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.model.Funcao;
import br.com.paraconsistente.model.Projeto;
import br.com.paraconsistente.service.CFPSService;
import br.com.paraconsistente.service.FuncaoService;
import br.com.paraconsistente.service.ProjetoService;
import br.com.paraconsistente.util.CustomErrorType;

@RestController
@RequestMapping("/api/")
public class RestApiFuncaoController {

	public static Logger logger = LoggerFactory.getLogger(RestApiFuncaoController.class);

	@Autowired
	FuncaoService funcaoService;

	@Autowired
	ProjetoService projetoService;
	
	@Autowired
	CFPSService cfpsService;
	
	@RequestMapping(value = "funcoes/", method = RequestMethod.GET)
	public ResponseEntity<List<Funcao>> listAllFuncaos() {
		List<Funcao> funcao = funcaoService.findAll();
		if (funcao.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Funcao>>(funcao, HttpStatus.OK);
	}

	@RequestMapping(value = "funcoes/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCFPS(@PathVariable("id") long id) {
		logger.info("Fetching CFPS with id {}", id);
		Funcao funcao = funcaoService.findById(id);
		if (funcao == null) {
			logger.error("CFPS with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Funcao with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Funcao>(funcao, HttpStatus.OK);
	}

	@RequestMapping(value = "projetos/{idProjeto}/cfps/{idCfps}/funcoes", method = RequestMethod.GET)
	public ResponseEntity<?> getProjetoCFPS(@PathVariable("idProjeto") long idProjeto, @PathVariable("idCfps") long idCfps) {
		logger.info("Fetching getProjetoCFPS with id {}", idProjeto);
		
		Projeto projeto = projetoService.findById(idProjeto);
		if (projeto == null) {
			logger.error("Projeto with id {} not found.", idProjeto);
			return new ResponseEntity<>(new CustomErrorType("Projeto with id " + idProjeto + " not found"),
					HttpStatus.NOT_FOUND);
		}
		
		CFPS cfps = cfpsService.findById(idCfps);
		if (cfps == null) {
			logger.error("CFPS with id {} not found.", idCfps);
			return new ResponseEntity<>(new CustomErrorType("CFPS with id " + idCfps + " not found"),
					HttpStatus.NOT_FOUND);
		}
		
		List<Funcao> funcoes = funcaoService.findByProjetoAndCfps(projeto, cfps);
		if (funcoes == null) {
			logger.error("Funcao not found.");
			return new ResponseEntity<>(new CustomErrorType("Funcao not found"),
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Funcao>>(funcoes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "funcoes/", method = RequestMethod.POST)
	public ResponseEntity<?> createFuncao(@RequestBody Funcao funcao, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Funcao : {}", funcao);

		funcaoService.save(funcao);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/funcoes/{id}").buildAndExpand(funcao.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "funcoes/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateFuncao(@PathVariable("id") long id, @RequestBody Funcao funcao) {
		logger.info("Updating Funcao with id {}", id);

		Funcao currentFuncao = funcaoService.findById(id);

		if (currentFuncao == null) {
			logger.error("Unable to update. Funcao with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Unable to upate. Funcao with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentFuncao.setNome(funcao.getNome());

		funcaoService.update(currentFuncao);
		return new ResponseEntity<Funcao>(currentFuncao, HttpStatus.OK);
	}

	@RequestMapping(value = "funcoes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteFuncao(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Funcao with id {}", id);

		Funcao funcao = funcaoService.findById(id);
		if (funcao == null) {
			logger.error("Unable to delete. Funcao with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Unable to delete. Funcao with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		funcaoService.delete(id);
		return new ResponseEntity<Funcao>(HttpStatus.NO_CONTENT);
	}

}