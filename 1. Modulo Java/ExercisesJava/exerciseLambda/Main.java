package exerciseLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> listV = List.of(
                new Vehiculo("Fiesta", "Ford", 1000F),
                new Vehiculo("Focus", "Ford", 1200F),
                new Vehiculo("Explorer", "Ford", 2500F),
                new Vehiculo("Uno", "Fiat", 500F),
                new Vehiculo("Cronos", "Fiat", 1000F),
                new Vehiculo("Torino", "Fiat", 1250F),
                new Vehiculo("Aveo", "Chevrolet", 1250F),
                new Vehiculo("Spin", "Chevrolet", 2500F),
                new Vehiculo("Corola", "Toyota", 1200F),
                new Vehiculo("Fortuner", "Toyota", 3000F),
                new Vehiculo("Logan", "Renault", 950F));

        // listavVehiculos.stream().map(p ->
        // p.getMarca()).forEach(System.out::println);;;
        Garage garage = new Garage(1, listV);
        // numeral 3
        // garage.listaVehiculos.sort((Vehiculo v1, Vehiculo v2)-> v1.getCosto() >
        // v2.getCosto() ? 1: -1);
        listV.stream().sorted((Vehiculo v1, Vehiculo v2) -> v1.getCosto() > v2.getCosto() ? 1 : -1)
                .forEach(System.out::println);

        System.out.println(" Numeral 4 ");

        // numeral 4
        // listV<Vehiculo>vec=(veh1,veh2)-> veh1.ge

        listV.stream()
                .sorted((Vehiculo v1, Vehiculo v2) -> v1.getCosto() > v2.getCosto() ? 1 : -1)
                .sorted((Vehiculo v1, Vehiculo v2) -> v1.getMarca().compareTo(v2.getMarca()))
                .forEach(System.out::println);

        System.out.println(" Numeral 5 ");

        // numeral 5
        // filtro por precio menor a 1000
        listV.stream().filter((Vehiculo v1) -> v1.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println(" Precios mayores a 1000");
        // filtro por precio mayor o igual a 1000
        listV.stream().filter((Vehiculo v1) -> v1.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println(" total");

        // filtro con total de precio

        Float precioTotal = listV.stream().map(Vehiculo::getCosto).reduce(0.0F, Float::sum);
        System.out.println("El precio total de precio de la lista es: " + precioTotal);

    }
}
