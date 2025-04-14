public class Libro implements Imprimir{
    private String titulo;
    private String autor;
    private String genero;
    private int cantidadPaginas;

    public Libro(String nombre, String autor, String genero, int cantidadDePaginas) {
        this.titulo = nombre;
        this.autor = autor;
        this.genero = genero;
        this.cantidadPaginas = cantidadDePaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public String toString() {
        return "Nombre: " + titulo +
                "\nAutor: " + autor +
                "\nGenero: " + genero +
                "\nCantidad de Paginas: " + cantidadPaginas;
    }


    @Override
    public void imprimirContenido() {
        System.out.println("Libro");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Cantidad de páginas: " + cantidadPaginas);
        System.out.println("Género: " + genero);
    }
}
