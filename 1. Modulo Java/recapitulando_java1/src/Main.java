import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000.0));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200.0));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500.0));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500.0));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000.0));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500.0));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200.0));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000.0));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950.0));

        Garage garage1 =  new Garage(1,vehiculos);

        //Ordenados por precio
        vehiculos.sort((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()));
        
        //Ordenados por marca y precio
        vehiculos.sort((v1, v2) -> {
            int marcaCompar = v1.getMarca().compareTo(v2.getMarca());
            if (marcaCompar == 0) {
                return Double.compare(v1.getCosto(), v2.getCosto());
            }
            return marcaCompar;
        });
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }


        System.out.println('\n');
        //Precios hasta 1000
        System.out.println("Vehiculos con precio no mayor a 1000" + '\n' +
                vehiculos.stream().filter(v-> v.getCosto()<1000).toList());

        System.out.println('\n');
        //Precio mayor o igual a 1000
        System.out.println("Vehiculos con precio mayor o igual a 1000" + '\n' +
                vehiculos.stream().filter(v-> v.getCosto()>=1000).toList());

        System.out.println('\n');
        //Promedio total de precios
        double promedio = vehiculos.stream().mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);
        System.out.println("Promedio: " + promedio);
    }

}