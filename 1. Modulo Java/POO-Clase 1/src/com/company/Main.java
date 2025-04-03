package com.company;

public class Main {

    public static void main(String[] args) {
        // Creamos objetos Personas
        Persona p1 = new Persona();
        Persona p2 = new Persona("Jose",33,"35.768.819");
        Persona p3 = new Persona("Miguel",30,"38.220.103",61.5,1.75);

        //Calculamos el IMC de la ultima persona creada y mostramos
        System.out.println(p3.calcularIMC());

        //Verificamos si es mayor de edad y mostramos
        System.out.println(p3.esMayorDeEdad());

        //Mostramos información y mostramos
        System.out.println(p3.toString());
    }
}
