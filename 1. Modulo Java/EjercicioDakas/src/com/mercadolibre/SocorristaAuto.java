package com.mercadolibre;

public class SocorristaAuto {
    String nombre;

    public SocorristaAuto(String nombre) {
        this.nombre = nombre;
    }

    public void socorrerAuto(Auto auto){
    System.out.println("Estoy socorriendo el auto de patente" + auto.getPatente() + " . . .");
    }
}
