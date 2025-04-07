package com.mercadolibre.model;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private List<Inscripcion> inscripciones;
    private Double montoTotal;

    public Carrera() {
        this.inscripciones  = new ArrayList<>();
    }

    public Carrera(String nombre, List<Inscripcion> inscripciones) {
        this.nombre = nombre;
        this.inscripciones  = new ArrayList<>();
    }

    public void desinscribirParticipante(Inscripcion inscripcion) {
        this.inscripciones.remove(inscripcion);
    }


    public Double montoTotalPorCategoria(TipoCategoria tipo) {
        double total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getTipo().equals(tipo)) {
                total += inscripcion.getMontoAbonar();
            }
        }
        return total;
    }
    public void mostrarInscriptosPorCategoria(TipoCategoria tipo) {
        System.out.println("Inscriptos de la categoria " + tipo);
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getTipo().equals(tipo)) {
                System.out.println(inscripcion.getParticipante().toString());
            }
        }
    }

    public void calcularMontoTotal() {
        double total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            total += inscripcion.getMontoAbonar();
        }
        this.montoTotal = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void addInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
