package P1.Ejercicio5y6;

/*
 * Desde la clase Main vamos a calcular el IMC de la última persona que creamos
 * (la que creamos correctamente mediante el constructor que recibe todos los
 * atributos como parámetro). También vamos a averiguar si es mayor de edad o no;
 * ten en cuenta que en ambos casos, dependiendo de los resultados retornados por
 * los métodos, debes imprimir un mensaje acorde para el usuario. Finalmente
 * queremos mostrar todos los datos de esa persona imprimiendo dicha información
 * por consola. El formato en que vas a mostrar los datos y los mensajes quedan a
 * tu criterio, pero debe ser legible y descriptivo para quien ve la salida del
 * programa.
 */
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 30, "87654321", 70.5, 1.75);
        System.out.println(persona.toString());
        int imcResult = persona.calcularIMC();
        if (imcResult == -1) {
            System.out.println("Bajo peso.");
        } else if (imcResult == 0) {
            System.out.println("Peso saludable.");
        } else {
            System.out.println("Sobrepeso.");
        }
        System.out.println("Mayor de edad: " + persona.esMayorDeEdad());
    }
}
