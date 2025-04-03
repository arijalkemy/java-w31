package GenericsWrapperLambdaStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Ejercicio 2
 * Haz una clase Main con el método main para representar un escenario donde
 * se crea una instancia de la clase garaje con una lista de vehículos según
 * la tabla.
 * 
 * (tabla)
 * 
 * Ejercicio 3
 * Haciendo uso del método sort en la lista de Vehículos con expresiones
 * lambda, obtén una lista de vehículos ordenados por precio de menor a mayor,
 * imprime por pantalla el resultado.
 * 
 * Ejercicio 4
 * De la misma forma que el ejercicio anterior, imprime una lista ordenada
 * por marca y a su vez por precio.
 * 
 * Ejercicio 5
 * Se desea extraer una lista de vehículos con precio no mayor a 1000,
 * luego otra con precios mayor o igual 1000 y por último, obtén el promedio
 * total de precios de toda la lista de vehículos.
 */
public class Main {
    public static void main(String[] args) {

        // Ejercicio 2
        Garage garage = new Garage();

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

        for (String[] datos : datosVehiculos) {
            String marca = datos[0];
            String modelo = datos[1];
            int precio = Integer.parseInt(datos[2]);
            garage.agregarVehiculo(new Vehiculo(modelo, marca, precio));
        }

        // Ejercicio 3
        ArrayList<Vehiculo> vehiculos = garage.getVehiculos();
        vehiculos.sort((v1, v2) -> Integer.compare(v1.getCosto(), v2.getCosto()));

        System.out.println("Vehículos ordenados por precio (menor a mayor):");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo() + ", Precio: " + vehiculo.getCosto());
        }

        // Ejercicio 4
        ArrayList<Vehiculo> vehiculos2 = garage.getVehiculos();
        vehiculos2.sort((v1, v2) -> {
            int comparacionMarca = v1.getMarca().compareTo(v2.getMarca());
            if (comparacionMarca == 0) {
                return Integer.compare(v1.getCosto(), v2.getCosto());
            }
            return comparacionMarca;
        });
    
        System.out.println("Vehículos ordenados por marca y luego por precio (menor a mayor):");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo() + ", Precio: " + vehiculo.getCosto());
        }

        // Ejercicio 5
        ArrayList<Vehiculo> vehiculos3 = garage.getVehiculos();
        List<Vehiculo> vehiculosMenores1000 = vehiculos3.stream()
                                                    .filter(v -> v.getCosto() < 1000)
                                                    .collect(Collectors.toList());
        List<Vehiculo> vehiculosMayoresOIgual1000 = vehiculos3.stream()
                                                    .filter(v -> v.getCosto() >= 1000)
                                                    .collect(Collectors.toList());

        double suma1 = vehiculosMenores1000.stream().mapToDouble(v -> v.getCosto()).sum();
        double promedioMenores1000 = vehiculosMenores1000.isEmpty() ? 0 : (double) suma1 / vehiculosMenores1000.size();

        double suma2 = vehiculosMayoresOIgual1000.stream().mapToDouble(v -> v.getCosto()).sum();
        double promedioMayoresOIgual1000 = vehiculosMayoresOIgual1000.isEmpty() ? 0 : (double) suma2 / vehiculosMayoresOIgual1000.size();
    
        System.out.println("El promedio de los costos de vehículos cuyo valor es menor a 1000 es: " + promedioMenores1000);
        System.out.println("El promedio de los costos de vehículos cuyo valor es mayor o igual a 1000 es: " + promedioMayoresOIgual1000);
    }
}
