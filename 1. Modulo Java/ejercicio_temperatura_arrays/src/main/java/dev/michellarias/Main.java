package dev.michellarias;

public class Main {
    public static void main(String[] args) {

         String[] ciudadesVector = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo",
         "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

         int[][] matrizTemps = {{-2,33}, {-3,32}, {-8,27}, {4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

         int minusIndex = 0;
         int maxIndex = 0;
         int minusTemp = Integer.MAX_VALUE;
         int maxTemp = Integer.MIN_VALUE;
         for (int i = 0; i < ciudadesVector.length; i++) {
             int tempMin = matrizTemps[i][0];
             int tempMax = matrizTemps[i][1];
             for (int j = 0; j < matrizTemps[i].length; j++) {
                 if (tempMin <= minusTemp) {
                     minusTemp = tempMin;
                     minusIndex = i;
                 }
                 if (tempMax > maxTemp) {
                     maxTemp = tempMax;
                     maxIndex = i;
                 }

             }
         }
        System.out.printf("Minus temp: %d, Ciudad: %s\n", minusTemp, ciudadesVector[minusIndex]);
        System.out.printf("Max temp: %d, Ciudad: %s\n", maxTemp, ciudadesVector[maxIndex]);





    }
}
