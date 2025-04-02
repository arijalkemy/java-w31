package com.mercadolibre;

    public class LibrosPDF implements Imprimible{
        /* Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.*/
        private Integer cantidadPaginas;
        private String nombreAutor;
        private String titulo;
        private String genero;

        public LibrosPDF(Integer cantidadPaginas, String nombreAutor, String titulo, String genero) {
            this.cantidadPaginas = cantidadPaginas;
            this.nombreAutor = nombreAutor;
            this.titulo = titulo;
            this.genero = genero;
        }

        public Integer getCantidadPaginas() {
            return cantidadPaginas;
        }

        public void setCantidadPaginas(Integer cantidadPaginas) {
            this.cantidadPaginas = cantidadPaginas;
        }

        @Override
        public String imprimir() {
            String imprimible = "Cantidad de páginas: " + this.cantidadPaginas + ", Autor: " + this.nombreAutor +
                    ", Título: " + this.titulo + ", Genero:" + this.genero;
            return imprimible;
        }
}
