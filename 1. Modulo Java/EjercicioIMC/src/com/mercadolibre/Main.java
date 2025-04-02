package com.mercadolibre;

public class Main {
    public static void main (String []args){
        Persona persona = new Persona();
        Persona persona2 = new Persona("Ornella", 22, "44847330");
        Persona persona3 = new Persona("Raul", "283749583", 45, 70.0, 1.70);
        System.out.println(persona3);

    }
}
