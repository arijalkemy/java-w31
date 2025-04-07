class LibroPDF implements Imprimible {
    private String autor;
    private String titulo;
    private String genero;
    private int cantidadPaginas;

    public LibroPDF(String autor, String titulo, String genero, int cantidadPaginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public String toString() {
        return "Libro: " + titulo + " por " + autor + ", Género: " + genero + ", Páginas: " + cantidadPaginas;
    }
}
