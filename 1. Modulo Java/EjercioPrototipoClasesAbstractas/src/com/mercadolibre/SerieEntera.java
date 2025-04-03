package com.mercadolibre;

public class SerieEntera extends Prototipo<Integer> {
    public SerieEntera(Integer valorInicial, Integer incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Integer valorSiguiente() {
        valorActual += incremento;
        return valorActual;
    }
}