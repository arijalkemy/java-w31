package org.example.models;

public class Cobrador extends Cliente implements BasicoCobrador {
    public Cobrador(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void retiroEfectivo(){
        System.out.println("Retiro efectivo.");
    }

    @Override
    public void consultaSaldo(){
        System.out.println("Consulta saldo.");
    }
}
