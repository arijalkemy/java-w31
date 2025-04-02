package org.example;

public class Main {
    public static void main(String[] args) {
        String [] ciudades = { "Londres", "Madrid", "Nueva York", "Buenos aires",
                "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int [][] temperaturas = {{-2, 33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int temp_minima=Integer.MAX_VALUE;
        String ciudad_temp_minima="";

        int temp_maxima=Integer.MIN_VALUE;
        String ciudad_temp_maxima="";

        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < 2; j++) {
                if(temperaturas[i][j]<temp_minima){
                    temp_minima=temperaturas[i][j];
                    ciudad_temp_minima=ciudades[i];
                }

                if(temperaturas[i][j]>temp_maxima){
                    temp_maxima=temperaturas[i][j];
                    ciudad_temp_maxima=ciudades[i];
                }
            }
        }

        System.out.println("La ciudad con la temperatura más baja fue: "+ciudad_temp_minima+ " con "+temp_minima+"°C ."+"\n"+
                "La ciudad con la temperatura más alta fue: "+ciudad_temp_maxima+ " con "+temp_maxima+"°C .");
    }
}