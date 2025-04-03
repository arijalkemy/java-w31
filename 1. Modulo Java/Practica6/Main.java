package Practica6;

import Practica6.Garage;
import Practica6.Vehiculo;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Garage garage = new Garage("01");
        garage.agregarVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        garage.agregarVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garage.agregarVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Uno", 500));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
        garage.agregarVehiculo(new Vehiculo("Toyota", "Corola", 1200));
        garage.agregarVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
        garage.agregarVehiculo(new Vehiculo("Renault", "Logan", 950));



        //System.out.println(garage.toString());

        garage.ordenarPorMarcayCosto();



        List <String> lista = List.of("A", "E", "I");

        lista.stream().filter(letra -> !lista.contains("a"));

        lista.stream().map(letra -> letra.toUpperCase());

        lista.stream().map(letra -> letra.toUpperCase());

        lista.stream().map(String::toUpperCase).forEach(letra-> System.out.println(letra));

        lista.stream().map(String::toUpperCase).forEach(System.out::println);



        lista.stream().filter(letra -> !lista.contains("a"));

        lista.stream().map(letra -> letra.toUpperCase());

        lista.stream().map(letra -> letra.toUpperCase());

        lista.stream().map(String::toUpperCase).forEach(letra-> System.out.println(letra));

        lista.stream().map(String::toUpperCase).forEach(System.out::println);


    }
}
