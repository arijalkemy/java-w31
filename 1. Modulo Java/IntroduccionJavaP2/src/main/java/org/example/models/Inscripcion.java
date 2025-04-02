package org.example.models;

public class Inscripcion{

    int id;
    Categoria categoria;
    Participante participante;
    double monto=0;

    public Inscripcion(int id, Categoria categoria, Participante participante) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
    }

    public int getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
