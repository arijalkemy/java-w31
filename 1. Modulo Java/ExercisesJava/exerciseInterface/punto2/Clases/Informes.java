package exerciseInterface.punto2.Clases;

public class Informes extends Document {
    private String texto;
    private int cantPaginas;
    private String nombreAutor;
    private String nombreRevisor;

    public Informes(String texto, int cantPaginas, String nombreAutor, String nombreRevisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        this.nombreRevisor = nombreRevisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public String getNombreRevisor() {
        return nombreRevisor;
    }

    public void setNombreRevisor(String nombreRevisor) {
        this.nombreRevisor = nombreRevisor;
    }

    @Override
    public void Imprimir() {
        System.out.println("Nombre autor : " + this.nombreAutor + " nombre revisor "
                + this.nombreRevisor + " texto: " + this.texto + "cantidad paginas:" + this.cantPaginas);
    }

}
