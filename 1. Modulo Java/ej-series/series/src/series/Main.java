package series;

public class Main {
    public static void main(String[] args) {
        SerieUno serieUno = new SerieUno(1);
        for (int i = 0; i < 5; i++) {
            System.out.println(serieUno.valorSiguiente());
        }

        SerieDos serieDos = new SerieDos(3.5);
        for (int i = 0; i < 5; i++) {
            System.out.println(serieDos.valorSiguiente());
        }
    }

    public static Number add(Number a, Number b) {
        if (a instanceof Integer || a instanceof Long || a instanceof Short) {
            return a.longValue() + b.longValue();
        } else {
            return a.doubleValue() + b.doubleValue();
        }
    }
}
