package com.mercadolibre;

public class SocorristaMoto {
    String nombre;

    public SocorristaMoto(String nombre) {
        this.nombre = nombre;
    }

    public void socorrerMoto(Moto moto){
        System.out.println("Estoy socorriendo la moto de patente: " + moto.getPatente() + " . . .");
    }
}
