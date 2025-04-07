class SerieEntera extends SeriePrototipo<Integer> {

    public SerieEntera(Integer incremento) {
        super(incremento);
        this.valorInicial = incremento;
        this.valorActual = incremento;
    }

    @Override
    public Integer siguienteValor() {
        int resultado = valorActual;
        valorActual += incremento;
        return resultado;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = valorInicial;
    }
}
