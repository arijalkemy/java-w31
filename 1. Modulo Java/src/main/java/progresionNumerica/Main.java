package progresionNumerica;

public class Main {
    public static void main(String[] args) {
        ProgresionNumerica<Integer> serie1 = new ProgresionIntegers(0, 2);
        for (int i = 0; i < 10; i++) {
            System.out.println(serie1.getNextNumber());
        }

        serie1.resetProgression();
        System.out.println(serie1.getNextNumber());
        serie1.setStartingNumber(5);
        for (int i = 0; i < 10; i++) {
            System.out.println(serie1.getNextNumber());
        }

        ProgresionNumerica<Double> serieDoubles = new ProgresionDoubles(1.5, 3.5);
        for (int i = 0; i < 10; i++) {
            System.out.println(serieDoubles.getNextNumber());
        }
    }

}
