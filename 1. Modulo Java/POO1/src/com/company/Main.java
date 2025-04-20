package com.company;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Florencia", 27, "40029082");
        Persona persona3 = new Persona("Florencia", 27, "40029082", 56, 1.63 );
        //Persona persona4 = new Persona("Florencia", 27); No funciona porque no hay un constructor que tenga solo esos argumentos.

        System.out.println("El IMC de " + persona3.getNombre() + " es: " + persona3.calcularIMC());

        switch (persona3.calcularIMC()){
            case -1:
                System.out.println("El indice de masa corporal indica bajo peso.");
                break;
            case 0:
                System.out.println("El indice de masa corporal indica peso saludable.");
                break;
            case 1:
                System.out.println("El indice de masa corporal indica sobrepeso.");
                break;
        }


        System.out.println(persona3.esMayorDeEdad());

        System.out.println(persona3.toString());


    }
}
