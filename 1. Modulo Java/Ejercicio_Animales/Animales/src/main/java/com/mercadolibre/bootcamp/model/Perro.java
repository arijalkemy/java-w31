package com.mercadolibre.bootcamp.model;

import com.mercadolibre.bootcamp.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void generarSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println( this.getClass().getSimpleName() + " comiendo carne");
    }
}
