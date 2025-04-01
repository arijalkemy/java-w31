package imprimibles;

public class Libro implements Imprimible {
    private final String titulo;
    private final String autor;
    private final int numPaginas;
    private final String genero;

    public Libro(String titulo, String autor, int numPaginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.genero = genero;
    }

    public void imprimir() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("NumPaginas: " + numPaginas);
        System.out.println("Genero: " + genero);
    }

}
