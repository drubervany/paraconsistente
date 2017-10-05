package br.com.paraconsistente.models;

public class Medicao {

    private Integer id;

    private Integer ali;

    private Integer aie;

    private Integer ce;

    private Integer ee;

    private Integer se;

    private String tiposDado;

    private String tiposRegistro;

    private String arquivoReferenciado;

    private Projeto projeto;

    private CFPS cfps;

    public Medicao(Integer id, Integer ali, Integer aie, Integer ce, Integer ee, Integer se, String tiposDado, String tiposRegistro,
            String arquivoReferenciado, Projeto projeto, CFPS cfps) {

        this.id = id;
        this.ali = ali;
        this.aie = aie;
        this.ce = ce;
        this.ee = ee;
        this.se = se;
        this.tiposDado = tiposDado;
        this.tiposRegistro = tiposRegistro;
        this.arquivoReferenciado = arquivoReferenciado;
        this.projeto = projeto;
        this.cfps = cfps;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAli() {
        return ali;
    }

    public Integer getAie() {
        return aie;
    }

    public Integer getCe() {
        return ce;
    }

    public Integer getEe() {
        return ee;
    }

    public Integer getSe() {
        return se;
    }

    public String getTiposDado() {
        return tiposDado;
    }

    public String getTiposRegistro() {
        return tiposRegistro;
    }

    public String getArquivoReferenciado() {
        return arquivoReferenciado;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public CFPS getCfps() {
        return cfps;
    }

    public void verificarComplexidade() {

    }

    public void calcularALI() {

    }

    public void calcularAIE() {

    }

    public void calcularCE() {

    }

    public void calcularEE() {

    }

    public void calcularSE() {

    }

}
