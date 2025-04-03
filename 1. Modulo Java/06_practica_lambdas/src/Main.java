import vehiculos.Vehiculo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

                vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
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


                vehiculos.sort((Comparator.comparing(Vehiculo::getCosto).thenComparing(Vehiculo::getMarca)));
                vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto).thenComparing(Vehiculo::getMarca));

                vehiculos.stream().mapToDouble((v) -> v.getCosto()).average();

        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println(vehiculos.get(i).getCosto());
        }







    }
}