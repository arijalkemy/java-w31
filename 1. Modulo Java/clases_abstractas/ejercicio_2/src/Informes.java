public class Informes extends Documento{
    private int cantidadDePaginas;
    private String texto;
    private String autor;
    private String revisor;

    public Informes(String autor, String texto, String revisor, int cantidadDePaginas) {
        this.autor = autor;
        this.texto = texto;
        this.revisor = revisor;
        this.cantidadDePaginas = cantidadDePaginas;
    }



    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("AUTOR: " + autor.toUpperCase());

        System.out.println("TEXTO: " + texto);
        System.out.println("REVISOR: " + revisor);
        System.out.println("CANTIDAD DE PAGS: " + cantidadDePaginas);
    }
    
}
