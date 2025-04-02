package ABSeINT_Imprimible;
public class Informe implements Imprimible{
        private String autor;
        private String revisor;
        private String texto;
        private int cantidadPaginas;

        public Informe(String autor, String revisor, String texto, int cantidadPaginas) {
            this.autor = autor;
            this.revisor = revisor;
            this.texto = texto;
            this.cantidadPaginas = cantidadPaginas;
        }

        @Override
        public void imprimir() {
            System.out.println("Informe:");
            System.out.println("Autor: " + autor);
            System.out.println("Revisor: " + revisor);
            System.out.println("Texto: " + texto);
            System.out.println("Cantidad de Páginas: " + cantidadPaginas);
            System.out.println();
        }
    }

