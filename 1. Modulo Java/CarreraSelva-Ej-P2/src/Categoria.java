public class Categoria {
    private String tipo;
    private double kilometros;
    private String terreno;


    public Categoria(String tipo, double kilometros, String terreno) {
        this.tipo = tipo;
        this.kilometros = kilometros;
        this.terreno = terreno;
    }


    public String getTipo() {
        return tipo;
    }
}
