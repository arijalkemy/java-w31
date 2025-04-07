package com.mercadolibre;
import com.mercadolibre.model.Persona;
import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaAlgunosParametros = new Persona("Lautaro", 21, "72187379812");
        Persona personaCompleta = new Persona("Jhon", 29, "9382578237",90.0, 1.9);

        //Esto no es posible
        //Persona personaImposible = new Persona("Jose", 30);

        int imc = personaCompleta.calcularIMC();
        boolean mayorDeEdad = personaCompleta.esMayorDeEdad();
        String mensajeEdad = mayorDeEdad? "es menor de edad" : "es mayor de Edad";

        switch (imc) {
            case -1:
                System.out.println(personaCompleta.getNombre()+ " tiene un bajo peso y " + mensajeEdad);
                break;
            case 0:
                System.out.println(personaCompleta.getNombre()+ " tiene un peso saludable y " + mensajeEdad);
                break;
            case 1:
                System.out.println(personaCompleta.getNombre()+ " tiene sobrepeso y " + mensajeEdad);
                break;
        }


    }
}
