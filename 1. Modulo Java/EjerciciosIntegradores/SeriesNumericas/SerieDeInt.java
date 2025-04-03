package EjerciciosIntegradores.SeriesNumericas;

public class SerieDeInt extends Prototipo {
    private int incremento;

    public SerieDeInt(int incremento, int valorInicial) {
        super(valorInicial);
        this.incremento = incremento;
    }

    @Override
    public Number devolverValorSiguiente() {
        int valorActual = (int) getValorActual();
        setValorActual(valorActual + incremento);
        return getValorActual();
    }

    public int getIncremento() {
        return incremento;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }
}