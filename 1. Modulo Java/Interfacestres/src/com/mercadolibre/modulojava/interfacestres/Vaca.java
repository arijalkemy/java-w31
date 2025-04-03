package com.mercadolibre.modulojava.interfacestres;

public class Vaca extends Animal implements IComerHierba{

    @Override
    public void hacersonido() {
        System.out.println("muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("comiendo hierba");

    }
}
