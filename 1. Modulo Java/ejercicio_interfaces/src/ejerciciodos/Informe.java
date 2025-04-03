package ejerciciodos;

public class Informe implements IImprimible {
    private String texto;
    private String autor;
    private String revisor;
    private int cantidadPaginas;

    public Informe(String texto, String autor, String revisor, int cantidadPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe:");
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println("Cantidad de Páginas: " + cantidadPaginas);
        System.out.println("Texto: " + texto);
    }
}