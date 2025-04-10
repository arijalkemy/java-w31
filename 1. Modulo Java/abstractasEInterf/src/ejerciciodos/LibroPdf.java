package ejerciciodos;

import ejerciciodos.interfaces.MostrarDocumento;

public class LibroPdf implements MostrarDocumento {
    int paginas;
    String nombre;
    String autor;
    String titulo;
    String genero;

    public LibroPdf(int paginas, String nombre, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.nombre = nombre;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }


    @Override
    public String mostrar() {
        return "Libro: " + titulo + "\nAutor: " + autor + "\nGénero: " + genero + "\nPáginas: " + paginas;
    }
}
