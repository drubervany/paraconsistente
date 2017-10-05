package br.com.paraconsistente.models;

import java.math.BigDecimal;

public class LPA {

    private BigDecimal peso;

    private BigDecimal baricentro;

    private BigDecimal resultante;

    private BigDecimal grauIncerteza;

    private BigDecimal grauCerteza;

    public LPA(BigDecimal peso, BigDecimal baricentro, BigDecimal resultante, BigDecimal grauIncerteza, BigDecimal grauCerteza) {
        super();
        this.peso = peso;
        this.baricentro = baricentro;
        this.resultante = resultante;
        this.grauIncerteza = grauIncerteza;
        this.grauCerteza = grauCerteza;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public BigDecimal getBaricentro() {
        return baricentro;
    }

    public BigDecimal getResultante() {
        return resultante;
    }

    public BigDecimal getGrauIncerteza() {
        return grauIncerteza;
    }

    public BigDecimal getGrauCerteza() {
        return grauCerteza;
    }

}
