package dakar;

import java.util.List;
import java.util.ArrayList;

public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List <Vehiculo> vehiculos;
    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
    }
    

    

    public void darDeAltaAuto(int velocidad, int aceleracion, int angulodeGiro, String patente, String marca, String modelo) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo.Auto auto = new Vehiculo.Auto(velocidad, aceleracion, angulodeGiro, patente, marca, modelo);
            vehiculos.add(auto);
        } else {
            System.out.println("No se pueden agregar más vehículos a la carrera.");
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int angulodeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo.Moto moto = new Vehiculo.Moto(velocidad, aceleracion, angulodeGiro, patente, "Marca", "Modelo");
            vehiculos.add(moto);
        } else {
            System.out.println("No se pueden agregar más vehículos a la carrera.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.contains(vehiculo)) {
            vehiculos.remove(vehiculo);
        } else {
            System.out.println("El vehículo no está en la carrera.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equals(unaPatente)) {
                vehiculos.remove(vehiculo);
                return;
            }
        }
        System.out.println("El vehículo con patente " + unaPatente + " no está en la carrera.");
    }

    public void mostrarGanador() {
        if (!vehiculos.isEmpty()) {
            
            Vehiculo ganador = null;
            double mejorScore = Double.NEGATIVE_INFINITY;

            for (Vehiculo vehiculo : vehiculos) {
                double score = vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                               (vehiculo.getAngulodeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
                if (score > mejorScore) {
                    mejorScore = score;
                    ganador = vehiculo;
                }
            }

            System.out.println("El ganador de la carrera " + nombre + " con distancia de "+ distancia + " km. Es el vehículo con patente: " + ganador.getPatente() + ", con un score de: " + mejorScore + ". Se lleva un premio de $" + premioEnDolares);
        } else {
            System.out.println("No hay vehículos en la carrera.");
        }
    }

    public static class SocorristaAuto {
        public SocorristaAuto() {}
        public void socorrer(String patente) {
            System.out.println("Socorriendo auto " + patente);
        }
    }

    public static class SocorristaMoto {
        public SocorristaMoto() {}
        public void socorrer(String patente) {
            System.out.println("Socorriendo moto " + patente);
        }
    }
    
}
