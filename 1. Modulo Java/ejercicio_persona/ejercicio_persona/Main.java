package ejercicio_persona;

public class Main {
    public static void main(String[] args) {
        Persona personaSinParametros = new Persona();
        Persona personaConTresParametros = new Persona("Juan", 25, "12345678A");
        Persona personaConCincoParametros = new Persona("Ana", 30, "87654321B", 70, 1.70);
        // Persona personaConDosParametros = new Persona("Andrés", 40);

        double imc = personaConCincoParametros.calcularIMC();
        Boolean esMayorDeEdad = personaConCincoParametros.esMayorDeEdad();

        System.out.println(personaConCincoParametros.toString());

        if (esMayorDeEdad) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("No es mayor de edad");
        }

        System.out.println("IMC: ");
        if (imc == -1) {
            System.out.println("Bajo peso");
        } else if (imc == 0) {
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }

    }
}
