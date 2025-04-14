package com.mercadoLibre;

public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double costoInscripcion;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante, double costoInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.costoInscripcion = costoInscripcion;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public double getCostoInscripcion() {
        return costoInscripcion;
    }
}
