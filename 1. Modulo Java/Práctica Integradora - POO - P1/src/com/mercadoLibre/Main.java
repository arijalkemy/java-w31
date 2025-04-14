package com.mercadoLibre;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Jane", 20, "1234");
        Persona persona3 = new Persona("Jane", 22, "1234", 55, 1.65 );

        persona3.imprimirInfoPersona();
        System.out.println(persona3.getNombre() + persona3.esMayorDeEdad());
        persona3.calcularIMC();
        persona3.imprimirInfoPeso();

    }
}
