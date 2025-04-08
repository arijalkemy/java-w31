package carreraDeLaSelva;

public class Categoria {

    private int km;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(int km, String descripcion) {
        this.km = km;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
