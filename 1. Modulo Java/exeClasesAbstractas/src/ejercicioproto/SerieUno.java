package ejercicioproto;

public class SerieUno <T extends Number> extends Prototipo{

    public SerieUno(T number) {
        this.initialNum = number;
        this.nextNum = number;
    }

    @Override
    public T nextValue(){
        nextNum = addNumber(nextNum, 2);
        return (T) nextNum;
    }

    @Override
    public void rebootSerie() {
        initialNum = 1;
        nextNum = initialNum;
    }
}
