package com.mercadolibre.modulojava.interfacestres;

public class Perro extends Animal implements IComerCarne{

    @Override
    public void hacersonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne");
    }
}
