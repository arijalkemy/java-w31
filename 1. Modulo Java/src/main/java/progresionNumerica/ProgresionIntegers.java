package progresionNumerica;

public class ProgresionIntegers extends ProgresionNumerica<Integer> {

    public ProgresionIntegers(Integer initialNumber, Integer increments) {
        super(initialNumber, increments);
    }

    @Override
    public Integer getNextNumber() {
        this.currentNumber = this.currentNumber + this.increments;
        return this.currentNumber;
    }
}
