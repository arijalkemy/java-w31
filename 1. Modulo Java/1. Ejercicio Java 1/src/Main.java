//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/*
Ejercicio de temperaturas globale

 */


public class Main {
    public static void main(String[] args) {
        String[] ciudades = { "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio" };
        int temperaturaMenor = 0;
        int temperaturaMayor = 0;
        int indiceMayor= 0;
        int indiceMenor = 0;
        int[][] temperaturas ={
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };
        for (int f = 0; f < temperaturas.length; f++) {
            for (int c = 0; c < temperaturas[f].length; c++) {
                if (temperaturaMayor <= temperaturas[f][c]) {
                    indiceMayor = f;
                    temperaturaMayor = temperaturas[f][c];
                }
                if (temperaturaMenor >= temperaturas[f][c]) {
                    indiceMenor = f;
                    temperaturaMenor = temperaturas[f][c];
                }

            }
        }
        System.out.println("La ciudad con la mayor temperatura es " + ciudades[indiceMayor]);
        System.out.println("con " + temperaturaMayor + " C°");
        System.out.println("La ciudad con la menor temperatura es " + ciudades[indiceMenor]);
        System.out.println("con " + temperaturaMenor + " C°");
    }
}