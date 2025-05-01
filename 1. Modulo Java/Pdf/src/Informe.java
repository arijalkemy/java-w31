public class Informe implements Imprimir{
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
        System.out.println("Informe por " + autor + " | Revisor: " + revisor);
        System.out.println("Páginas: " + cantidadPaginas);
        System.out.println("Contenido: " + texto);
    }
}
