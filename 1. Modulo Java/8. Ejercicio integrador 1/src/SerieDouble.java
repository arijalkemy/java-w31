class SerieDouble extends SeriePrototipo<Double> {

    public SerieDouble(Double incremento) {
        super(incremento);
        this.valorInicial = incremento;
        this.valorActual = incremento;
    }

    @Override
    public Double siguienteValor() {
        double resultado = valorActual;
        valorActual += incremento;
        return resultado;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = valorInicial;
    }
}
