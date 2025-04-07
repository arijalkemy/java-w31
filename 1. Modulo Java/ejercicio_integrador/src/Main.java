package src;
public class Main {
    public static void main(String[] args) {
        Prototipo prototipo = new Prototipo(0, 3);
        java.util.stream.IntStream.range(0, 4)
            .forEach(i -> System.out.println(prototipo.getValor()));
        Prototipo prototipo2 = new Prototipo(1, 3);
        java.util.stream.IntStream.range(0, 4)
        .forEach(i -> System.out.println(prototipo2.getValor()));

        for (int i = 0; i < 4; i++) {
            System.out.println(prototipo.getValor());
            if(i == 1) {
                prototipo.resetValor();
                prototipo.resetSerie();
            }
        }
    }
}
