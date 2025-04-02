package ejercicio_imprimibles;

public class Informe implements Imprimible {
    private String texto;
    private int cantdadPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantdadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantdadPaginas = cantdadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe [texto=" + texto + ", cantdadPaginas=" + cantdadPaginas + ", autor=" + autor + ", revisor="
                + revisor + "]";
    }

}
