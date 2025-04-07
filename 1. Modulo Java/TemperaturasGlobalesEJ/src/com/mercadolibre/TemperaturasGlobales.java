package com.mercadolibre;

import java.util.ArrayList;

public class TemperaturasGlobales {
    public static void main(String[] args) {

        //Cargamos el array con ciudades
        ArrayList<String> ciudades = new ArrayList<>();
        ciudades.add("Londres");
        ciudades.add("Madrid");
        ciudades.add("Nueva York");
        ciudades.add("Buenos Aires");
        ciudades.add("Asunción");
        ciudades.add("Sao Paulo");
        ciudades.add("Lima");
        ciudades.add("Santiago de Chile");
        ciudades.add("Lisboa");
        ciudades.add("Tokio");

        //Llenamos la matriz de temperaturas
        Integer[][] temperaturas = {
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
        int temperaturaMax = Integer.MIN_VALUE;
        int temperaturaMin = Integer.MAX_VALUE;
        String ciudadMayor = "";
        String ciudadMenor = "";


        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][1] > temperaturaMax) {
                temperaturaMax = temperaturas[i][1];
                ciudadMayor = ciudades.get(i);
            }
            if (temperaturas[i][0] < temperaturaMin) {
                temperaturaMin = temperaturas[i][0];
                ciudadMenor = ciudades.get(i);
            }
        }

        System.out.println("La ciudad con menor temperatura es " + ciudadMenor + " con un total de " + temperaturaMin + " C°");
        System.out.println("La ciudad con mayor temperatura es " + ciudadMayor + " con un total de " + temperaturaMax + " C°");


    }
}
