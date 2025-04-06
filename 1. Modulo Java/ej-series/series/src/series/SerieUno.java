package series;

public class SerieUno <T extends Number> extends Prototipo {
    public SerieUno(T valorInicial) {
        super.establecerValorInicial(valorInicial);
        super.valorActual = valorInicial;
    }

    @Override
    public T valorSiguiente() {
        super.valorActual = Main.add(super.valorActual, 2);
        return (T) super.valorActual;
    }
}
