package com.mercadolibre.bootcamp.model;

public class SerieDeTres extends Prototipo{

    public SerieDeTres(Number valorInicial) {
        super(valorInicial);
        this.valorActual = valorInicial;
        this.periodo = 3;
    }

    @Override
    public Number getSiguienteValor() {
        valorActual = valorActual.intValue() + 3;
        return valorActual;
    }

    @Override
    public void setValorInicial(Number valor) {

    }

    @Override
    public void reiniciar() {

    }
}
