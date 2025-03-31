package org.example.ejercicio1OOP;

// Esto es el main que pide el ejercicio
public class Ejercicio3 {

    public Ejercicio3() {
    }

    public void ejecutar() {
        Persona personaVacia = new Persona();
        Persona personaAMedias = new Persona("Carlos", "Ramirez", 45, "23456789");
        Persona personaFull = new Persona("Carlos", "Ramirez", 45, "23456789", 78.0F, 1.81F);

        int resultadoIMC = personaFull.calcularIMC();
        if (resultadoIMC == -1) {
            System.out.println("Bajo peso");
        } else if (resultadoIMC == 0) {
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }

        if (personaFull.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona es menor de edad");
        }

        System.out.println(personaFull);
    }
}
