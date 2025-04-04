//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("David", 26, "1036683986", 80.0, 1.80);
        Persona persona2 = new Persona("Laura", 25, "1034323567");

        Persona persona3 = new Persona();

        // Persona persona4 = new Persona("Juan", 20); No se puede crear un Objeto que acepte estos dos parametros
        // Porque no existe un constructor que acepte unicamente 2 paremetros

        System.out.println(persona1.toString());

        System.out.println("\n¿" + persona1.getNombre() + " es mayor de edad?");

        if (persona1.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }

        System.out.println("\nNivel de Peso de " + persona1.getNombre());
        if (persona1.calcularMC() == -1) {
            System.out.println("Bajo de peso");
        } else if (persona1.calcularMC() == 0) {
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }

    }
}