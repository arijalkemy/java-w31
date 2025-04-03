import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(
                List.of(
                        new Vehiculo("Ford", "Fiesta", 1000),
                        new Vehiculo("Ford", "Focus", 1200),
                        new Vehiculo("Ford", "Explorer", 2500),
                        new Vehiculo("Fiat", "Uno", 500),
                        new Vehiculo("Fiat", "Cronos", 1000),
                        new Vehiculo("Fiat", "Torino", 1250),
                        new Vehiculo("Chevrolet", "Aveo", 1250),
                        new Vehiculo("Chevrolet", "Spin", 2500),
                        new Vehiculo("Toyota", "Corola", 1200),
                        new Vehiculo("Toyota", "Fortuner", 3000),
                        new Vehiculo("Renault", "Logan", 950)
                )
        );

        System.out.println("\tEjercicio 3");
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("\tEjercicio 4");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing( Vehiculo::getMarca ).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);


        System.out.println("\tEjercicio 5");

        System.out.println("Menor mil");
        garaje.getVehiculos().stream().filter(v -> v.getCosto() < 1000).forEach(System.out::println);

        System.out.println("Mayor mil");
        garaje.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).forEach(System.out::println);

        System.out.println("Promedio = " + garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble());
    }
}