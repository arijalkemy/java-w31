package progresionNumerica;

public abstract class ProgresionNumerica<T extends Number> {
    T currentNumber;
    T initialNumber;
    T increments;

    public ProgresionNumerica(T initialNumber, T increments) {
        this.initialNumber = initialNumber;
        this.currentNumber = initialNumber;
        this.increments = increments;
    }

    public abstract T getNextNumber();

    public void resetProgression() {
        this.currentNumber = this.initialNumber;
    }

    // Según como esta escrito el ejemplo del ejercicio asumo que setear un nuevo numero de arranque hace que el
    // siguiente valor parta desde ese numero.
    public void setStartingNumber(T initialNumber) {
        this.initialNumber = initialNumber;
        this.currentNumber = this.initialNumber;
    }

}
