package org.example;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Luz Vargas", 47, "52475777");
        Persona persona3 = new Persona("Johan Lopez", 27, "52475777", 70.0, 1.7);

        System.out.println(persona3.toString());
    }
}