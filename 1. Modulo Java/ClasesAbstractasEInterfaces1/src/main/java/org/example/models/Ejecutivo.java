package org.example.models;

public class Ejecutivo extends Cliente{
    public Ejecutivo(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public void deposito(){
        System.out.println("Realicé un deposito.");
    }

    public void transferencia(){
        System.out.println("Realicé una transferencia.");
    }

}
