package com.meli.ejercicioanimal.clases;

import com.meli.ejercicioanimal.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }
}
