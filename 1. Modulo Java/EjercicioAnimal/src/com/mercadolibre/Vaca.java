package com.mercadolibre;

public class Vaca extends Animal implements ComibleHerbivoro{
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }


    @Override
    public void comerHierba() {
        System.out.println("La vaca " + this.getNombre() + " está comiendo hierba . . .");
    }
}
