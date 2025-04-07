import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        garaje miGaraje = new garaje(1);

        // Añadiendo vehículos al garaje
        miGaraje.addVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        miGaraje.addVehiculo(new Vehiculo("Ford", "Focus", 1200));
        miGaraje.addVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        miGaraje.addVehiculo(new Vehiculo("Fiat", "Uno", 500));
        miGaraje.addVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        miGaraje.addVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        miGaraje.addVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        miGaraje.addVehiculo(new Vehiculo("Chevrolet", "Torino", 2500));
        miGaraje.addVehiculo(new Vehiculo("Toyota", "Corola", 1200));
        miGaraje.addVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
        miGaraje.addVehiculo(new Vehiculo("Renault", "Logan", 950));

        // Ordenando por precio en el main
        System.out.println("\nVehículos ordenados por precio:");
        List<Vehiculo> vehiculosOrdenadosPorPrecio = miGaraje.getVehiculos().stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .toList();

        for (Vehiculo vehiculo : vehiculosOrdenadosPorPrecio) {
            System.out.println(vehiculo.getMarca() + " - " + vehiculo.getModelo() + " - " + vehiculo.getCosto());
        }

        // Ordenando por marca y precio en el main
        System.out.println("\nVehículos ordenados por Marca y Precio:");
        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio = miGaraje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .toList();

        for (Vehiculo vehiculo : vehiculosOrdenadosPorMarcaYPrecio) {
            System.out.println(vehiculo.getMarca() + " - " + vehiculo.getModelo() + " - " + vehiculo.getCosto());
        }
        // Vehículos con precio no mayor a 1000
        System.out.println("\nVehículos con precio no mayor a 1000:");
        List<Vehiculo> vehiculosMenorOIgualA1000 = miGaraje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .toList();

        for (Vehiculo vehiculo : vehiculosMenorOIgualA1000) {
            System.out.println(vehiculo.getMarca() + " - " + vehiculo.getModelo() + " - " + vehiculo.getCosto());
        }

        // Vehículos con precio mayor o igual a 1000
        System.out.println("\nVehículos con precio mayor o igual a 1000:");
        List<Vehiculo> vehiculosMayorOIgualA1000 = miGaraje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();

        for (Vehiculo vehiculo : vehiculosMayorOIgualA1000) {
            System.out.println(vehiculo.getMarca() + " - " + vehiculo.getModelo() + " - " + vehiculo.getCosto());
        }

        // Promedio total de precios
        double promedioCosto = miGaraje.getVehiculos().stream()
                .mapToInt(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println("\nPromedio total de precios de los vehículos: " + promedioCosto);

    }
}