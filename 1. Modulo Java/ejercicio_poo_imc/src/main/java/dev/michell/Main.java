package dev.michell;

public class Main {
    public static void main(String[] args) {

        Persona michell = new Persona("Michell", 25, "12312312", 95, 1.81);
        boolean esMayorDeEdad = michell.esMayorDeEdad();
        double imc = michell.calcularImc();


        System.out.println(michell);

        System.out.println("=====================================");
        System.out.println("          INFORMACION DE IMC         ");
        System.out.println("=====================================");

        if (imc == -1) {
            System.out.println("Bajo de Peso");
        }else if (imc == 0) {
            System.out.println("Peso Saludable");
        }else {
            System.out.println("Sobre Peso");
        }

        if (esMayorDeEdad) {
            System.out.printf("%s es mayor de edad\n", michell.getNombre());
        }else {
            System.out.printf("%s es menor de edad\n", michell.getNombre());
        }

    }
}
