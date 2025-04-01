package ejercicioGenerics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corolla", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garaje garaje = new Garaje(1, vehiculos);

        List<Vehiculo> sortedByPrice = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).toList();
        System.out.println("Ordenados por precio:\n");
        sortedByPrice.forEach(System.out::println);

        System.out.println("\nOrdenados por marca y precio:\n");
        List<Vehiculo> sortedByMarcaByPrice = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Comparator.comparingInt(Vehiculo::getCosto))).toList();
        sortedByMarcaByPrice.forEach(System.out::println);

        System.out.println("\nVehiculos menores a 1000:\n");
        List<Vehiculo> vehiclesLessThan1000 = garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000).toList();
        vehiclesLessThan1000.forEach(System.out::println);

        System.out.println("\nVehiculos mayores a 1000:\n");
        List<Vehiculo> vehiclesMoreThan1000 = garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).toList();
        vehiclesMoreThan1000.forEach(System.out::println);

        var particionados = garaje.getVehiculos().stream().collect(Collectors.partitioningBy(v -> v.getCosto() > 1000));

        double averagePrice = garaje.getVehiculos().stream().map(Vehiculo::getCosto).collect(Collectors.averagingInt(v -> v));
        System.out.println("Precio promedio de los vehiculos: " + averagePrice);

    }

}
