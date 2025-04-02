package com.mercadolibre.bootcamp.model;

import com.mercadolibre.bootcamp.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void generarSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println( this.getClass().getSimpleName() + " comiendo carne");
    }
}
