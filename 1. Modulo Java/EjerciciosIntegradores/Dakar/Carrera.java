package EjerciciosIntegradores.Dakar;

import java.util.List;
import java.util.ArrayList;

public class Carrera {
    private Long distancia;
    private double PremioEnDolares;
    private String nombre;
    private Long cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Long distancia, double premio, String nombre, Long cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.PremioEnDolares = premio;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Long velocidad, Long aceleracion, Long AnguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, AnguloDeGiro, patente, 1000, 4);
            listaDeVehiculos.add(auto);
        } else {
            System.out.println("No se pueden agregar más vehículos a la carrera, no hay cupo.");
        }
    }

    public void darDeAltaMoto(Long velocidad, Long aceleracion, Long AnguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, AnguloDeGiro, patente, 300, 2);
            listaDeVehiculos.add(moto);
        } else {
            System.out.println("No se pueden agregar más vehículos a la carrera, no hay cupo.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (listaDeVehiculos.contains(vehiculo)) {
            listaDeVehiculos.remove(vehiculo);
        } else {
            System.out.println("No se pudo eliminar el vehículo, no se encuentra anotado en la carrera.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        listaDeVehiculos.stream()
                        .filter(vehiculo -> vehiculo.getPatente().equals(unaPatente))
                        .findFirst()
                        .ifPresentOrElse(vehiculo -> {
                            listaDeVehiculos.remove(vehiculo);
                            System.out.println("Vehículo eliminado.");
                        }, () -> System.out.println("No se pudo eliminar el vehículo, no se encuentra anotado en la carrera."));
    }

    private int calcularPuntaje (Vehiculo vehiculo) {
        return (int) ((vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2)) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getCantRuedas() * 100)));
    }

    public Vehiculo definirGanador() {
        Vehiculo ganador = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (ganador == null || calcularPuntaje(vehiculo) > calcularPuntaje(ganador)) {
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    public void socorrerAuto(Auto auto) {
        this.socorristaAuto.socorrer(auto);
    }

    public void socorrerMoto(Moto moto) {
        this.socorristaMoto.socorrer(moto);
    }

    public List<Vehiculo> getVehiculos() {
        return listaDeVehiculos;
    }
}
