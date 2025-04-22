package org.example;

import org.example.models.Garaje;
import org.example.models.Vehiculo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Ford","Fiesta",1000D);
        Vehiculo vehiculo2 = new Vehiculo("Ford","Focus",1200D);
        Vehiculo vehiculo3 = new Vehiculo("Ford","Explorer",2500D);
        Vehiculo vehiculo4 = new Vehiculo("Fiat","Uno",500D);
        Vehiculo vehiculo5 = new Vehiculo("Fiat","Cronos",1000D);
        Vehiculo vehiculo6 = new Vehiculo("Fiat","Torino",1250D);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet","Aveo",1250D);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet","Spin",2500D);
        Vehiculo vehiculo9 = new Vehiculo("Toyota","Corolla",2500D);
        Vehiculo vehiculo10 = new Vehiculo("Toyota","Fortuner",3000D);
        Vehiculo vehiculo11 = new Vehiculo("Renault","Logan",950D);

        List<Vehiculo> vehiculos = List.of(vehiculo1,vehiculo2,vehiculo3,vehiculo4,vehiculo5,
                vehiculo6,vehiculo7,vehiculo8,vehiculo9,vehiculo10,vehiculo11);

        System.out.println("------Se imprime vehiculos ordenados con precio de menor a mayor.----");
        //Se imprime vehiculos ordenados con precio de menor a mayor.
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto))
                .map(Vehiculo::toString).forEach(System.out::println);

        System.out.println("-----Se imprime vehiculos ordenados por marca y precio--------");
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .map(Vehiculo::toString).forEach(System.out::println);

        System.out.println("------------ Se imprime vehiculos con precio menores a 1000 -----------------");
        List<Vehiculo> vehiculosMenoresMil = vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()<=1000).toList();
        vehiculosMenoresMil.forEach(System.out::println);

        System.out.println("------------ Se imprime vehiculos con precio mayores a 1000 -----------------");
        List<Vehiculo> vehiculosMayoresMil = vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()>=1000).toList();
        vehiculosMayoresMil.forEach(System.out::println);

        double promedio = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0);

        System.out.println("El costo promedio de los vehiculos es: " + promedio);

        Garaje garaje = new Garaje(1,vehiculos);





    }
}