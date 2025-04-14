package clasesAbstractasEInterfaces.ejercicio2;

public class LibroPDF implements IImprimible {
    private String titulo;
    private String autor;
    private int cantidadDePaginas;
    private String genero;

    public LibroPDF(String autor, int cantidadDePaginas, String genero, String titulo) {
        this.autor = autor;
        this.cantidadDePaginas = cantidadDePaginas;
        this.genero = genero;
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + titulo + " - Autor: " + autor + " - Cant. de pág.: " + cantidadDePaginas + " - Genero: " + genero);
    }
}
