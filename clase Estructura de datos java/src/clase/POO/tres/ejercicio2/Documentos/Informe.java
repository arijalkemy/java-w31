package clase.POO.tres.ejercicio2.Documentos;

public class Informe implements Documento {
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
        System.out.println("\nImprimiendo Informe");
        System.out.println("Texto: " + texto + "\nCantidad de paginas: " + cantidadPaginas + "\nAutor: " + autor + "\nRevisor: " + revisor + "\n");
    }
}
