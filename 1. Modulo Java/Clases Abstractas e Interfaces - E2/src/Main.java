import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        List<String> habilidades = Arrays.asList("Programación", "Inglés");
        Persona persona = new Persona("Jane", "Doe", "Córdoba", habilidades);

        Libro libro = new Libro("Homo Irrealis", "André Aciman", "No Ficción", 256);

        Informe informe = new Informe("Lorem ipsum.", 5, "Jane Doe", "John Doe");

        do {
            System.out.println("Imprimibles");
            System.out.println("1. Curriculum");
            System.out.println("2. Libro");
            System.out.println("3. Informe");
            System.out.println("4. Salir");
            System.out.print("Elegir una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Imprimir.imprimir(persona);
                    break;
                case 2:
                    Imprimir.imprimir(libro);
                    break;
                case 3:
                    Imprimir.imprimir(informe);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}