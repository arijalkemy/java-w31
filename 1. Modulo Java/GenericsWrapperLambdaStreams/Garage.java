package GenericsWrapperLambdaStreams;

import java.util.ArrayList;

/* 
 * Ejercicio 1
 * Inicia creando una clase Vehículo con los atributos modelo, marca y costo.
 * Luego crea una clase garaje con los atributos id o identificador único y
 * una lista de vehículos. Crea además los constructores de las clases y los
 * métodos Setter y Getter.
 */
public class Garage {
    int id;
    static int contadorGarage = 0;
    ArrayList<Vehiculo> vehiculos;

    public Garage() {
        this.id = ++contadorGarage;
        this.vehiculos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
    
    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }
}
