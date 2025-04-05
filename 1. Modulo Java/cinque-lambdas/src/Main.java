import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage("1");
        garage.addVehicle(new Vehicle("Ford", "Fiesta", 1000D));
        garage.addVehicle(new Vehicle("Ford", "Focus", 1200D));
        garage.addVehicle(new Vehicle("Ford", "Explorer", 2500D));
        garage.addVehicle(new Vehicle("Fiat", "Uno", 500D));
        garage.addVehicle(new Vehicle("Fiat", "Cronos", 1000D));
        garage.addVehicle(new Vehicle("Fiat", "Torino", 1250D));
        garage.addVehicle(new Vehicle("Chevrolet", "Aveo", 1250D));

        List<Vehicle> vehicles = garage.getVehicles();

        // sort by price
        System.out.println("\n---Ordered by price---\n");
        Comparator<Vehicle> priceComparator = Comparator.comparing(Vehicle::getPrice);
        vehicles.stream()
                .sorted(priceComparator)
                .forEachOrdered(System.out::println);
        // vehicles.sort(Comparator.comparing((Vehicle v)->v.getPrice()));

        // sort by brand and price
        System.out.println("\n---Ordered by brand and price---\n");
        Comparator<Vehicle> priceBrandComparator = Comparator.comparing(Vehicle::getBrand).thenComparing(Vehicle::getPrice);
        vehicles.stream()
                .sorted(priceBrandComparator)
                .forEachOrdered(System.out::println);
//        vehicles.sort(Comparator.comparing((Vehicle v)->v.getBrand())
//                .thenComparing(v -> v.getPrice()));

        // filter by price
        System.out.println("\n---Filtered by price < 1000---\n");
        vehicles.stream()
                .filter(v -> v.getPrice() < 1000)
                .forEach(System.out::println);

        System.out.println("\n---Filtered by price >= 1000---\n");
        vehicles.stream()
                .filter(v -> v.getPrice() >= 1000)
                .forEach(System.out::println);

        System.out.println("\n---Average of prices---\n");
        vehicles.stream()
                .mapToDouble(Vehicle::getPrice)
                .average()
                .ifPresent(System.out::println);
    }
}