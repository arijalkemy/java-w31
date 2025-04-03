package com.mercadolibre.bootcamp.model;

public class SocorristaAuto implements Socorrista<Auto> {

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo Auto " + vehiculo.getPatente());
    }
}
