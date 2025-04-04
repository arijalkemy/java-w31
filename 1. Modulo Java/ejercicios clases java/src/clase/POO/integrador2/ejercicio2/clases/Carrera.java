package clase.POO.integrador2.ejercicio2.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
        this.vehiculos = new ArrayList<>();
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.cantidadDeVehiculosPermitidos > 0 || this.vehiculos.isEmpty()) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            this.vehiculos.add(auto);
        } else {
            System.out.println("Se llego al limite de vehiculos!");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            this.vehiculos.add(moto);
        } else {
            System.out.println("Se llego al limite de vehiculos!");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        this.vehiculos = this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).toList();
    }

    public Vehiculo definirGanador() {
        Optional<Vehiculo> vehiculoGanador = this.vehiculos.stream().max((v1, v2) -> Double.compare(calcularFactor(v1), calcularFactor(v2)));

        if (vehiculoGanador.isEmpty()) {
            System.out.println("No se encontro un vehiculo ganador.");
        }

        return vehiculoGanador.get();
    }

    private double calcularFactor(Vehiculo vehiculo) {
        return vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }

    public void socorreAuto(String patente) {
        Vehiculo autoASocorrer = this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).toList().getFirst();
        this.socorristaAuto.socorrer((Auto)autoASocorrer);
    }

    public void socorreMoto(String patente) {
        Vehiculo motoASocorrer = this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).toList().getFirst();
        this.socorristaMoto.socorrer((Moto)motoASocorrer);
    }
}
