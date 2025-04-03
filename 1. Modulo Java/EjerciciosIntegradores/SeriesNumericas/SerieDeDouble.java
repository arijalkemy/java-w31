package EjerciciosIntegradores.SeriesNumericas;

public class SerieDeDouble extends Prototipo {
    private double incremento;

    public SerieDeDouble(double incremento, double valorInicial) {
        super(valorInicial);
        this.incremento = incremento;
    }

    @Override
    public Number devolverValorSiguiente() {
        double valorActual = (double) getValorActual();
        setValorActual(valorActual + incremento);
        return getValorActual();
    }

    public double getIncremento() {
        return incremento;
    }

    public void setIncremento(double incremento) {
        this.incremento = incremento;
    }
}
