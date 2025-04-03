package ClasesAbstractaseInterfaces.P1.Ejercicio2.version1;

/*
 * Se plantea desarrollar un programa que permita mediante una interfaz imprimir 
 * diferentes tipos de documentos.
 * Entre los tipos de documentos se encuentran:
 *  - Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
 *  - Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
 *  - Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
 * 
 * Representar un escenario donde se creen cada uno de estos objetos y que, por
 * medio de un método estático de una interfaz imprimible, se pueda pasar
 * cualquier tipo de documento y sea impreso el contenido. 
 */
public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", "Pérez", new String[]{"Java", "Python", "SQL"});
        Libro libro = new Libro(300, "Gabriel García Márquez", "Cien años de soledad", "Ficción");
        Informe informe = new Informe("Informe de ventas del mes de enero", 10, "Ana López", "Carlos Ruiz");
        curriculum.imprimir();
        libro.imprimir();
        informe.imprimir();
    }
}
