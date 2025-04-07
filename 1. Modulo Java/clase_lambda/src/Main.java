
import java.util.ArrayList;
import java.util.List;

public class Main <E>{
    
    public static void main(String[] args) {
        List<Vehiculo> cars = new ArrayList<>();

        cars.add(new Vehiculo("Ford", "Fiesta", 1000));
        cars.add(new Vehiculo("Ford", "Focus", 1200));
        cars.add(new Vehiculo("Ford", "Explorer", 2500));
        cars.add(new Vehiculo("Fiat", "Uno", 500));
        cars.add(new Vehiculo("Fiat", "Cronos", 1000));
        cars.add(new Vehiculo("Fiat", "Torino", 1250));
        cars.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        cars.add(new Vehiculo("Chevrolet", "Spin", 2500));
        cars.add(new Vehiculo("Toyota", "Corola", 1200));
        cars.add(new Vehiculo("Toyota", "Fortuner", 3000));
        cars.add(new Vehiculo("Renault", "Logan", 950));

        cars.stream()
            .sorted((x, y) -> Integer.compare(x.getCosto(), y.getCosto()))
            .forEach(System.out::println);;
    }
}
