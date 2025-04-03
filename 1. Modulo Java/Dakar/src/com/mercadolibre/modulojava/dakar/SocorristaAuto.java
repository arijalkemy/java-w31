package com.mercadolibre.modulojava.dakar;

public class SocorristaAuto extends Socorrista <Auto> {


    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo Auto "+ vehiculo.getPatente());
    }


}
