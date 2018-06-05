package br.com.paraconsistente.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import br.com.paraconsistente.enuns.StatusProjetoEnum;
import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.model.Medicao;
import br.com.paraconsistente.model.Projeto;
import br.com.paraconsistente.service.MedicaoService;
import br.com.paraconsistente.service.ProjetoService;
import br.com.paraconsistente.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiProjetoController {

	public static Logger logger = LoggerFactory.getLogger(RestApiProjetoController.class);

	@Autowired
	ProjetoService projetoService;

	@Autowired
	MedicaoService medicaoService;

	@RequestMapping(value = "/projetos/", method = RequestMethod.GET)
	public ResponseEntity<List<Projeto>> listAllProjetos() {
		List<Projeto> projetos = projetoService.findAllProjetos();
		if (projetos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		projetos.forEach(projeto -> {
			atualizaCfpsPontoFuncao(projeto);
		});

		return new ResponseEntity<List<Projeto>>(projetos, HttpStatus.OK);
	}

	@RequestMapping(value = "/projetos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProjeto(@PathVariable("id") long id) {
		logger.info("Fetching Projeto with id {}", id);
		Projeto projeto = projetoService.findById(id);
		atualizaCfpsPontoFuncao(projeto);
		if (projeto == null) {
			logger.error("Projeto with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Projeto with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Projeto>(projeto, HttpStatus.OK);
	}

	@RequestMapping(value = "/projetos/", method = RequestMethod.POST)
	public ResponseEntity<?> createProjeto(@RequestBody Projeto projeto, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Projeto : {}", projeto);

		projetoService.saveProjeto(projeto);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/projetos/{id}").buildAndExpand(projeto.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/projetos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProjeto(@PathVariable("id") long id, @RequestBody Projeto projeto) {
		logger.info("Updating Projeto with id {}", id);

		Projeto currentProjeto = projetoService.findById(id);

		if (currentProjeto == null) {
			logger.error("Unable to update. Projeto with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Unable to upate. Projeto with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentProjeto.setNome(projeto.getNome());
		currentProjeto.setCfps(projeto.getCfps());
		currentProjeto.setStatus(projeto.getStatus());
		currentProjeto.setPontosFuncao(projeto.getPontosFuncao());

		projetoService.updateProjeto(currentProjeto);
		return new ResponseEntity<Projeto>(currentProjeto, HttpStatus.OK);
	}

	@RequestMapping(value = "/projetos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProjeto(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Projeto with id {}", id);

		Projeto projeto = projetoService.findById(id);
		if (projeto == null) {
			logger.error("Unable to delete. Projeto with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Unable to delete. Projeto with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		projetoService.deleteProjetoById(id);
		return new ResponseEntity<Projeto>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/projetos/", method = RequestMethod.DELETE)
	public ResponseEntity<Projeto> deleteAllProjetos() {
		logger.info("Deleting All Projetos");

		projetoService.deleteAllProjetos();
		return new ResponseEntity<Projeto>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/projetos/status", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, String>>> retornarTodosStatus() {
		logger.info("retornarTodosStatus All Projetos");

		List<Map<String, String>> lista = new ArrayList<>();
		for (StatusProjetoEnum enumeration : StatusProjetoEnum.values()) {
			Map<String, String> mapa = new HashMap<>();
			mapa.put("id", enumeration.name());
			mapa.put("descricao", enumeration.name());
			lista.add(mapa);
		}

		return new ResponseEntity<List<Map<String, String>>>(lista, HttpStatus.OK);
	}

	@RequestMapping(value = "/projetos/status/{status}", method = RequestMethod.GET)
	public ResponseEntity<List<Projeto>> retornarProjetoStatus(@PathVariable("status") String status) {
		logger.info("retornarProjetoStatus All Projetos");

		List<Projeto> projetos = projetoService.findByStatus(StatusProjetoEnum.valueOf(status));
		if (projetos.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		projetos.forEach(projeto -> {
			atualizaCfpsPontoFuncao(projeto);
		});

		return new ResponseEntity<List<Projeto>>(projetos, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/projetos/ia/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> calcularIA(@PathVariable("id") long id) {
		logger.info("Fetching Projeto with id {}", id);
		Projeto projeto = projetoService.findById(id);
		atualizaCfpsPontoFuncao(projeto);
		if (projeto == null) {
			logger.error("Projeto with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Projeto with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		
		Projeto calcularIA = projetoService.calcularIA(projeto);
		
		return new ResponseEntity<Projeto>(calcularIA, HttpStatus.OK);
	}

	private void atualizaCfpsPontoFuncao(Projeto projeto) {
		List<CFPS> listaCfps = new ArrayList<>();
		projeto.getCfpss().forEach(cfps -> {
			List<Medicao> medicao = medicaoService.findByProjetoAndCfps(projeto, cfps);
			int numeroPontos = medicao.stream().mapToInt(m -> m.getTotalPonfoFuncao()).sum();
			cfps.setNumeroPontos(numeroPontos);
			listaCfps.add(cfps);
		});
	}
}