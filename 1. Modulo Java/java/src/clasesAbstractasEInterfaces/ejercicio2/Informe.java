package clasesAbstractasEInterfaces.ejercicio2;

public class Informe implements IImprimible {
    private String descripcion;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String autor, int cantidadDePaginas, String descripcion, String revisor) {
        this.autor = autor;
        this.cantidadDePaginas = cantidadDePaginas;
        this.descripcion = descripcion;
        this.revisor = revisor;
    }


    @Override
    public void imprimir() {
        System.out.println("Descripción: " + descripcion + " - Cant. de Paginas: " + cantidadDePaginas + " - Autor: " + autor + " - Revisor: " + revisor);
    }
}
