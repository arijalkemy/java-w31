package org.example;

public class Main {
    public static void main(String[] args) {

        int maxTemperature = Integer.MIN_VALUE;
        int minTemperature = Integer.MAX_VALUE;
        String coldestCity = "";
        String hottestCity = "";

        String citys[] = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"};

        int[][] temperature = {
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

        for (int i = 0; i < temperature.length; i++) {
            for (int j = 0; j < temperature[i].length; j++) {
                if (temperature[i][j] > maxTemperature) {
                    maxTemperature = temperature[i][j];
                    hottestCity = citys[j];
                }
                if (temperature[i][j] < minTemperature) {
                    minTemperature = temperature[i][j];
                    coldestCity = citys[j];
                }
            }
        }
        System.out.println(hottestCity + " es la ciudad mas caliente con temp: "+ maxTemperature + "°");
        System.out.println(coldestCity + " es la ciudad mas fria con temp: "+ minTemperature+ "°");
    }
}