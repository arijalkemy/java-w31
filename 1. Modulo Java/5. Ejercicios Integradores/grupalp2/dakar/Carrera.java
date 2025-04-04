package dakar;

import java.util.HashSet;
import java.util.Set;

public class Carrera {

    private int distanciaEnKm;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private Set<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(int distanciaEnKm, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distanciaEnKm = distanciaEnKm;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new HashSet<>();
        this.socorristaAuto = new SocorristaAuto(150, 10, 5, "SOCORRISTA_AUTO_1");
        this.socorristaMoto = new SocorristaMoto(120, 8, 3, "SOCORRISTA_MOTO_1");
    }

    public int getDistanciaEnKm() {
        return distanciaEnKm;
    }

    public void setDistanciaEnKm(int distanciaEnKm) {
        this.distanciaEnKm = distanciaEnKm;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
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

    public Set<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(Set<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(Auto auto) {
        ejecutarSiHayCupo(() -> {
            listaDeVehiculos.add(auto);
        });
    }

    public void darDeAltaMoto(Moto moto) {
        ejecutarSiHayCupo(() -> {
            listaDeVehiculos.add(moto);
        });
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (listaDeVehiculos.contains(vehiculo)) {
            listaDeVehiculos.remove(vehiculo);
        } else {
            System.out.println("El vehículo no está en la carrera.");
        }
    }

    public void eliminarVehiculoConPatente(String patente) {
        boolean eliminado = listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
        if (!eliminado) {
            System.out.println("No se encontró el vehículo con la patente " + patente);
        }
    }

    public Vehiculo ganadorDeLaCarrera() {
        return listaDeVehiculos.stream()
                .max((v1, v2) -> Double.compare(calcularVentaja(v1), calcularVentaja(v2)))
                .orElseGet(() -> {
                    System.out.println("No hay vehículos en la carrera.");
                    return null;
                });
    }

    public void socorrerAuto(String patente) {
        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);
        if (vehiculo != null && vehiculo instanceof Auto) {
            socorristaAuto.socorrer((Auto) vehiculo);
        } else {
            System.out.println("El vehículo no es un auto o no está en la carrera.");
        }
    }

    public void socorrerMoto(String patente) {
        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);
        if (vehiculo != null && vehiculo instanceof Moto) {
            socorristaMoto.socorrer((Moto) vehiculo);
        } else {
            System.out.println("El vehículo no es una moto o no está en la carrera.");
        }

    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    private double calcularVentaja(Vehiculo vehiculo) {
        return (vehiculo.getVelocidad() * (vehiculo.getAceleracion() * 0.5)) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPesoEnKg() - vehiculo.getCantidadDeRuedas() * 100));
    }

    private void ejecutarSiHayCupo(Runnable callback) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            callback.run();
        } else {
            System.out.println("No se pueden agregar más vehículos a la carrera.");
        }
    }

    private Vehiculo buscarVehiculoPorPatente(String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                return vehiculo;
            }
        }
        return null;
    }

}
