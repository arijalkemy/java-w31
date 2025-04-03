package com.company;

public abstract class Prototipo {
    private Integer paso;
    private Integer valorSiguiente;
    private Integer valorInicial;

    public Prototipo(Integer paso){
        this.paso = paso;
    }

    public Integer valorSiguiente() {
        return this.valorSiguiente += this.paso;
    }

    public void reiniciar() {
        this.valorInicial = 0;
        this.valorSiguiente = 0;
    }

    public void valorInicial(Integer valorInicial) {
        this.valorSiguiente = valorInicial;
        this.valorInicial = valorInicial;
    }

}
