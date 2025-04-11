package com.meli;


public class Main {
        public static void main(String[] args) {
            Garaje garaje = new Garaje(1);
            //Creamos Vehiculos
            garaje.agregarVehiculo (new Vehiculo(1000, "Fiesta", "Ford"));
            garaje.agregarVehiculo (new Vehiculo(1200, "Focus", "Ford"));
            garaje.agregarVehiculo (new Vehiculo(2500, "Explorer", "Ford"));
            garaje.agregarVehiculo (new Vehiculo(500, "Uno", "Fiat"));
            garaje.agregarVehiculo (new Vehiculo(1000, "Cronos", "Fiat"));
            garaje.agregarVehiculo (new Vehiculo(1250, "Torino", "Fiat"));
            garaje.agregarVehiculo (new Vehiculo(1250, "Aveo", "Chevrolet"));
            garaje.agregarVehiculo (new Vehiculo(2500, "Spin", "Chevrolet"));
            garaje.agregarVehiculo (new Vehiculo(1200, "Corola", "Toyota"));
            garaje.agregarVehiculo (new Vehiculo(3000, "Fortuner", "Toyota"));
            garaje.agregarVehiculo (new Vehiculo(950, "Logan", "Renault"));

                System.out.println("Vehículos antes de ordenar:");
            garaje.mostrarVehiculos();
                System.out.println("--------");
            garaje.getVehiculos().stream().sorted((a, b) -> a.getCosto() - b.getCosto()).forEach(System.out::println); // sorted por precio del vehiculo
            System.out.println("--------");
            garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto()<=1000).forEach(System.out::println); // precio menor o igual a 1000
                System.out.println("--------");
            garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto()>=1000).forEach(System.out::println); // precio mayor o igual a 1000
            // hacer el promedio de todos los costos
            System.out.println("Promedio de todos los costos: ");
            garaje.getVehiculos().stream().mapToInt(Vehiculo::getCosto).average().ifPresent(System.out::println); // promedio de todos los costos
            



        }
}