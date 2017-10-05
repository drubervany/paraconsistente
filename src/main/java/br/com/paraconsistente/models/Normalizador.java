package br.com.paraconsistente.models;

import java.math.BigDecimal;

public class Normalizador {

    private BigDecimal minino;

    private BigDecimal maximo;

    private BigDecimal minimoGrauFavoravel;

    private BigDecimal minimoGrauDesfavoravel;

    private BigDecimal maximoGrauFavoravel;

    private BigDecimal maximoGrauDesfavoravel;

    public Normalizador(BigDecimal minino, BigDecimal maximo, BigDecimal minimoGrauFavoravel, BigDecimal minimoGrauDesfavoravel,
            BigDecimal maximoGrauFavoravel, BigDecimal maximoGrauDesfavoravel) {

        this.minino = minino;
        this.maximo = maximo;
        this.minimoGrauFavoravel = minimoGrauFavoravel;
        this.minimoGrauDesfavoravel = minimoGrauDesfavoravel;
        this.maximoGrauFavoravel = maximoGrauFavoravel;
        this.maximoGrauDesfavoravel = maximoGrauDesfavoravel;
    }

    public BigDecimal getMinino() {
        return minino;
    }

    public BigDecimal getMaximo() {
        return maximo;
    }

    public BigDecimal getMinimoGrauFavoravel() {
        return minimoGrauFavoravel;
    }

    public BigDecimal getMinimoGrauDesfavoravel() {
        return minimoGrauDesfavoravel;
    }

    public BigDecimal getMaximoGrauFavoravel() {
        return maximoGrauFavoravel;
    }

    public BigDecimal getMaximoGrauDesfavoravel() {
        return maximoGrauDesfavoravel;
    }

    public void calcularBaricentro() {

    }

    public void calcularMinimo() {

    }

    public void calcularMaximo() {

    }

}
