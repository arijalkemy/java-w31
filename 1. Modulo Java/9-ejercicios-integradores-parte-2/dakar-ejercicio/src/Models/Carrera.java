package Models;

import Models.Socorristas.SocorristaAuto;
import Models.Socorristas.SocorristaMoto;
import Models.Vehiculos.TipoVehiculo;
import Models.Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    public void darDeAlta(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, TipoVehiculo tipoVehiculo) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Vehiculo(velocidad, aceleracion, anguloDeGiro, patente, tipoVehiculo) {
            });
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public Vehiculo definirGanador() {
        return vehiculos.stream().reduce((a, b) -> calcularVelocidadEnCarrera(a) > calcularVelocidadEnCarrera(b) ? a : b).get();
    }

    public Double calcularVelocidadEnCarrera(Vehiculo vehiculo) {
        return vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }

    public void socorrerAuto(String patente) {
        this.socorristaAuto.socorrer();
    }

    public void socorrerMoto(String patente) {
        this.socorristaMoto.socorrer();
    }

}
