package com.mercadolibre;

public class Main {
    public static void main(String[]args){
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asuncion", "Sao Paolo", "Lima", "Santiago de Chile", "Lisboa",
                "Tokio"};
        int temperaturas[][] = new int[10][2];
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;


        int temperaturaMaxima = 0;
        int ciudadConMaximaTemperatura = 0;

        //Mostrar Temperatura Máxima.
        for (int f = 0; f < temperaturas.length; f++) {
            for (int c = 0; c < temperaturas[f].length; c++) {
                if (temperaturas[f][c] > temperaturaMaxima) {
                    temperaturaMaxima = temperaturas[f][c];
                    ciudadConMaximaTemperatura = f;
                }
            }
        }

        System.out.println("La ciudad " + ciudades[ciudadConMaximaTemperatura] +
                " tuvo la temperatura máxima con " + temperaturaMaxima + " grados.");

        //Mostrar Temperatura Mínima.
        int temperaturaMinima = 0;
        int ciudadConMinimaTemperatura = 0;
        for (int t = 0; t < temperaturas.length; t++) {
            for (int p = 0; p < temperaturas[p].length; p++) {
                if (temperaturas[t][p] < temperaturaMinima) {
                    temperaturaMinima = temperaturas[t][p];
                    ciudadConMinimaTemperatura = t;
                }
            }
        }
        System.out.println("La ciudad " + ciudades[ciudadConMinimaTemperatura] +
                " tuvo la temperatura máxima con " + temperaturaMinima + " grados.");

    }
}
