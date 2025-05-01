public class LibroPdf implements Imprimir{
    private String titulo;
    private String autor;
    private int cantidadPaginas;
    private String genero;

    public LibroPdf(String titulo, String autor, int cantidadPaginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro: " + titulo + " | Autor: " + autor);
        System.out.println("Género: " + genero + " | Páginas: " + cantidadPaginas);
    }
}
