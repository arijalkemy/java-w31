package com.mercadolibre.bootcamp.model;

public class NoPerecedero extends Producto{

    private String tipo;

    public NoPerecedero(String name, Double precio, String tipo){
        super(tipo, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "NoPerecedero{" +
                "nombre='" + super.getNombre() + '\'' +
                ", precio='" + super.getPrecio() + '\'' +
                ", tipo='" + tipo;
    } 

    
    
}
