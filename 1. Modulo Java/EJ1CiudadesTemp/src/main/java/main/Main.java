package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		/*
		opcion para no tener que ingresarlos por teclado

		String[] ciudades = {
			"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
			"São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
		};
		int[][] matrizTemp = {
			{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42},
            {5, 43}, {0, 39}, {-7, 26}, {-1, 13}, {-10, 35}
		};

		*/
        String ciudades[] = new String[10];
        int matrizTemp[][] = new int[10][2];
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Ingrese el nombre de la ciudad " + (i + 1) + ":");
            ciudades[i] = scanner.nextLine();
            System.out.println("Ingrese la temperatura mínima de " + ciudades[i] + ":");
            matrizTemp[i][0] = scanner1.nextInt();
            System.out.println("Ingrese la temperatura máxima de " + ciudades[i] + ":");
            matrizTemp[i][1] = scanner1.nextInt();
        
        }
    


		int tempMax = matrizTemp[0][1];
		int tempMin = matrizTemp[0][0];
		String ciudadMax = ciudades[0];
		String ciudadMin = ciudades[0];	

		for(int i = 0; i<matrizTemp.length;i++){
			for (int j = 0; j<matrizTemp[i].length;j++){
				if(matrizTemp[i][j] < tempMin){
					tempMin = matrizTemp[i][j];
					ciudadMin = ciudades[i];
				}
				if(matrizTemp[i][j] > tempMax){
					tempMax = matrizTemp[i][j];
					ciudadMax = ciudades[i];
				}

			}
		}
		System.out.println("La temperatura máxima es de: " + tempMax + "°C y corresponde a " + ciudadMax);
		System.out.println("La temperatura mínima es de: " + tempMin + "°C y corresponde a " + ciudadMin);
		System.out.println("------------------------------------------------------------");
	}
}
