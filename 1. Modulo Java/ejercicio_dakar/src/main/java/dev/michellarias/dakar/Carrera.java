package dev.michellarias.dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloGiro, String patente){
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
        }else {
            System.out.println("Cupo Completo, no se pueden agregar mas Vehiculos");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloGiro, String patente){
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
        }else {
            System.out.println("Cupo Completo, no se pueden agregar mas Vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        boolean isDeleted = listaVehiculos
                .removeIf(v -> v.getPatente().equals(unaPatente));
        if (isDeleted) System.out.println("Eliminado Correctamente");
    }

    public void socorrerAuto(String patente){
        Auto auto = buscarVehiculoPorPatente(patente);
        getSocorristaAuto().socorrer(auto);
    }

    public void socorrerMoto(String patente){
        Moto moto =  buscarVehiculoPorPatente(patente);
        getSocorristaMoto().socorrer(moto);
    }

    public <T extends Vehiculo> T buscarVehiculoPorPatente(String patente){
        Optional<Vehiculo> vehiculo =  listaVehiculos
                .stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst();

        if (vehiculo.isEmpty()){
            throw new RuntimeException("Vehiculo no existe");
        }

        return (T) vehiculo.get();
    }

    public void calcularGanador(){
        Optional<Vehiculo> ganadorOpt =  listaVehiculos
                .stream()
                .max(Comparator.comparing(Vehiculo::getStats));

        if (ganadorOpt.isEmpty()){
            System.out.println("NO HAY GANADOR");
            return;
        }

        Vehiculo ganador = ganadorOpt.get();
        System.out.printf("GANADOR %s CON VELOCIDAD DE: %s\n", ganador.getPatente(), ganador.getVelocidad());
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
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
}
