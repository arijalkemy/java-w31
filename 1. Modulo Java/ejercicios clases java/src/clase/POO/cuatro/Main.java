package clase.POO.cuatro;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> lista = new ArrayList<>();
        lista.add(new Vehiculo("Ford", "Fiesta", 1000));
        lista.add(new Vehiculo("Ford", "Focus", 1200));
        lista.add(new Vehiculo("Ford", "Explorer", 2500));
        lista.add(new Vehiculo("Fiat", "Uno", 500));
        lista.add(new Vehiculo("Fiat", "Cronos", 1000));
        lista.add(new Vehiculo("Fiat", "Torino", 1250));
        lista.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        lista.add(new Vehiculo("Chevrolet", "Spin", 2500));
        lista.add(new Vehiculo("Toyota", "Corola", 1200));
        lista.add(new Vehiculo("Toyota", "Fortuner", 3000));
        lista.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(lista);

        System.out.println("\n Vehiculos ordenados por costo:");
        garaje.getListaVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
    }


}