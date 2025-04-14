package com.mercadoLibre;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> ciudades = new ArrayList<>();
        ArrayList<int[]> temperaturas = new ArrayList<>();

        boolean datosCargados = false;

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nTemperaturas Globales");
            System.out.println("1. Ingresar ciudades y temperaturas");
            System.out.println("2. Consultar temperatura máxima y mínima");
            System.out.println("3. Salir");
            System.out.print("Seleccionar una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresar el número de ciudades a cargar:");
                    int numCiudades = scanner.nextInt();
                    scanner.nextLine();

                    ciudades.clear();
                    temperaturas.clear();

                    System.out.println("Ingresar las ciudades y sus respectivas temperaturas:");

                    for (int i = 0; i < numCiudades; i++) {
                        System.out.print("Nombre de la ciudad #" + (i + 1) + ": ");
                        ciudades.add(scanner.nextLine());

                        int[] temp = new int[2];
                        System.out.print("Temperatura mínima de " + ciudades.get(i) + ": ");
                        temp[0] = scanner.nextInt();
                        System.out.print("Temperatura máxima de " + ciudades.get(i) + ": ");
                        temp[1] = scanner.nextInt();
                        temperaturas.add(temp);
                        scanner.nextLine();
                    }
                    datosCargados = true;
                    System.out.println("Ciudades y temperaturas ingresadas exitosamente!");
                    break;

                case 2:
                    if (!datosCargados) {
                        System.out.println("No hay datos cargados.");
                    } else {
                        int min_temp = Integer.MAX_VALUE;
                        int max_temp = Integer.MIN_VALUE;
                        String index_min_city = "";
                        String index_max_city = "";

                        for (int i = 0; i < ciudades.size(); i++) {
                            for (int j = 0; j < 2; j++) {
                                if (temperaturas.get(i)[j] < min_temp) {
                                    min_temp = temperaturas.get(i)[j];
                                    index_min_city = ciudades.get(i);
                                }
                                if (temperaturas.get(i)[j] > max_temp) {
                                    max_temp = temperaturas.get(i)[j];
                                    index_max_city = ciudades.get(i);
                                }
                            }
                        }

                        System.out.printf("Ciudad con la temperatura mínima (%d°C): %s%n", min_temp, index_min_city);
                        System.out.printf("Ciudad con la temperatura máxima (%d°C): %s%n", max_temp, index_max_city);
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, ingresar un número entre 1 y 3.");
            }

        } while (opcion != 3);

        scanner.close();

    }
}
