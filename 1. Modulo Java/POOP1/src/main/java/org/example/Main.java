package org.example;

import org.example.models.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan",22,"1221");
        Persona persona3 = new Persona("Juan",22,"1221",87.5f,1.65f);
        System.out.println(persona3);
        persona3.calcularIMC();
        persona3.esMayorDeEdad();
    }
}