package ejercicio_dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera{
    Double distancia;
    Double premioEnDolares;
    String nombre;
    Integer cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaDeVehiculos;
    SocorristaAuto socorrista;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }
    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente){
        if(listaDeVehiculos.size() >= cantidadDeVehiculosPermitidos){
            System.out.println("No se permiten mas vehiculos");
        }
        else{
            listaDeVehiculos.add(new Auto(velocidad, aceleracion,anguloDeGiro, patente ));
        }
    }
    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente){
        if(listaDeVehiculos.size() >= cantidadDeVehiculosPermitidos){
            System.out.println("No se permiten mas vehiculos");
        }
        else{
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoPatente(String patente){
        listaDeVehiculos.removeIf(p -> p.patente.equals(patente));
    }
    public List<Vehiculo> getListaDeVehiculos(){
        return listaDeVehiculos;
    }

    public Vehiculo getGanador(){
        return listaDeVehiculos.stream().max(Comparator.comparingDouble(v -> v.getVelocidad() * 0.5 * v.getAceleracion()
                / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100)))).orElse(null);
    }


}
