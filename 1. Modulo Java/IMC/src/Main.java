

public class Main {
    public static void main (String [] args){

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Abril", 21, "45322541");
        Persona persona3 = new Persona("Gemma", 20, "45172689", 155.3, 1.58);

        System.out.println(persona3.toString());
        int imcResultado = persona3.calcularIMC();
        System.out.print("Estado segun IMC: ");
        if (imcResultado == -1) {
            System.out.println("Bajo peso");
        } else if (imcResultado == 0) {
            System.out.println("Peso saludable ");
        } else {
            System.out.println("Sobrepeso");
        }

        if (persona3.esMayorDeEdad()) {
            System.out.println( persona3.nombre + " es mayor de edad.");
        } else {
            System.out.println(persona3.nombre + " es menor de edad.");
        }
    }
    }

