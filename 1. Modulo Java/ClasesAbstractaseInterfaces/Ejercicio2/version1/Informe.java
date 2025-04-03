package ClasesAbstractaseInterfaces.Ejercicio2.version1;

//*  - Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.

public class Informe implements Imprimible {
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Informe...");
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println("Cantidad de Páginas: " + cantidadPaginas);
        System.out.println("Texto: " + texto);
    }

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public int getCantidadPaginas() {
        return cantidadPaginas;
    }
    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getRevisor() {
        return revisor;
    }
    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}
