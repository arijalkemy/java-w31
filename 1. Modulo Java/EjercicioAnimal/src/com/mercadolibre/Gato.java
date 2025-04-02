package com.mercadolibre;

public class Gato extends Animal implements ComibleCarnivoro{
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato " + this.getNombre() + " está comiendo carne . . .");
    }
}
