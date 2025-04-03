package com.mercadolibre;

public abstract class Prototipo<T extends Number> {
    protected T valorActual;
    protected T incremento;
    protected T valorInicial;

    public Prototipo(T valorActual, T incremento) {
        this.valorActual = valorActual;
        this.valorInicial = valorActual;
        this.incremento = incremento;
    }

    public abstract T valorSiguiente();

    public void reiniciarSerie() {
        this.valorActual = this.valorInicial;
    }

    public void establecerValorInicial(T nuevoValorInicial) {
        this.valorActual = nuevoValorInicial;
    }
}
