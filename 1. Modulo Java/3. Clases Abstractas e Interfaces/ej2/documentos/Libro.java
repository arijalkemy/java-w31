package documentos;

public class Libro implements Documento {
    private String titulo;
    private String autor;
    private String isbn;
    private int anioPublicacion;

    public Libro(String titulo, String autor, String isbn, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public void imprimirEnConsola() {
        System.out.println("Libro:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Año de Publicación: " + anioPublicacion);
    }
    
}
