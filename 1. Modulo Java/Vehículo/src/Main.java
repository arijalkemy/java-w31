import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = Arrays.asList(
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
        );

        List<Vehiculo> ordenadosPorPrecio = listaVehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());

        System.out.println("Lista ordenada por precio:");
        ordenadosPorPrecio.forEach(System.out::println);

        List<Vehiculo> ordenadosPorMarcaYPrecio = listaVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());

        System.out.println("\nLista ordenada por marca y luego por precio:");
        ordenadosPorMarcaYPrecio.forEach(System.out::println);

        List<Vehiculo> baratos = listaVehiculos.stream()
                .filter(v -> v.getCosto() <= 1000)
                .collect(Collectors.toList());

        System.out.println("\nVehículos con precio <= 1000:");
        baratos.forEach(System.out::println);

        List<Vehiculo> caros = listaVehiculos.stream()
                .filter(v -> v.getCosto() > 1000)
                .collect(Collectors.toList());

        System.out.println("\nVehículos con precio > 1000:");
        caros.forEach(System.out::println);

        double promedio = listaVehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println("\nPromedio de precios: $" + promedio);
    }
}
