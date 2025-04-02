import Clases.Garage;
import Clases.Vehiculo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Ejercicio 2
        List<Vehiculo> lista = new ArrayList<>();
        lista.add(new Vehiculo("Ford", "Fiesta", 1000));
        lista.add(new Vehiculo("Ford", "Focus", 1200));
        lista.add(new Vehiculo("Ford", "Explorer", 2500));
        lista.add(new Vehiculo("Fiat", "Uno", 500));
        lista.add(new Vehiculo("Fiat", "Cronos", 1000));
        lista.add(new Vehiculo("Fiat", "Torino", 1250));
        lista.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        lista.add(new Vehiculo("Chevrolet", "Spin", 2500));
        lista.add(new Vehiculo("Toyota", "Corola", 1200));
        lista.add(new Vehiculo("Toyota", "Fortuner", 3000));
        lista.add(new Vehiculo("Renault", "Logan", 950));

        Garage garaje = new Garage(1, lista);


        //Ejercicio 3
        System.out.println("\nVehiculos ordenados por precio de menor a mayor:");
        garaje.getVehiculos().stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .forEach(System.out::println);

        //Ejercicio 4
        System.out.println("\nVehiculos ordenados por marca y luego por costo:");
        garaje.getVehiculos().stream()
                .sorted((v1, v2) -> {
                    int comparacionMarca = v1.getMarca().compareTo(v2.getMarca());
                    // Si la marca es igual, comparo por costo
                    if (comparacionMarca == 0) {
                        return Double.compare(v1.getCosto(), v2.getCosto());
                    } else {
                        return comparacionMarca;
                    }
                })
                .forEach(System.out::println);

        //Ejercicio 5
        System.out.println("\nVehiculos con precio menor o igual a 1000:");
        garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() <= 1000)
                .forEach(System.out::println);

        System.out.println("\nVehiculos con precio mayor o igual a 1000:");
        garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .forEach(System.out::println);

        double promedio = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println("\nPromedio de precios de los vehiculos:\n" + String.format("%.2f", promedio));
    }
}