package bootcamp.carrera;

public class Inscripcion {
    private int id;
    private Categoria categoria;
    private Atleta atleta;
    private Double monto =  0.0;

    public Inscripcion(int id, Categoria categoria, Atleta atleta) {
        this.id = id;
        this.categoria = categoria;
        this.atleta = atleta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
}
