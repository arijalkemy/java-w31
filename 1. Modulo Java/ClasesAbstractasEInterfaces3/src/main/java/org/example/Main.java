package org.example;

import org.example.models.*;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        gato.emitirSonido();
        Perro perro = new Perro();
        perro.emitirSonido();
        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        comerAnimal(vaca);
        comerAnimal(perro);
    }

    public static void comerAnimal(ICarnivoro animal){
        animal.comerCarne();
    }

    public static void comerAnimal(IHerviboro animal){
        animal.comerHierba();
    }
}