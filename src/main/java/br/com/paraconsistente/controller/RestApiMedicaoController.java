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

import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.model.Medicao;
import br.com.paraconsistente.service.CFPSService;
import br.com.paraconsistente.service.MedicaoService;
import br.com.paraconsistente.util.CustomErrorType;

@Controller
@RestController
@RequestMapping("/api/medicoes/")
public class RestApiMedicaoController {

	public static Logger logger = LoggerFactory.getLogger(RestApiMedicaoController.class);

	@Autowired
	MedicaoService medicaoService;

	@Autowired
	CFPSService cfpsService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Medicao>> listAllMedicaos() {
		List<Medicao> medicao = medicaoService.findAll();
		if (medicao.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Medicao>>(medicao, HttpStatus.OK);
	}

	@RequestMapping(value = "cfps/{id}/total", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<CFPS> totalMedicao(@PathVariable("id") long id) {

		CFPS cfps = cfpsService.findById(id);
		if (cfps == null) {
			logger.error("CFPS with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Medicao with CFPS id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		List<Medicao> medicao = medicaoService.findByCfps(cfps);

		int numeroPontos = medicao.stream().filter(c -> c.getCfps().getId().longValue() == id)
				.mapToInt(m -> m.getTotalPonfoFuncao()).sum();

		cfps.setNumeroPontos(numeroPontos);

		return new ResponseEntity<CFPS>(cfps, HttpStatus.OK);
	}

	@RequestMapping(value = "cfps/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCFPS(@PathVariable("id") long id) {
		logger.info("Fetching CFPS with id {}", id);
		
		CFPS cfps = cfpsService.findById(id);
		if (cfps == null) {
			logger.error("CFPS with id {} not found.", id);
			return new ResponseEntity<Object>(new CustomErrorType("Medicao with CFPS id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		List<Medicao> medicao = medicaoService.findByCfps(cfps);
		return new ResponseEntity<List<Medicao>>(medicao, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getMedicao(@PathVariable("id") long id) {
		logger.info("Fetching CFPS with id {}", id);
		Medicao medicao = medicaoService.findById(id);
		if (medicao == null) {
			logger.error("CFPS with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Medicao with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Medicao>(medicao, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createMedicao(@RequestBody Medicao medicao, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Medicao : {}", medicao);

		if (medicaoService.isExist(medicao)) {
			logger.error("Unable to create. A Medicao with name {} already exist", medicao.getTipo());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A Medicao with name " + medicao.getTipo() + " already exist."),
					HttpStatus.CONFLICT);
		}
		medicaoService.save(medicao);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/medicoes/{id}").buildAndExpand(medicao.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateMedicao(@PathVariable("id") long id, @RequestBody Medicao medicao) {
		logger.info("Updating Medicao with id {}", id);

		Medicao currentMedicao = medicaoService.findById(id);

		if (currentMedicao == null) {
			logger.error("Unable to update. Medicao with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Medicao with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentMedicao.setTipo(medicao.getTipo());

		medicaoService.update(currentMedicao);
		return new ResponseEntity<Medicao>(currentMedicao, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMedicao(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Medicao with id {}", id);

		Medicao medicao = medicaoService.findById(id);
		if (medicao == null) {
			logger.error("Unable to delete. Medicao with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Medicao with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		medicaoService.delete(id);
		return new ResponseEntity<Medicao>(HttpStatus.NO_CONTENT);
	}

}