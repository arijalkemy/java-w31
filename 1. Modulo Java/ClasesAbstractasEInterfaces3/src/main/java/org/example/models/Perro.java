package org.example.models;

public class Perro extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido(){
        System.out.println("Guau!!!");
    }
}
