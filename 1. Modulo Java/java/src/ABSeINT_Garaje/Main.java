package ABSeINT_Garaje;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        //Ejercicio 2
        List<Vehiculo> vehiculos = new ArrayList<>();
        Garaje garaje = new Garaje();
        vehiculos.add(new Vehiculo("Fiestaa", "Ford", 1000));
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
        garaje.setVehiculos(vehiculos);

        //Ejercicio 3
        vehiculos.sort(Comparator.comparing(vehiculo -> vehiculo.getCosto()));
        vehiculos.forEach(System.out::println);

        //Ejercicio 4
        System.out.println();
        vehiculos.sort(
                Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto));
        vehiculos.forEach(System.out::println);

        //Ejercicio 5
        List<Vehiculo> listadoDeVehiculosConCostoMenorAMil = new ArrayList<>();
        listadoDeVehiculosConCostoMenorAMil = vehiculos.stream().filter(v -> v.getCosto() < 1000).toList();
        System.out.println("Listado de vehiculos con costo menor a mil");
        listadoDeVehiculosConCostoMenorAMil.forEach(System.out::println);

        List<Vehiculo> listadoDeVehiculosConCostoMayorOIgualAMil = new ArrayList<>();
        listadoDeVehiculosConCostoMayorOIgualAMil = vehiculos.stream().filter(v -> v.getCosto() >= 1000).toList();
        System.out.println("listado De Vehiculos Con Costo Mayor O Igual A Mil");
        listadoDeVehiculosConCostoMayorOIgualAMil.forEach(System.out::println);

        Double promedioTotalVehiculos = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println("El promedio total de precios de toda la lista de vehículos es = " + promedioTotalVehiculos);

    }
}
