package partedos.modelos;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if(vehiculos.size() < cantidadVehiculosPermitidos){
            vehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if(vehiculos.size() < cantidadVehiculosPermitidos){
            vehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public Vehiculo definirGanador() {
        double maxValor = Double.NEGATIVE_INFINITY;
        Vehiculo ganador = null;
        for (Vehiculo vehiculo : vehiculos) {
            double valor = vehiculo.getVelocidad() * (0.5 * vehiculo.getAceleracion()) / (vehiculo.getAnguloGiro() * (vehiculo.getPeso() - (vehiculo.getRuedas() * 100)));
            if (valor > maxValor) {
                maxValor = valor;
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente) {
        vehiculos.stream()
                .filter(v -> v instanceof Auto && v.getPatente().equals(patente))
                .forEach(v -> socorristaAuto.socorrer((Auto)v));
    }

    public void socorrerMoto(String patente) {
        vehiculos.stream()
                .filter(v -> v instanceof Moto && v.getPatente().equals(patente))
                .forEach(v -> socorristaMoto.socorrer((Moto) v));
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(double premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
