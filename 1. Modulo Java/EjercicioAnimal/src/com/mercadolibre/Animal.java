package com.mercadolibre;

public abstract class Animal {
    /* Los 3 animales son capaces de “emitir sonidos”,
     para ello será necesario implementar un método que permita mostrar
     por pantalla el sonido que emite cada animal.
     */

    /* A partir de esto, teniendo en cuenta los gustos alimenticios de cada animal
     (gato y perro son considerados carnívoros y la vaca un hervíboro), incluir las interfaces
     necesarias para contemplar los métodos comerCarne o comerHierba.
   */

    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void emitirSonido();

}
