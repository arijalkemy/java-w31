package ejercicio_dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDegiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDegiro, patente);
            listaDeVehiculos.add(auto);
        } else {
            System.out.println("No se pueden agregar más vehículos a la carrera.");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDegiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDegiro, patente);
            listaDeVehiculos.add(moto);
        } else {
            System.out.println("No se pueden agregar más vehículos a la carrera.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (listaDeVehiculos.contains(vehiculo)) {
            listaDeVehiculos.remove(vehiculo);
        } else {
            System.out.println("El vehículo no está en la lista.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public Vehiculo getGanador() {
        return listaDeVehiculos.stream().max((x, y) -> x.calcularFormula().compareTo(y.calcularFormula())).get();
    }

    public void socorrerAuto(String patente) {
        socorristaAuto.socorrer(
                (Auto) listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst()
                        .get());
    }

    public void socorrerMoto(String patente) {
        socorristaMoto.socorrer(
                (Moto) listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst()
                        .get());
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

}
