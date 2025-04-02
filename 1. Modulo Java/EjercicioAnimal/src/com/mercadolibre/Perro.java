package com.mercadolibre;

public class Perro extends Animal implements ComibleCarnivoro{
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }



    @Override
    public void comerCarne() {
        System.out.println("El perro " + this.getNombre() + " está comiendo carne . . .");
    }
}
