import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] temperaturas = {
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

        int temperaturaMinima = Integer.MAX_VALUE;
        int temperaturaMaxima = Integer.MIN_VALUE;
        String ciudadMinima = "";
        String ciudadMaxima = "";

        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i][0];
                ciudadMinima = ciudades[i];
            }

            if (temperaturas[i][1] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i][1];
                ciudadMaxima = ciudades[i];
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudadMinima + ", con " + temperaturaMinima + " ºC.");
        System.out.println("La mayor temperatura la tuvo " + ciudadMaxima + ", con " + temperaturaMaxima + " ºC.");
    }
}