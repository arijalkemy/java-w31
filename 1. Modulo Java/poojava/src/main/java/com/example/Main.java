package com.example;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Pedro", 20, "12345678A", 1.80, 61.0);
        Persona persona2 = new Persona("Juan", 30, "12345678A", 1.70, 71.0);
        Persona persona3 = new Persona("Maria", 25, "87654321B", 1.70, 110.4);


        //mostramos personas
        System.out.println("--------Datos de las personas--------");
        mostrarPersona(persona1);
        mostrarPersona(persona2);
        mostrarPersona(persona3);

    }
    public static void mostrarPersona(Persona persona) {
        System.out.println(persona);
        persona.calcularMC();
        System.out.println("--------------------------------");
    }
    
}