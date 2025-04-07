abstract class SeriePrototipo<T extends Number> {
    protected T valorInicial;
    protected T incremento;
    protected T valorActual;

    public SeriePrototipo(T incremento) {
        this.incremento = incremento;
        this.valorActual = incremento;
    }

    public abstract T siguienteValor();
    public abstract void reiniciarSerie();
    public void establecerValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }
}
