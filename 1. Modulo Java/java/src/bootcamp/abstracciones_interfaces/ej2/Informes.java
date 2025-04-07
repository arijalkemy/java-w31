package bootcamp.abstracciones_interfaces.ej2;

public class Informes implements Imprimible {
    private String texto, autor, revisor;
    private int cantidadPaginas;

    public Informes(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String obtenerContenido() {
        return "Informe de " + autor + "\nRevisor: " + revisor + "\nPáginas: " + cantidadPaginas + "\nContenido: " + texto;
    }
}
