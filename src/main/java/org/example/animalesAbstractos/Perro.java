package org.example.animalesAbstractos;

public class Perro extends Animal implements Carnivoro{
    public void hacerRuido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perro y estoy comiendo carne");
    }
}
