package com.mercadolibre;

public class SerieDecimal extends Prototipo<Double> {
    public SerieDecimal(Double valorInicial, Double incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Double valorSiguiente() {
        valorActual += incremento;
        return valorActual;
    }
}