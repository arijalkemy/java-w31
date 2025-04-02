package clase.POO.tres.ejercicio2.Documentos;

public class LibroPDF implements Documento {
    private int numeroPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(int numeroPaginas, String nombreAutor, String titulo, String genero) {
        this.numeroPaginas = numeroPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public void imprimir() {
        System.out.println("\nImprimiendo libro PDF");
        System.out.println("Numero de paginas: " + numeroPaginas + "\nNombre del autor: " + nombreAutor + "\nTitulo: " + titulo + "\nGenero: " + genero + "\n");
    }
}
