package com.mercadolibre.modulojava.dakar;

public class SocorristaMoto extends Socorrista <Moto>{

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo Moto "+ vehiculo.getPatente());
    }
}
