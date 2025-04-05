package ejercicioproto;

public class SerieDos <T extends Number> extends Prototipo{
    public SerieDos(T number) {
        this.initialNum = number;
        this.nextNum = 0;
    }

    @Override
    public T nextValue(){
        nextNum = addNumber(nextNum, initialNum);
        return (T) nextNum;
    }

    @Override
    public void rebootSerie() {
        initialNum = 2;
        nextNum = initialNum;
    }


}
