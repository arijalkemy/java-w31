package dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosMax;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosMax, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosMax = cantidadDeVehiculosMax;
        this.vehiculos = vehiculos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.vehiculos.size() < this.cantidadDeVehiculosMax) {
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.vehiculos.size() < this.cantidadDeVehiculosMax) {
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
        }
    }

    public void eliminaVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    private Double calcularCoeficiente(Vehiculo vehiculo) {
        // (Velocidad * ½ Aceleracion) / (AnguloDeGiro * (Peso-Cantidad de Ruedas * 100))
        return (vehiculo.getVelocidad() * (0.5 * vehiculo.getAceleracion())) /
                (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - (vehiculo.getRuedas() * 100)));
    }

    public Vehiculo definirGanador() {
        return vehiculos.stream().max(Comparator.comparingDouble(this::calcularCoeficiente)).orElse(null);
    }

    public void socorrerAuto(Auto auto) {
        this.socorristaAuto.socorrer(auto);
    }

    public void socorrerMoto(Moto moto) {
        this.socorristaMoto.socorrer(moto);
    }
}
