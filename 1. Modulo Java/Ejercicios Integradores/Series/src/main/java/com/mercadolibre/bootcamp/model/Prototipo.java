package com.mercadolibre.bootcamp.model;

public abstract class Prototipo <T extends Number> {

    protected T valorInicial;
    protected T periodo;
    protected T valorActual;

    public Prototipo(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public abstract T getSiguienteValor();
    public  abstract void setValorInicial(T valor);
    public  abstract void reiniciar();
}
