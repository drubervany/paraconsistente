package br.com.paraconsistente.models;

public class Normalizador {

    private Integer minino;

    private Integer maximo;

    public Normalizador(Integer minino, Integer maximo) {
        super();
        this.minino = minino;
        this.maximo = maximo;
    }

    public Integer getMinino() {
        return minino;
    }

    public void setMinino(Integer minino) {
        this.minino = minino;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

}
