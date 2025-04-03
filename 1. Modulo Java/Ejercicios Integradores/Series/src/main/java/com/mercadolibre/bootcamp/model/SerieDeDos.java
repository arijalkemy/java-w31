package com.mercadolibre.bootcamp.model;

public class SerieDeDos extends Prototipo{

    public SerieDeDos(Number valorInicial) {
        super(valorInicial);
        this.valorActual = valorInicial;
        this.periodo = 2;
    }

    @Override
    public Number getSiguienteValor() {
        valorActual = valorActual.intValue() + 2;
        return valorActual;
    }

    @Override
    public void setValorInicial(Number valor) {
        this.valorInicial = valor;

    }

    @Override
    public void reiniciar() {
        this.valorActual = this.valorInicial;

    }
}
