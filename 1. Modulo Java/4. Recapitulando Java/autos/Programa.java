package autos;

import java.util.List;

public class Programa {

    public static void main(String[] args) {
        Garaje garaje = new Garaje(1);
        inicializarVehiculos(garaje);

        mostrarVehiculosOrdenadosPorCosto(garaje);
        mostrarVehiculosOrdenadosPorMarcaYCosto(garaje);

        mostrarVehiculosPorRangoDePrecio(garaje, 1000, true);
        mostrarVehiculosPorRangoDePrecio(garaje, 1000, false);

        mostrarPromedioDePrecios(garaje);
    }

    private static void inicializarVehiculos(Garaje garaje) {
        Vehiculo[] vehiculos = {
            new Vehiculo("Ford", "Fiesta", 1000),
            new Vehiculo("Ford", "Focus", 1200),
            new Vehiculo("Ford", "Explorer", 2500),
            new Vehiculo("Fiat", "Uno", 500),
            new Vehiculo("Fiat", "Cronos", 1000),
            new Vehiculo("Fiat", "Torino", 1250),
            new Vehiculo("Chevrolet", "Aveo", 1250),
            new Vehiculo("Chevrolet", "Spin", 2500),
            new Vehiculo("Toyota", "Corolla", 1200),
            new Vehiculo("Toyota", "Fortuner", 3000),
            new Vehiculo("Renault", "Logan", 950)
        };

        for (Vehiculo vehiculo : vehiculos) {
            garaje.agregarVehiculo(vehiculo);
        }
    }

    private static void mostrarVehiculosOrdenadosPorCosto(Garaje garaje) {
        garaje.getVehiculos().sort((v1, v2) -> Integer.compare(v1.getCosto(), v2.getCosto()));
        System.out.println("Vehículos ordenados por precio de menor a mayor:");
        mostrarListaDeVehiculos(garaje.getVehiculos());
        System.out.println();
    }

    private static void mostrarVehiculosOrdenadosPorMarcaYCosto(Garaje garaje) {
        garaje.getVehiculos().sort((v1, v2) -> {
            int comparacionMarca = v1.getMarca().compareTo(v2.getMarca());
            return (comparacionMarca != 0) ? comparacionMarca : Integer.compare(v1.getCosto(), v2.getCosto());
        });
        System.out.println("Vehículos ordenados por marca y precio:");
        mostrarListaDeVehiculos(garaje.getVehiculos());
    }

    private static void mostrarVehiculosPorRangoDePrecio(Garaje garaje, int limite, boolean menorOIgual) {
        String mensaje = menorOIgual ? "Vehículos con precio menor o igual a " : "Vehículos con precio mayor o igual a ";
        System.out.println(mensaje + limite + ":");
        garaje.getVehiculos().stream()
                .filter(v -> menorOIgual ? v.getCosto() <= limite : v.getCosto() >= limite)
                .forEach(v -> System.out.println("Marca: " + v.getMarca() + ", Modelo: " + v.getModelo() + ", Costo: " + v.getCosto()));
        System.out.println();
    }

    private static void mostrarPromedioDePrecios(Garaje garaje) {
        double total = garaje.getVehiculos().stream().mapToInt(Vehiculo::getCosto).sum();
        double promedio = total / garaje.getVehiculos().size();
        System.out.println("Promedio total de precios: " + promedio);
        System.out.println();
    }

    private static void mostrarListaDeVehiculos(List<Vehiculo> vehiculos) {
        vehiculos.forEach(v -> System.out.println("Marca: " + v.getMarca() + ", Modelo: " + v.getModelo() + ", Costo: " + v.getCosto()));
        System.out.println();
    }
}
