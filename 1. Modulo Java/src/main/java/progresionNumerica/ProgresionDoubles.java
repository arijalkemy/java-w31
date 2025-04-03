package progresionNumerica;

public class ProgresionDoubles extends ProgresionNumerica<Double> {
    public ProgresionDoubles(Double initialNumber, Double increments) {
        super(initialNumber, increments);
    }

    @Override
    public Double getNextNumber() {
        this.currentNumber = this.currentNumber + increments;
        return this.currentNumber;
    }
}
