package org.example.models;

public interface ICarnivoro {
    default void comerCarne(){
        System.out.println("Estoy comiendo carne!!!");
    }
}
