package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Carrera{
    private Double distancia, precioEnDolar;
    private Integer cantidadVehiculosPermitidos;
    private String nombre;
    private List<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;
    private Integer cantidadPermitido;

    public void darDeAltaAuto(Integer velocidad,Integer aceleracion,Integer anguloDeGiro,String patente){
        Vehiculo auto = new Auto();
        auto.setVelocidad(velocidad);
        auto.setAceleracion(aceleracion);
        auto.setPatente(patente);
        auto.setAnguloDeGiro(anguloDeGiro);
        listaVehiculos.add(auto);
        this.cantidadPermitido = 0;
    }

    public void darDeAltaMoto(Integer velocidad,Integer aceleracion,Integer anguloDeGiro,String patente){
        if(cantidadPermitido<=10){
            Vehiculo moto = new Moto();
            moto.setVelocidad(velocidad);
            moto.setAceleracion(aceleracion);
            moto.setPatente(patente);
            moto.setAnguloDeGiro(anguloDeGiro);
            listaVehiculos.add(moto);
            cantidadPermitido++;
        }
        else{
            System.out.println("No se puede admitir más corredores");
        }
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        listaVehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(final String unaPatente){
        listaVehiculos.removeIf(v-> v.getPatente().equals(unaPatente));
    }

    public void getGanador() {
        System.out.println("El ganador: ");
        Double ganador = 0D;
        String patente = "";

        for(Vehiculo v: listaVehiculos){
            Double formula = v.getVelocidad() * (v.getAceleracion()/2) / (v.getAnguloDeGiro()*(v.getPeso()-
                    v.getRuedas()*100));

            if (formula>ganador){
                ganador = formula;
                patente = v.getPatente();
            }
        }
        System.out.println("Patente: "+patente + "Con un valor de: "+ ganador);
    }

    public void socorrerAuto(Auto unAuto){
        SocorristaAuto.socorrer(unAuto);
    }
    public void socorrerMoto(Moto unaMoto){
        SocorristaMoto.socorrer(unaMoto);
    }
}
