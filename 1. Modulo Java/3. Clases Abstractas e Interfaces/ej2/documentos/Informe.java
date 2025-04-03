package documentos;

public class Informe implements Documento {
    private String titulo;
    private String autor;
    private String fecha;
    private String contenido;

    public Informe(String titulo, String autor, String fecha, String contenido) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
        this.contenido = contenido;
    }

    @Override
    public void imprimirEnConsola() {
        System.out.println("Informe:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Fecha: " + fecha);
        System.out.println("Contenido: " + contenido);
    }
    
}
