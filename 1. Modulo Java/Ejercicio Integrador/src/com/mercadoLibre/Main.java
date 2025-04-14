package com.mercadoLibre;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Garage garage = new Garage();

        garage.agregarVehiculo(new Vehiculo("Ford", "Fiesta", 1000.0));
        garage.agregarVehiculo(new Vehiculo("Ford", "Focus", 1200.0));
        garage.agregarVehiculo(new Vehiculo("Ford", "Explorer", 2500.0));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Uno", 500.0));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Cronos", 1000.0));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Torino", 1250.0));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Spin", 2500.0));
        garage.agregarVehiculo(new Vehiculo("Toyota", "Corolla", 1200.0));
        garage.agregarVehiculo(new Vehiculo("Toyota", "Fortuner", 3000.0));
        garage.agregarVehiculo(new Vehiculo("Renault", "Logan", 950.0));

        while (true) {
            System.out.println("\nSeleccione una opción");
            System.out.println("1. Mostrar listado de todos los vehiculos.");
            System.out.println("2. Mostrar listado de vehículos ordenados de menor a mayor precio");
            System.out.println("3. Mostrar listado de vehículos ordenados por marca");
            System.out.println("4. Promedios precios");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            if (opcion == 0) break;

            switch (opcion) {
                case 1:
                    garage.mostrarVehiculos();
                    break;
                case 2:
                    garage.ordenarMenorMayorPrecio();
                    break;
                case 3:
                    garage.ordenarMarca();
                    break;
                case 4:
                    garage.listadosPromedio();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

}
