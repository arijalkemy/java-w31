package POO_Integrador;

public class Main {
    public static void main(String[] args) {
        // usando el constructor sin parametros
        Persona personaConValoresPorDefecto = new Persona();
        System.out.println("Persona con valores por defecto: " + personaConValoresPorDefecto.getNombre() + ", Edad: " + personaConValoresPorDefecto.getEdad() + ", DNI: " + personaConValoresPorDefecto.getDni() + ", Peso: " + personaConValoresPorDefecto.getPeso() + ", Altura: " + personaConValoresPorDefecto.getAltura());

        // usando el constructor que recibe algunos parametros
        Persona personaConNombreEdadYdni = new Persona("Manuela Tonelli", 24, "42538617");
        System.out.println("Persona con nombre, edad y DNI: " + personaConNombreEdadYdni.getNombre() + ", Edad: " + personaConNombreEdadYdni.getEdad() + ", DNI: " + personaConNombreEdadYdni.getDni() + ", Peso: " + personaConNombreEdadYdni.getPeso() + ", Altura: " + personaConNombreEdadYdni.getAltura());

        // Usando el constructor que recibe todos los atributos
        Persona personaCompleta = new Persona("Manuela Tonelli", 24, "42538617", 42.0, 1.50);
        System.out.println("Persona completa: " + personaCompleta.getNombre() + ", Edad: " + personaCompleta.getEdad() + ", DNI: " + personaCompleta.getDni() + ", Peso: " + personaCompleta.getPeso() + ", Altura: " + personaCompleta.getAltura());

        // crear un objeto con solo nombre y edad -- esto no es posible con los constructores creados, ya que es obligatorio el envio de los parametros solicitados
        // va a dar un error de compilación
        // Persona personaInvalida = new Persona("Carlos", 28); // esta línea causara un error

        // imprimir información de la persona
        System.out.println("Informacion de la persona:");
        System.out.println(personaCompleta.toString());

        // calcular e imprimir el IMC
        int imcResultado = personaCompleta.calcularIMC();
        String nivelPeso;

        switch (imcResultado) {
            case -1:
                nivelPeso = "Bajo peso (IMC < 20)";
                break;
            case 0:
                nivelPeso = "Peso saludable (20 <= IMC <= 25)";
                break;
            case 1:
                nivelPeso = "Sobrepeso (IMC > 25)";
                break;
            default:
                nivelPeso = "Error en el calculo del IMC";
                break;
        }

        System.out.println("Resultado del IMC: " + nivelPeso);

        // verificar si es mayor de edad
        if (personaCompleta.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad.");
        } else {
            System.out.println("La persona no es mayor de edad.");
        }
    }
}
