package org.example.animalesAbstractos;

public class Vaca extends Animal implements Herbivoro{
    public void hacerRuido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca y estoy comiendo pasto");
    }
}
