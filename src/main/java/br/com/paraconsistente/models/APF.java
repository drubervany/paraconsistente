package br.com.paraconsistente.models;

public class APF {

    private Integer aie;

    private Integer ali;

    private Integer totalPF;

    private Integer saidaExterna;

    private Integer entradaExterna;

    private Integer consultaExterna;

    private Integer totalAlta;

    private Integer totalBaixa;

    private Integer totalMedia;

    private Integer totalSE;

    private Integer totalEE;

    private Integer totalCE;

    private Integer totalALI;

    private Integer totalAIE;

    public APF(Integer aie, Integer ali, Integer totalPF, Integer saidaExterna, Integer entradaExterna, Integer consultaExterna,
            Integer totalAlta, Integer totalBaixa, Integer totalMedia, Integer totalSE, Integer totalEE, Integer totalCE, Integer totalALI,
            Integer totalAIE) {
        super();
        this.aie = aie;
        this.ali = ali;
        this.totalPF = totalPF;
        this.saidaExterna = saidaExterna;
        this.entradaExterna = entradaExterna;
        this.consultaExterna = consultaExterna;
        this.totalAlta = totalAlta;
        this.totalBaixa = totalBaixa;
        this.totalMedia = totalMedia;
        this.totalSE = totalSE;
        this.totalEE = totalEE;
        this.totalCE = totalCE;
        this.totalALI = totalALI;
        this.totalAIE = totalAIE;
    }

    public Integer getAie() {
        return aie;
    }

    public Integer getAli() {
        return ali;
    }

    public Integer getTotalPF() {
        return totalPF;
    }

    public Integer getSaidaExterna() {
        return saidaExterna;
    }

    public Integer getEntradaExterna() {
        return entradaExterna;
    }

    public Integer getConsultaExterna() {
        return consultaExterna;
    }

    public Integer getTotalAlta() {
        return totalAlta;
    }

    public Integer getTotalBaixa() {
        return totalBaixa;
    }

    public Integer getTotalMedia() {
        return totalMedia;
    }

    public Integer getTotalSE() {
        return totalSE;
    }

    public Integer getTotalEE() {
        return totalEE;
    }

    public Integer getTotalCE() {
        return totalCE;
    }

    public Integer getTotalALI() {
        return totalALI;
    }

    public Integer getTotalAIE() {
        return totalAIE;
    }

}
