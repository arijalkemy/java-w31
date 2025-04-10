package ejerciciodos;

import ejerciciodos.interfaces.MostrarDocumento;

public class Informe implements MostrarDocumento {

    int paginas;
    String autor;
    String revisor;
    String texto;

    public Informe(int paginas, String autor, String revisor, String texto) {
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }


    @Override
    public String mostrar() {
        return "Informe del autor: " + autor + " revisado por: " + revisor + " con " + paginas + " paginas\n Texto: " + texto;
    }


}
