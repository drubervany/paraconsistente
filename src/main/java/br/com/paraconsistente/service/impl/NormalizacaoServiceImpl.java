package br.com.paraconsistente.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.model.Medicao;
import br.com.paraconsistente.model.Projeto;
import br.com.paraconsistente.service.MedicaoService;
import br.com.paraconsistente.service.NormalizacaoService;
import br.com.paraconsistente.service.ParaconsistenteService;

@Transactional
@Service("normalizacaoService")
public class NormalizacaoServiceImpl implements NormalizacaoService {

	@Autowired
	MedicaoService medicaoService;

	@Autowired
	ParaconsistenteService paraconsistenteService;

	@Override
	public void finalizar(final Projeto projeto) {

		atualizaCfpsPontoFuncao(projeto);

		/** Normalização: */
		final List<Medicao> medicoes = medicaoService.findByProjeto(projeto);
		final int min = medicoes.stream().mapToInt(m -> m.getTotalPonfoFuncao()).min().getAsInt();
		final int max = medicoes.stream().mapToInt(m -> m.getTotalPonfoFuncao()).max().getAsInt();

		// Normalizar
		projeto.getCfpss().forEach(cfps -> {
			final BigDecimal fator = new BigDecimal(cfps.getNumeroPontos() - min).divide(new BigDecimal(max - min), 2,
					RoundingMode.HALF_UP);
			cfps.setFavoravel(fator);
			cfps.setDesfavoravel(new BigDecimal(1 - fator.doubleValue()));
		});

		/** FORNEC (Max; Min) */
		// Máx Fornec Ef(μ)
		final double maxFornc = projeto.getCfpss().stream().mapToDouble(m -> m.getFavoravel().doubleValue()).min()
				.getAsDouble();

		// Mín Fornec Ed(λ)
		final double minFornc = projeto.getCfpss().stream().mapToDouble(m -> m.getDesfavoravel().doubleValue()).min()
				.getAsDouble();

		/** Resultante Cliente X Fornec */
		// Mín Ef(μ)
		double ef = 0;
		// Máx Ed(λ)
		double ed = 0;

		// Gce (μ-λ)
		BigDecimal gce = new BigDecimal(ef - ed);
		// Gco (μ+λ)-1
		BigDecimal gco = new BigDecimal(ef + ed).subtract(new BigDecimal(1));

		String resultante = paraconsistenteService.resultante(gce, gco);

	}

	private void atualizaCfpsPontoFuncao(final Projeto projeto) {
		final List<CFPS> listaCfps = new ArrayList<>();
		projeto.getCfpss().forEach(cfps -> {
			final List<Medicao> medicao = medicaoService.findByProjetoAndCfps(projeto, cfps);
			final int numeroPontos = medicao.stream().mapToInt(m -> m.getTotalPonfoFuncao()).sum();
			cfps.setNumeroPontos(numeroPontos);
			listaCfps.add(cfps);
		});
	}
}