package com.mercadolibre.modulojava.ejerciciomatrices;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String[] ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokyo"};
        int[][] temperaturas = new int[10][2];
        int indicemi = 0;
        int indicema = 0;
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
        int temperatura_min = temperaturas[0][0];
        int temperatura_max = temperaturas[0][1];

        for(int i = 0; i < 10; ++i) {
            if (temperatura_min > temperaturas[i][0]) {
                temperatura_min = temperaturas[i][0];
                indicemi = i;
            }

            if (temperatura_max < temperaturas[i][1]) {
                temperatura_max = temperaturas[i][1];
                indicema = i;
            }
        }

        System.out.println("ciudad: " + ciudades[indicemi] + " temperatura minima " + temperatura_min);
        System.out.println("ciudad: " + ciudades[indicema] + " temperatura maxima " + temperatura_max);
    }
}

