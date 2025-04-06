package series;

public abstract class Prototipo <T extends Number>{
    protected T valorInicial;
    protected T valorActual;

    public abstract T valorSiguiente();

    public void reiniciarSerie() {
        this.valorActual = this.valorInicial;
    }

    public void establecerValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }
}
