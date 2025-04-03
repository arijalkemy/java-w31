package exerciseInterface.punto2.Clases;

public class LibroPdf extends Document {
    private int cantPaginas;
    private String nombreAutor;
    private String  tituloLibro;
    private String genero;
    
    public LibroPdf(int cantPaginas, String nombreAutor, String tituloLibro, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        this.tituloLibro = tituloLibro;
        this.genero = genero;
    }
    public int getCantPaginas() {
        return cantPaginas;
    }
    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }
    public String getNombreAutor() {
        return nombreAutor;
    }
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    public String getTituloLibro() {
        return tituloLibro;
    }
    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    @Override
    public void Imprimir() {
        System.out.println(" Titulo libro : " + this.tituloLibro + 
            " cantidad paginas : " + this.cantPaginas + " nombre autor " +
            this.nombreAutor + " genero " + this.genero);
    }
    
}
