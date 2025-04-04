package clase.POO.cinco.ejercicio1;

public class Main {
    public static void main(String[] args) {
        Prototipo<Integer> serieEntera = new SerieEntera(10, 2);
        System.out.println(serieEntera.siguiente());
    }
}
