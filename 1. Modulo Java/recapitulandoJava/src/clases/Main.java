package clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
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
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garage garage = new Garage(1, vehiculos);

        List<Vehiculo> vehiculosGarageSorted = new ArrayList<>();
        vehiculosGarageSorted = garage.getVehiculos();

        System.out.println("Autos ordenados");
        System.out.println("-------------------------------------------");
        vehiculosGarageSorted.stream().sorted(Comparator.comparing(Vehiculo::getCosto).thenComparing(Vehiculo::getMarca)).
                                        forEach(b -> System.out.println(b.toString()));

        System.out.println("Autos mayores de 1000");
        System.out.println("-------------------------------------------");
        vehiculosGarageSorted.stream().filter(vehiculo -> vehiculo.getCosto() > 1000).
                                        forEach(b -> System.out.println(b.toString()));

        System.out.println("Autos menores de 1000");
        System.out.println("-------------------------------------------");
        vehiculosGarageSorted.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).
                                        forEach(b -> System.out.println(b.toString()));

        List<Integer> listaPrecios = new ArrayList<>();
        for (Vehiculo vehiculo: vehiculosGarageSorted) {
            listaPrecios.add(vehiculo.getCosto());
        }
        OptionalDouble promedio = listaPrecios.stream().mapToDouble(b -> b).average();
        System.out.println("Promedio: " + promedio.getAsDouble());



    }
}
