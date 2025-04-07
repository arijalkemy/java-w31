package bootcamp.recapJava;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        // Crear una lista de Vehiculo y agregar las instancias
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(vehiculo1);
        listaVehiculos.add(vehiculo2);
        listaVehiculos.add(vehiculo3);
        listaVehiculos.add(vehiculo4);
        listaVehiculos.add(vehiculo5);
        listaVehiculos.add(vehiculo6);
        listaVehiculos.add(vehiculo7);
        listaVehiculos.add(vehiculo8);
        listaVehiculos.add(vehiculo9);
        listaVehiculos.add(vehiculo10);
        listaVehiculos.add(vehiculo11);

        // Crear una instancia de Garaje y pasarle la lista de vehículos
        Garaje garaje = new Garaje(1, listaVehiculos);

        // Ordenar los vehículos por costo y mostrar
        // garaje.getVehiculos().stream().sorted((a,b) -> a.getCosto() - b.getCosto()).forEach(System.out::println);
        // garaje.getVehiculos().stream()
         //       .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
           //     .forEach(System.out::println);
       // garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(System.out::println);
       // garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);
        double total =  garaje.getVehiculos().stream().map(Vehiculo::getCosto).reduce(0, Integer::sum);
        double promedio = total / garaje.getVehiculos().size();
        System.out.println("El costo total de los vehículos es: " + total);
        System.out.println("El promedio de costo de los vehículos es: "+ promedio);
    }
}
