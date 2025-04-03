package com.meli.ejercicioanimal.clases;

import com.meli.ejercicioanimal.interfaces.Hervivoro;

public class Vaca extends Animal implements Hervivoro {
    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public void emitirSonido() {
        System.out.println("Mu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comer hierba");
    }
}
