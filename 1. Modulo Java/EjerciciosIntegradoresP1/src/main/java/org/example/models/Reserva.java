package org.example.models;

public abstract class Reserva {
    Double total;
    String fechaInicio;
    String fechaFin;
    String descripcion;

    public Reserva(String fechaInicio, String fechaFin, String descripcion) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
    }
}
