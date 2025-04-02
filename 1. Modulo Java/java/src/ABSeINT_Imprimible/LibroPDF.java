package ABSeINT_Imprimible;
public class LibroPDF implements Imprimible {
        private String autor;
        private String titulo;
        private String genero;
        private int cantidadPaginas;

        public LibroPDF(String autor, String titulo, String genero, int cantidadPaginas) {
            this.autor = autor;
            this.titulo = titulo;
            this.genero = genero;
            this.cantidadPaginas = cantidadPaginas;
        }

        @Override
        public void imprimir() {
            System.out.println("Libro en PDF:");
            System.out.println("Título: " + titulo);
            System.out.println("Autor: " + autor);
            System.out.println("Género: " + genero);
            System.out.println("Cantidad de Páginas: " + cantidadPaginas);
            System.out.println();
        }
    }

