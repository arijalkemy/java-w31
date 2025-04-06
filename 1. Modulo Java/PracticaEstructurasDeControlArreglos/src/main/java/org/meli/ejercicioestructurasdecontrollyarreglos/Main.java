package org.meli.ejercicioestructurasdecontrollyarreglos;

public class Main {
    public static void main(String[] args) {

        String cities [] = new String []{"Londres", "Madrid", "Nueva york",
                "Buenos aires", "Asunción", "São Paulo", "Lima",
                "Santiago de Chile", "Lisboa",  "Tokio"};

        int[][] temperature = new int[][]{
                {-2, 40},
                {-3, 32},
                {-18, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35},
        };

        for (int i = 0; i < 10; i++) {
            System.out.println("La ciudad "
                    + cities[i] + " registró una menor temperatura de "
                    + temperature[i][0] + " y la mayor temperatura es " + temperature[i][1]);
        }
    }
}