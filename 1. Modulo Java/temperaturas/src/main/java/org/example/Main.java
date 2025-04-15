package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] temperaturas = {
            {-2,-3,-8,4,6,5,0,-7,-1,-10},
            {33,32,27,37,42,43,39,26,31,35}
        };

        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Pablo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String ciudadMax = "";
        String ciudadMin = "";

        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[0][i] < min) {
                ciudadMin = ciudades[i];
                min = temperaturas[0][i];
            }
            if (temperaturas[1][i] > max) {
                ciudadMax = ciudades[i];
                max = temperaturas[1][i];
            }
        }

        System.out.println("La ciudad con mayor temperatura es " + ciudadMax + " con " + max + " grados.");
        System.out.println("La ciudad con menor temperatura es " + ciudadMin + " con " + min + " grados.");
    }
}