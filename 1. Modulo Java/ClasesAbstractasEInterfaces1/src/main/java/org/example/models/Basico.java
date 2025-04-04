package org.example.models;

public class Basico extends Cliente implements BasicoCobrador{

    public Basico(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void consultaSaldo(){
        System.out.println("Consulta saldo.");
    }

    public void pagoServicios(){
        System.out.println("Pago de servicios.");
    }

    @Override
    public void retiroEfectivo(){
        System.out.println("Retirar efectivo.");
    }
}
