package Practica5;

public abstract class Documento{

    private String autor;
    private int cantPaginas;

    public Documento(String autor, int cantPaginas) {
        this.autor = autor;
        this.cantPaginas = cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "autor='" + autor + '\'' +
                ", cantPaginas=" + cantPaginas +
                '}';
    }
}


// Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
//  Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
//Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
