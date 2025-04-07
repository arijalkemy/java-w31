import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1);

        garaje.agregarVehiculo(new Vehiculo("Fiesta", "Ford", 1000));
        garaje.agregarVehiculo(new Vehiculo("Focus", "Ford", 1200));
        garaje.agregarVehiculo(new Vehiculo("Explorer", "Ford", 2500));
        garaje.agregarVehiculo(new Vehiculo("Uno", "Fiat", 500));
        garaje.agregarVehiculo(new Vehiculo("Cronos", "Fiat", 1000));
        garaje.agregarVehiculo(new Vehiculo("Torino", "Fiat", 1250));
        garaje.agregarVehiculo(new Vehiculo("Aveo", "Chevrolet", 1250));
        garaje.agregarVehiculo(new Vehiculo("Spin", "Chevrolet", 2500));
        garaje.agregarVehiculo(new Vehiculo("Corola", "Toyota", 1200));
        garaje.agregarVehiculo(new Vehiculo("Fortuner", "Toyota", 3000));
        garaje.agregarVehiculo(new Vehiculo("Logan", "Renault", 950));

        // Imprimir los vehículos agregados
        System.out.println("Vehículos en el garaje:");
        for (Vehiculo vehiculo : garaje.getVehiculos()) {
            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getCosto());
        }

        // Ordenar los vehículos por costo de menor a mayor
        garaje.getVehiculos().sort((v1,v2) -> Double.compare(v1.getCosto(), v2.getCosto()));


        // Ordenar los vehículos por costo de mayor a menor
        //garaje.getVehiculos().sort((v1,v2) -> Double.compare(v2.getCosto(), v1.getCosto()));

        System.out.println("Vehículos ordenados por costo:");
        for (Vehiculo vehiculo : garaje.getVehiculos()) {
            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getCosto());
        }

        ArrayList<Vehiculo> VehiculosPorMarcayPrecio = new ArrayList<>(garaje.getVehiculos());

        VehiculosPorMarcayPrecio.sort((v1, v2) -> {
            int marcaComparison = v1.getMarca().compareTo(v2.getMarca());
            if (marcaComparison != 0) {
                return marcaComparison;
            } else {
                return Double.compare(v1.getCosto(), v2.getCosto());
            }
        });

        // Imprimir los vehículos ordenados por marca y luego por costo
        System.out.println("Vehículos ordenados por marca y luego por costo:");
        for (Vehiculo vehiculo : VehiculosPorMarcayPrecio) {
            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getCosto());
        }


        // Extraer lista de vehículos con precio no mayor a 1000
        List<Vehiculo> vehiculosMenoresMil = garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() <= 1000)
                .collect(Collectors.toList());

        // Extraer lista de vehículos con precio mayor o igual a 1000
        List<Vehiculo> vehiculosMayoresMil = garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() > 1000)
                .collect(Collectors.toList());

        // Calcular el promedio total de precios de toda la lista de vehículos
        double sumaPrecios = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .sum();
        double promedioPrecios = sumaPrecios / garaje.getVehiculos().size();

        // Imprimir resultados
        System.out.println("Vehículos con precio no mayor a 1000:");
        vehiculosMenoresMil.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));

        System.out.println("Vehículos con precio mayor o igual a 1000:");
        vehiculosMayoresMil.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));

        System.out.println("Promedio total de precios de toda la lista de vehículos: " + promedioPrecios);


    }
}