package ejercicioproto;

public abstract class Prototipo <T extends Number> {
    public T initialNum;
    public T nextNum;

    public abstract T nextValue();

    public abstract void rebootSerie();

    public void setInitialNum(T num){
        this.initialNum = num;
    };

    public T addNumber(Number num1, Number num2){

        if (num1 instanceof Integer) {
            nextNum = (T) (Number) (num1.intValue() + num2.intValue());
        } else if (num1 instanceof Double) {
            nextNum = (T) (Number) (num1.doubleValue() + num2.doubleValue());
        }
        return nextNum;
    }
}
