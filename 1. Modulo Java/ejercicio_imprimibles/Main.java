package ejercicio_imprimibles;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear un libro
        Libro libro = new Libro(300, "Gabriel Garcia Marquez", "Cien años de soledad", "Ficción");
        // Crear un informe
        Informe informe = new Informe("Informe de ventas", 10, "Juan Perez", "Maria Lopez");
        // Crear un CV
        Persona persona = new Persona("Juan", "Pérez", "31111111", "juan.perez@mail.com", "Desarrollador");
        CV cv = new CV(persona, new ArrayList<String>(Arrays.asList("Java", "Python")));

        // Imprimir los objetos
        Imprimible.imprimir(libro);
        Imprimible.imprimir(informe);
        Imprimible.imprimir(cv);
    }
}
