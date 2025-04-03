package EJINT_Dakar;
import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto; // Instancia de socorrista para autos
    private SocorristaMoto socorristaMoto; // Instancia de socorrista para motos

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    // dar de alta auto
    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
            System.out.println("Auto agregado: " + auto);
        } else {
            System.out.println("No se puede agregar más vehiculos");
        }
    }

    // dar de alta moto
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
            System.out.println("Moto agregada: " + moto);
        } else {
            System.out.println("No se puede agregar más vehiculos");
        }
    }

    // eliminar vehiculo
    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (listaDeVehiculos.remove(vehiculo)) {
            System.out.println("Vehiculo eliminado");
        } else {
            System.out.println("Vehiculo no encontrado");
        }
    }

    // eliminar por patente
    public void eliminarVehiculoConPatente(String unaPatente) {
        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if (listaDeVehiculos.get(i).getPatente().equals(unaPatente)) {
                listaDeVehiculos.remove(i);
                System.out.println("Vehiculo con patente " + unaPatente + " eliminado");
                return;
            }
        }
        System.out.println("No se encontró ningún vehculo con la patente " + unaPatente);
    }

    //ganador de la carrera
    public Vehiculo determinarGanador() {
        if (listaDeVehiculos.isEmpty()) {
            System.out.println("No hay vehiculos en la carrera");
            return null;
        }

        Vehiculo ganador = null;
        double maxPuntaje = Double.NEGATIVE_INFINITY;

        for (Vehiculo vehiculo : listaDeVehiculos) {
            double puntaje = vehiculo.calcularPuntaje();
            // si puntaje actual es mayor que el máximo
            if (puntaje > maxPuntaje) {
                maxPuntaje = puntaje;
                ganador = vehiculo;
            }
        }

        return ganador;
    }

    // socorrer un auto por patente
    public void socorrerAuto(String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo instanceof Auto && vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
                return;
            }
        }
        System.out.println("No se encontro un auto con la patente: " + patente);
    }

    // socorrer una moto por patente
    public void socorrerMoto(String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo instanceof Moto && vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) vehiculo);
                return;
            }
        }
        System.out.println("No se encontro una moto con la patente: " + patente);
    }


    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}
