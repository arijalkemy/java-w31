package org.meli.practicaIntegradoraPooP1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Persona persona1 = new Persona(); // sin parametros
        Persona persona2 = new Persona("Jhon", 22, 70, // todos los parametros
                180, "jhon2025"); // to be calculated
        Persona persona3 = new Persona("Jhon", 30, "jhon2026");
        Persona persona4 = new Persona();
        persona4.setNombre("Jhon");
        persona4.setEdad(25);

        System.out.println("Los datos de la persona son: "
        + persona2.toString()
        + "\nSu IMC es: " + persona2.calcularIMC() +  " Y su edad es: "
                + persona2.esMayorDeEdad());

    }
}

