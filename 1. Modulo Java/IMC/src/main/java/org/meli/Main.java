package org.meli;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona2 = new Persona("Juan", 23, "123456789");
        Persona persona3 = new Persona("Angel", 27, "987654321", 56, 178);

        System.out.println("Datos de la persona: ");
        System.out.println(persona3.toString());
        System.out.println();

        int imc = persona3.calcularIMC();
        String nivelDePeso = "";
        if (imc == -1) {
            nivelDePeso = "Bajo peso";
        } else if (imc == 0) {
            nivelDePeso = "Peso saludable";
        } else if (imc == 1) {
            nivelDePeso = "Sobrepeso";
        }

        System.out.println("Según el Índice de masa corporal (IMC)");
        System.out.println("El nivel de peso de la persona es: " + nivelDePeso);
        System.out.println();

        boolean esMayorDeEdad = persona3.esMayorDeEdad();
        String mayorDeEdad = "";
        if (esMayorDeEdad) {
            mayorDeEdad = "Si";
        } else {
            mayorDeEdad = "No";
        }
        System.out.println("La persona es mayor de edad: " + mayorDeEdad);


    }
}