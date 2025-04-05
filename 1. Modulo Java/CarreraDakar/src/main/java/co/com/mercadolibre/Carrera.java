package co.com.mercadolibre;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import co.com.mercadolibre.socorristas.SocorristaAuto;
import co.com.mercadolibre.socorristas.SocorristaMoto;

public class Carrera {

    private double distancia, premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera() {
        this.vehiculos = new ArrayList<>();
    }

    public Carrera(double distancia, double premioEnDolares, String nombre,
                   int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
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

    public void darDeAltaMoto(double velocidad, double aceleracion,
                              double anguloDeGiro, String patente){
        if (vehiculos.size() <= cantidadDeVehiculosPermitidos){
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente ));
        }else {
            System.out.println("No se permiten más vehiculos");
        }

    }

    public void darDeAltaAuto(double velocidad, double aceleracion,
                              double anguloDeGiro, String patente){
        if (vehiculos.size() <= cantidadDeVehiculosPermitidos){
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente ));
        }else {
            System.out.println("No se permiten más vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        boolean isRemoved = vehiculos.removeIf(v -> v.equals(vehiculo));
        if (isRemoved){
            System.out.println("El vehiculo eliminado es: " + vehiculo.toString() );
        }else {
            System.out.println("El vehículo: " + vehiculo + " Ya ha sido eliminado");
        }
    } 

    public double calcularGanador(Vehiculo vehiculo){
        return vehiculo.getVelocidad() * 0.5 + vehiculo.getAceleracion()/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100)); 
    }

    public Vehiculo ganadorDeLaCarrera(){
        return this.vehiculos.stream().max(Comparator.comparing(this::calcularGanador))
        .orElseThrow(null);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        boolean isRemoved = vehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
        String message = isRemoved
                ? "El vehículo con patente: " + unaPatente + " ha sido eliminado"
                : "El vehículo con patente: " + unaPatente + " no existe en los registros";
        System.out.println(message);
    }

    public void socorrerAuto(String patente){
        Vehiculo vehiculoEncontradoPorPatente = vehiculos.
        stream().filter(v -> v.getPatente().equals(patente))
        .findFirst().orElseThrow();
        String mensaje = (vehiculoEncontradoPorPatente instanceof Auto)
        ? "Socorriendo auto con patente: " + patente
        : "No se puede socorrer el auto con patente: " + patente
          + " ya que no corresponde a nuestro tipo de vehiculo";
        System.out.println(mensaje);
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculoEncontradoPorPatente = vehiculos.
        stream().filter(v -> v.getPatente().equals(patente))
        .findFirst().orElseThrow();
        String mensaje = (vehiculoEncontradoPorPatente instanceof Moto)
        ? "Socorriendo Moto con patente: " + patente
        : "No se puede socorrer el auto con patente: " + patente
          + " ya que no corresponde a nuestro tipo de vehiculo";
        System.out.println(mensaje);
    }


    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
