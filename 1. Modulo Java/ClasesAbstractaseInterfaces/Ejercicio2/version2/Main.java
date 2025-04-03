package ClasesAbstractaseInterfaces.P1.Ejercicio2.version2;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", "Pérez", new String[]{"Java", "Python", "SQL"});
        Libro libro = new Libro(300, "Gabriel García Márquez", "Cien años de soledad", "Ficción");
        Informe informe = new Informe("Informe de ventas del mes de enero", 10, "Ana López", "Carlos Ruiz");
        Imprimible.imprimir(curriculum);
        Imprimible.imprimir(libro);
        Imprimible.imprimir(informe);
    }
}
