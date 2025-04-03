package ClasesAbstractaseInterfaces.Ejercicio2.version1;

// Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
public class Libro implements Imprimible {
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public Libro(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Libro PDF...");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + nombreAutor);
        System.out.println("Género: " + genero);
        System.out.println("Cantidad de Páginas: " + cantidadPaginas);
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }
    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }
    public String getNombreAutor() {
        return nombreAutor;
    }
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

}
