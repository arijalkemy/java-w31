import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage("1", Arrays.asList(
                new Vehiculo("Fiesta", "Ford", 1000),
                new Vehiculo("Focus", "Ford", 1200),
                new Vehiculo("Explorer", "Ford", 2500),
                new Vehiculo("Uno", "Fiat", 500),
                new Vehiculo("Cronos", "Fiat", 1000),
                new Vehiculo("Torino", "Fiat", 1250),
                new Vehiculo("Aveo", "Chevrolet", 1250),
                new Vehiculo("Spin", "Chevrolet", 2500),
                new Vehiculo("Corolla", "Toyota", 1200),
                new Vehiculo("Fortuner", "Toyota", 3000),
                new Vehiculo("Logan", "Renault", 950)
        ));

        // Ordenado por Costo
        // garage.getVehiculos().sort((v1, v2) -> v1.getCosto() < v2.getCosto() ? -1 : 1);
        // garage.getVehiculos().stream().forEach((v) -> System.out.println(v.getMarca() + " - " + v.getModelo() + " - " + v.getCosto()));

        //Ordenado por Marca y Costo
        // garage.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        // garage.getVehiculos().stream().forEach((v) -> System.out.println(v.getMarca() + " - " + v.getModelo() + " - " + v.getCosto()));

        // Vehiculos costo <= 1000
        // garage.getVehiculos().stream().filter(v -> v.getCosto() <= 1000).forEach(v -> System.out.println(v.getMarca() + " - " + v.getModelo() + " - " + v.getCosto()));
        // Vehiculos costo >= 1000
        // garage.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).forEach(v -> System.out.println(v.getMarca() + " - " + v.getModelo() + " - " + v.getCosto()));
        // Promedio costo
        // System.out.println(garage.getVehiculos().stream().mapToDouble(v -> v.getCosto()).average());

    }
}
