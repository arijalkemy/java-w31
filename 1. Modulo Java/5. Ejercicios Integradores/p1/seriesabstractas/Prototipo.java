package seriesabstractas;

public abstract class Prototipo<T extends Number> {

    private T valorActual;
    private final T progresion;

    public Prototipo(T valorActual, T progresion) {
        this.valorActual = valorActual;
        this.progresion = progresion;
    }

    public T getValorActual() {
        System.out.println("Valor actual: " + valorActual);
        return valorActual;
    }

    public T getValorSiguiente() {
        valorActual = suma(valorActual, progresion);
        System.out.println("Valor siguiente: " + valorActual);
        return valorActual;
    }

    protected T setValorActual(T valorActual) {
        this.valorActual = valorActual;
        System.out.println("Valor actual actualizado: " + valorActual);
        return this.valorActual;
    }

    abstract public void resetSeries();

    abstract public T suma(T valor1, T valor2);
}
