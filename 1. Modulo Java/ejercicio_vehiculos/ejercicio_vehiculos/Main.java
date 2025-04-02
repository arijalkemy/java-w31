package ejercicio_vehiculos;

public class Main {
    public static void main(String[] args) {
        Garaje garage = new Garaje(1);
        garage.agregarVehiculo(new Vehiculo("Ford", "Fiesta", 1000.0));
        garage.agregarVehiculo(new Vehiculo("Ford", "Focus", 1200.0));
        garage.agregarVehiculo(new Vehiculo("Ford", "Explorer", 2500.0));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Uno", 500.0));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Cronos", 1000.0));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Torino", 1250.0));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Spin", 2500.0));
        garage.agregarVehiculo(new Vehiculo("Toyota", "Corolla", 1200.0));
        garage.agregarVehiculo(new Vehiculo("Toyota", "Fortuner", 3000.0));
        garage.agregarVehiculo(new Vehiculo("Renault", "Logan", 950.0));

        System.out.println("Lista de vehiculos ordenados por precio de menor a mayor:");
        garage.ordenarMenorAMayorPrecio();
        System.out.println("\nLista de vehiculos ordenados por marca y precio:");
        garage.ordenarMarcaYPrecio();

        System.out.println("\nLista de vehiculos con precio menor a 100:");
        garage.precioMenorMil();

        System.out.println("\nLista de vehiculos con precio mayor o igual a 1000:");
        garage.precioMayorIgualMil();

        System.out.println("Promedio de precios de los vehiculos:");
        System.out.println(garage.promedioPrecios());
    }
}
