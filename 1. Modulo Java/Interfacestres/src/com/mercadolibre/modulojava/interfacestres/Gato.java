package com.mercadolibre.modulojava.interfacestres;

public class Gato extends Animal implements IComerCarne {

    @Override
    public void hacersonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne");
    }
}
