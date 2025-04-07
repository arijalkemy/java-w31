public class PDF extends Documento{
    private int cantidadDePaginas;
    private String autor;
    private String nombreLibro;
    private String genero;

    public PDF(String autor, String nombreLibro, String genero, int cantidadDePaginas) {
        this.autor = autor;
        this.nombreLibro = nombreLibro;
        this.genero = genero;
        this.cantidadDePaginas = cantidadDePaginas;
    }



    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("AUTOR: " + autor.toUpperCase());

        System.out.println("LIBRO: " + nombreLibro);
        System.out.println("GENERO: " + genero);
        System.out.println("CANTIDAD DE PAGS: " + cantidadDePaginas);
    }
    
}
