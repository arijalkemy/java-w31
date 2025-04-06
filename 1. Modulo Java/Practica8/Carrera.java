package Practica8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private double distancia;
    private float premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;



    public Carrera(double distancia, float premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = new SocorristaAuto(200,1000,90,"AAAAAF");
        this.socorristaMoto = new SocorristaMoto(200,1000,90,"AAFFFF");
        vehiculos = new ArrayList<>();

    }


    public void socorrerAuto(String patente){
        for (Vehiculo vehiculo : this.vehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
                return;
            }
        }

    }

    public void socorrerMoto(String patente){
        for (Vehiculo vehiculo : this.vehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) vehiculo);
                return;
            }
        }
    }


    public void socorreAuto(String patente) {
        Vehiculo autoASocorrer = this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).toList().getFirst();
        this.socorristaAuto.socorrer((Auto)autoASocorrer);
    }

    public void socorreMoto(String patente) {
        Vehiculo motoASocorrer = this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).toList().getFirst();
        this.socorristaMoto.socorrer((Moto)motoASocorrer);
    }


    public void darDeAltaAuto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){

        if(permiteNuevosVehiculos()){
            vehiculos.add(new Auto(velocidad, aceleracion, AnguloDeGiro, patente));
        }
        else{
            System.out.println("no se puede agregar a la lista llena");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if(permiteNuevosVehiculos()){
            vehiculos.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente));
        } else{
            System.out.println("no se puede agregar a la lista llena");
        }
    }

    private boolean permiteNuevosVehiculos(){
        return this.vehiculos.size()+1 < cantidadDeVehiculosPermitidos;
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for (Vehiculo vehiculo : this.vehiculos) {
            if (vehiculo.getPatente().equals(unaPatente)) {
                vehiculos.remove(vehiculo);
                return;
            }
        }
    };

    public Vehiculo calcularGanador(){
        Optional<Vehiculo> vehiculoOpt =  vehiculos.stream().max( (v1, v2)  -> Double.compare( calcularFactor(v1)  , calcularFactor(v2)  )  );
        Vehiculo vehiculo = vehiculoOpt.get();
        return vehiculo;
    }

    private static double calcularFactor(Vehiculo vehiculo) {
        // Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)

        return vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleración() /
                (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public float getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(float premioEnDolares) {
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
