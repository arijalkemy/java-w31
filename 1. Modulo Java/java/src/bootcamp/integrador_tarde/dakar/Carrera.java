package bootcamp.integrador_tarde.dakar;

import java.util.List;

public class Carrera {
    private double distancia, premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;
    private List<Vehiculo> listaVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
        this.listaVehiculos = listaVehiculos;
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

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }
    // En vez de crear un metodo para moto y auto, creamos el objeto del vehiculo
    public void darDeAlta(Vehiculo vehiculo) {
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaVehiculos.add(vehiculo);
        } else {
            System.out.println("No se puede agregar más vehículos a la carrera.");
        }
    }
    public void darDeBaja(Vehiculo vehiculo) {
        if (listaVehiculos.contains(vehiculo)) {
            listaVehiculos.remove(vehiculo);
        } else {
            System.out.println("El vehículo no está en la lista.");
        }
    }
    public void darDeBajaConPatente(String patente) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                listaVehiculos.remove(vehiculo);
                return;
            }
        }
        System.out.println("El vehículo con patente " + patente + " no está en la lista.");
    }
    public Vehiculo ganador() {
        return this.listaVehiculos.stream()
                .max((vehiculo1, vehiculo2) -> {
                    double v1 = vehiculo1.getVelocidad() * 0.5 * vehiculo1.getAceleracion() /
                            (vehiculo1.getAnguloDeGiro() * (vehiculo1.getPeso() - vehiculo1.getRuedas() * 100));
                    double v2 = vehiculo2.getVelocidad() * 0.5 * vehiculo2.getAceleracion() /
                            (vehiculo2.getAnguloDeGiro() * (vehiculo2.getPeso() - vehiculo2.getRuedas() * 100));
                    return Double.compare(v1, v2);
                }).orElse(null);
    }

    public void socorrerAuto(Auto auto) {
        socorristaAuto.socorrer(auto);
    }
    public void socorrerMoto(Moto moto) {
        socorristaMoto.socorrer(moto);
    }

}
