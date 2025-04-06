package series;

public class SerieDos <T extends Number> extends Prototipo {
    public SerieDos(T valorInicial) {
        super.establecerValorInicial(valorInicial);
        super.valorActual = valorInicial;
    }

    @Override
    public T valorSiguiente() {
            T value = (T) super.valorActual;
            super.valorActual = Main.add(super.valorActual, super.valorInicial);
            return value;
    }
}
