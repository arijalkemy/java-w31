package EJINT_SeriesNumericas;

public class Main {
    public static void main(String[] args) {
        SerieDos serie2 = new SerieDos();

        System.out.println("Serie de 2 desde 0:");
        System.out.println(serie2.siguienteValor()); // 2
        System.out.println(serie2.siguienteValor()); // 4
        System.out.println(serie2.siguienteValor()); // 6
        System.out.println("Serie de 2 desde 1");
        serie2.establecerValorInicial(1);            // nuevo valor inicial
        System.out.println(serie2.siguienteValor()); // 3
        System.out.println(serie2.siguienteValor()); // 5
        System.out.println(serie2.siguienteValor());

        SerieTres serie3 = new SerieTres();

        System.out.println("\nSerie de 3 desde 0:");
        System.out.println(serie3.siguienteValor()); // 3
        System.out.println(serie3.siguienteValor()); // 6
        System.out.println(serie3.siguienteValor()); // 9
        System.out.println("Serie de 3 desde 1");
        serie3.establecerValorInicial(1);            // nuevo valor inicial
        System.out.println(serie3.siguienteValor()); // 3
        System.out.println(serie3.siguienteValor()); // 6
        System.out.println(serie3.siguienteValor());
    }
}