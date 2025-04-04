package org.example.models;

public class Gato extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido(){
        System.out.println("Miau!");
    }
}
