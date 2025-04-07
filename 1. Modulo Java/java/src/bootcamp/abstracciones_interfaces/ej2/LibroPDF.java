package bootcamp.abstracciones_interfaces.ej2;

public class LibroPDF implements Imprimible {
    private String titulo, autor, genero;
    private int cantidadPaginas;

    public LibroPDF(String titulo, String autor, int cantidadPaginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.genero = genero;
    }

    @Override
    public String obtenerContenido() {
        return "Libro: " + titulo + "\nAutor: " + autor + "\nPáginas: " + cantidadPaginas + "\nGénero: " + genero;
    }
}
