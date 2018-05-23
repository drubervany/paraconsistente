package br.com.paraconsistente.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paraconsistente.service.MedicaoService;
import br.com.paraconsistente.service.ParaconsistenteService;

@Transactional
@Service("paraconsistenteService")
public class ParaconsistenteServiceImpl implements ParaconsistenteService {

	@Autowired
	MedicaoService medicaoService;

	@Override
	public String resultante(final BigDecimal B71, final BigDecimal B72) {

		final String A82 = "NA";

		final BigDecimal J20 = new BigDecimal("1");
		final BigDecimal J21 = new BigDecimal("0.5").negate();

		final BigDecimal D20 = new BigDecimal("0.5").negate();
		final BigDecimal D21 = new BigDecimal("1");

		final String AH83 = "T";
		final String AH84 = "┴";
		final String AH85 = "V";
		final String AH86 = "F";

		final String AH90 = "Qua-V-tend-T";
		final String AH91 = "T-tend-V";

		final String AH96 = "Qua-V-tend-┴";
		final String AH97 = "┴-tend-V";

		final String AH102 = "Qua-F-tend-┴";
		final String AH103 = "┴-tend-F";

		final String AH107 = "Qua-F-tend-T";
		final String AH108 = "T-tend-F";

		// Gco>=ILV
		final String B83 = resultado(B72.doubleValue() >= J20.doubleValue(), AH83, A82);
		System.out.println(B83);

		// Gco<=ULV
		final String B84 = resultado(B72.doubleValue() <= D20.doubleValue(), AH84, A82);
		System.out.println(B84);

		// Gce>=TLV
		final String B85 = resultado(B71.doubleValue() >= D21.doubleValue(), AH85, A82);
		System.out.println(B85);

		// Gce<=FLV
		final String B86 = resultado(B71.doubleValue() <= J21.doubleValue(), AH86, A82);
		System.out.println(B86);

		// 0 =< Gce < TLV
		final Integer B87 = Integer.valueOf(
				resultado(B71.doubleValue() >= 0, resultado(B71.doubleValue() < D21.doubleValue(), "1", "0"), "0"));
		System.out.println(B87);

		// 0 =< Gco < ILV
		final Integer B88 = Integer.valueOf(
				resultado(B72.doubleValue() >= 0, resultado(B72.doubleValue() < J20.doubleValue(), "1", "0"), "0"));
		System.out.println(B88);

		// 01,10 ou 11
		final String B89 = resultado(B87 == 0, A82, resultado(B88 == 0, A82, "11"));
		System.out.println(B89);

		// Gce>=Gco
		final String B90 = resultado(B89 == "11",
				resultado(B72.doubleValue() >= B71.doubleValue(), AH90,
						resultado(B89 == "11", resultado(B72.doubleValue() <= B71.doubleValue(), AH91, A82), A82)),
				A82);
		System.out.println(B90);

		// Gce<=Gco
		final String B91 = resultado(B89 == "11", resultado(B72.doubleValue() <= B71.doubleValue(), AH91, A82), A82);
		System.out.println(B91);

		// 0 =< Gce < TLV
		final Integer B92 = Integer.valueOf(
				resultado(B71.doubleValue() >= 0, resultado(B71.doubleValue() < D21.doubleValue(), "1", "0"), "0"));
		System.out.println(B92);

		// ULV =< Gco < 0
		final Integer B93 = Integer.valueOf(
				resultado(B71.doubleValue() >= D20.doubleValue(), resultado(B71.doubleValue() < 0, "1", "0"), "0"));
		System.out.println(B93);

		// 01,10 ou 11
		final String B94 = resultado(B92 == 0, A82, resultado(B93 == 0, A82, "11"));
		System.out.println(B94);

		// |Gco|
		final BigDecimal B95 = B72.negate();
		System.out.println(B95);

		// Gce>=|Gco|
		final String B96 = resultado(B94 == "0", resultado(B72.doubleValue() >= B95.doubleValue(), A82, "11"), A82);
		System.out.println(B96);

		// Gce<|Gco|
		final String B97 = resultado(B94 == "11", resultado(B72.doubleValue() < B95.doubleValue(), AH97, A82), A82);
		System.out.println(B97);

		// TLV =< Gce < 0
		final Integer B98 = Integer.valueOf(
				resultado(B72.doubleValue() >= D21.doubleValue(), resultado(B72.doubleValue() < 0, "1", "0"), "0"));
		System.out.println(B98);

		// ULV =< Gco < 0
		final Integer B99 = Integer.valueOf(
				resultado(B71.doubleValue() >= D20.doubleValue(), resultado(B71.doubleValue() < 0, "1", "0"), "0"));
		System.out.println(B99);
		// 01,10 ou 11
		final String B100 = resultado(B98 == 0, A82, resultado(B99 == 0, A82, "11"));
		System.out.println(B100);

		// |Gce|
		final BigDecimal B101 = B71.negate();
		System.out.println(B101);

		// |Gce|>=|Gco|
		final String B102 = resultado(B100 == "11", resultado(B101.doubleValue() >= B95.doubleValue(), AH102, A82),
				A82);
		System.out.println(B102);

		// |Gce|<|Gco|
		final String B103 = resultado(B100 == "11", resultado(B101.doubleValue() < B95.doubleValue(), AH103, A82), A82);
		System.out.println(B103);

		// FLV =< Gce <= 0
		final Integer B104 = Integer.valueOf(
				resultado(B71.doubleValue() >= J21.doubleValue(), resultado(B71.doubleValue() <= 0, "1", "0"), "0"));
		System.out.println(B104);

		// 0 =< Gco < ILV
		final Integer B105 = Integer.valueOf(
				resultado(B72.doubleValue() >= 0, resultado(B72.doubleValue() < J20.doubleValue(), "1", "0"), "0"));
		System.out.println(B105);

		// 01,10 ou 11
		final String B106 = resultado(B104 == 0, A82, resultado(B105 == 0, A82, "11"));
		System.out.println(B106);

		// |Gce|>=Gce
		final String B107 = resultado(B106 == "11", resultado(B101.doubleValue() >= B71.doubleValue(), AH107, A82),
				A82);
		System.out.println(B107);

		// |Gce|<Gco
		final String B108 = resultado(B106 == "11", resultado(B101.doubleValue() < B71.doubleValue(), AH108, A82), A82);
		System.out.println(B108);

		if (AH83 == B83) {
			return B83;
		} else {
			if (AH84 == B84) {
				return B84;
			} else {
				if (AH85 == B85) {
					return B85;
				} else {
					if (AH86 == B86) {
						return B86;
					} else {
						if (AH90 == B90) {
							return B90;
						} else {
							if (AH91 == B91) {
								return B91;
							} else {
								if (AH96 == B96) {
									return B96;
								} else {
									if (AH97 == B97) {
										return B97;
									} else {
										if (AH102 == B102) {
											return B102;
										} else {
											if (AH103 == B103) {
												return B103;
											} else {
												if (AH107 == B107) {
													return B107;
												} else {
													if (AH108 == B108) {
														return B108;
													} else {
														return "NA";
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

	private String resultado(final boolean b, final String verdade, final String falso) {
		if (b)
			return verdade;
		else
			return falso;
	}

	public static void main(String[] args) {

		ParaconsistenteService para = new ParaconsistenteServiceImpl();
		String resultante = para.resultante(new BigDecimal(0.25), new BigDecimal(-0.75));
		System.out.println("resultante: " + resultante);

	}

}