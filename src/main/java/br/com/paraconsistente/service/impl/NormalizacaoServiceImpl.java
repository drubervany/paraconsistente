package br.com.paraconsistente.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paraconsistente.enuns.TipoContadorEnum;
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
	public Projeto normalizar(final Projeto projeto) {

		atualizaCfpsPontoFuncao(projeto);

		/** Normalização: */
		final List<Medicao> medicoes = medicaoService.findByProjeto(projeto);
		final int min = medicoes.stream().mapToInt(m -> m.getTotalPonfoFuncao()).min().getAsInt();
		final int max = medicoes.stream().mapToInt(m -> m.getTotalPonfoFuncao()).max().getAsInt();

		// Normalizar
		projeto.getCfpss().forEach(cfps -> {
			BigDecimal divisor = new BigDecimal(max - min);
			BigDecimal fator = BigDecimal.ZERO;
			if (divisor.doubleValue() != BigDecimal.ZERO.doubleValue())
				fator = new BigDecimal(cfps.getNumeroPontos() - min).divide(divisor, 2, RoundingMode.HALF_UP);

			cfps.setFavoravel(fator);
			cfps.setDesfavoravel(new BigDecimal(1 - fator.doubleValue()));
		});

		/*** FORNEC (MaxEf(μ); MinEd(λ)) ***/
		// Máx Fornec Ef(μ)
		final OptionalDouble minFornecedorFavoravel = projeto.getCfpss().stream()
				.filter(c -> TipoContadorEnum.FORNECEDOR.equals(c.getContador()))
				.mapToDouble(m -> m.getFavoravel().doubleValue()).min();

		// Mín Fornec Ed(λ)
		final OptionalDouble maxFornecedorDesfavoravel = projeto.getCfpss().stream()
				.filter(c -> TipoContadorEnum.FORNECEDOR.equals(c.getContador()))
				.mapToDouble(m -> m.getDesfavoravel().doubleValue()).max();

		/** Cliente **/
		// Mín Fornec Ed(λ)
		final OptionalDouble minClienteFavoravel = projeto.getCfpss().stream()
				.filter(c -> TipoContadorEnum.CLIENTE.equals(c.getContador()))
				.mapToDouble(m -> m.getFavoravel().doubleValue()).min();

		// Mín Fornec Ed(λ)
		final OptionalDouble maxClienteDesfavoravel = projeto.getCfpss().stream()
				.filter(c -> TipoContadorEnum.CLIENTE.equals(c.getContador()))
				.mapToDouble(m -> m.getDesfavoravel().doubleValue()).max();

		/** Resultante Cliente X Fornec */
		// Mín Ef(μ)
		double minEf = 0;
		if (minFornecedorFavoravel.isPresent())
			minEf = minFornecedorFavoravel.getAsDouble() < minClienteFavoravel.getAsDouble()
					? minFornecedorFavoravel.getAsDouble()
					: minClienteFavoravel.getAsDouble();
		else
			minEf = minClienteFavoravel.getAsDouble();
		// Máx Ed(λ)
		double maxEd = 0;
		if (maxFornecedorDesfavoravel.isPresent())
			maxEd = maxFornecedorDesfavoravel.getAsDouble() > maxClienteDesfavoravel.getAsDouble()
					? maxFornecedorDesfavoravel.getAsDouble()
					: maxClienteDesfavoravel.getAsDouble();
		else
			maxEd = maxClienteDesfavoravel.getAsDouble();

		// Gce (μ-λ)
		final double gce = retornaGCE(minEf, maxEd);
		projeto.setGce(gce);
		// Gco (μ+λ)-1
		final double gco = retornaGCO(minEf, maxEd);
		projeto.setGco(gco);

		projeto.setResultante(paraconsistenteService.resultante(new BigDecimal(gce), new BigDecimal(gco)));

		return projeto;
	}

	private double retornaGCO(final double minEf, final double MaxEd) {
		double gco = 0;
		if (minEf == 0)
			if (MaxEd == 0)
				gco = 0;
			else
				gco = (0 + MaxEd) - 1;
		else if (MaxEd == 0)
			gco = (0 + minEf) - 1;
		else
			gco = (minEf + MaxEd) - 1;
		return gco;
	}

	private double retornaGCE(final double minEf, final double MaxEd) {
		double gce = 0;
		if (minEf == 0)
			if (MaxEd == 0)
				gce = 0;
			else
				gce = 0 - MaxEd;
		else if (MaxEd == 0)
			gce = 0 - minEf;
		else
			gce = minEf - MaxEd;
		return gce;
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