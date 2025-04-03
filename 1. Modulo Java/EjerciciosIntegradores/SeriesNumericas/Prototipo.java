package EjerciciosIntegradores.SeriesNumericas;

public abstract class Prototipo {
    private Number valorActual;
    private Number valorInicial;

    public Prototipo(Number valorInicial) {
        this.valorActual = valorInicial;
        this.valorInicial = valorInicial;
    }

    public abstract Number devolverValorSiguiente();

    public void reiniciarSerie() {
        this.valorActual = this.valorInicial;
    }
    public void establecerValorInicial(Number valor) {
        this.valorInicial = valor;
    }
    public Number getValorActual() {
        return valorActual;
    }
    public void setValorActual(Number valor) {
        this.valorActual = valor;
    }
}
