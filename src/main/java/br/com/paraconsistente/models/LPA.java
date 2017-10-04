package br.com.paraconsistente.models;

public class LPA {

    private Integer grauIncerteza;

    private Integer grauCerteza;

    public LPA(Integer grauIncerteza, Integer grauCerteza) {
        super();
        this.grauIncerteza = grauIncerteza;
        this.grauCerteza = grauCerteza;
    }

    public Integer getGrauIncerteza() {
        return grauIncerteza;
    }

    public Integer getGrauCerteza() {
        return grauCerteza;
    }

}
