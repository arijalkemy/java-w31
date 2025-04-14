package recapitulandoJava;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1);

        String[][] datosVehiculos = {
                {"Ford", "Fiesta", "1000"},
                {"Ford", "Focus", "1200"},
                {"Ford", "Explorer", "2500"},
                {"Fiat", "Uno", "500"},
                {"Fiat", "Cronos", "1000"},
                {"Fiat", "Torino", "1250"},
                {"Chevrolet", "Aveo", "1250"},
                {"Chevrolet", "Spin", "2500"},
                {"Toyota", "Corola", "1200"},
                {"Toyota", "Fortuner", "3000"},
                {"Renault", "Logan", "950"}
        };

        for (String[] datosVehiculo : datosVehiculos) {
            String marca = datosVehiculo[0];
            String modelo = datosVehiculo[1];
            double costo = Double.parseDouble(datosVehiculo[2]);
            Vehiculo vehiculo = new Vehiculo(marca, modelo, costo);
            garaje.addVehiculo(vehiculo);
        }

        System.out.println("Vehículos en el garaje:");
        for (Vehiculo v : garaje.getVehiculos()) {
            System.out.println(v);
        }

        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getCosto));

        System.out.println("\nVehículos ordenados por precio (menor a mayor):");
        for (Vehiculo v : garaje.getVehiculos()) {
            System.out.println(v);
        }

        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto));

        System.out.println("\nVehículos ordenados por marca y precio:");
        for (Vehiculo v : garaje.getVehiculos()) {
            System.out.println(v);
        }

        List<Vehiculo> vehiculosMenor1000 = garaje.getVehiculos().stream().filter(v -> v.getCosto() < 1000).toList();
        System.out.println("\nVehículos con precio menor o igual a 1000:");
        vehiculosMenor1000.forEach(System.out::println);

        List<Vehiculo> vehiculosMayor1000 = garaje.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).toList();
        System.out.println("\nVehículos con precio mayor a 1000:");
        vehiculosMayor1000.forEach(System.out::println);

        OptionalDouble promedio = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average();
        if (promedio.isPresent()) {
            System.out.printf("\nPromedio total de precios: %.2f", promedio.getAsDouble());
        } else {
            System.out.println("\nNo se encontraron vehículos para calcular el promedio.");
        }

    }
}
