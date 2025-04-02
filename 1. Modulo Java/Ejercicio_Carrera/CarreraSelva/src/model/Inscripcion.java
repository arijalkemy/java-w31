package model;

public class Inscripcion {


    private int id;
    private Categoria categoria;
    private Participante participante;
    private double precio;

    public Inscripcion(int id, Categoria categoria, Participante participante, double precio) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
        this.precio = precio;
        this.participante.setInscrito(true);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
