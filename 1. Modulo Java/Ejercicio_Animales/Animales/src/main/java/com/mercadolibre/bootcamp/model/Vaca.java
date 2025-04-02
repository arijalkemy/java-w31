package com.mercadolibre.bootcamp.model;

import com.mercadolibre.bootcamp.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {

    @Override
    public void generarSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println(this.getClass().getSimpleName() + " comiendo hierba");
    }
}
