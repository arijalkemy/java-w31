package com.mercadoLibre;

import java.util.List;

public class Categoria {
    private String nombre;
    private int distancia;
    private String recorrido;
    private double costoInscripcionMenores;
    private double costoInscripcionMayores;
    private List<Inscripcion> inscripciones;

    public Categoria(String nombre, int distancia, String recorrido, double costoInscripcionMenores, double costoInscripcionMayores, List<Inscripcion> inscripciones) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.recorrido = recorrido;
        this.costoInscripcionMenores = costoInscripcionMenores;
        this.costoInscripcionMayores = costoInscripcionMayores;
        this.inscripciones = inscripciones;
    }

    public static void mostrarInfoCategorias(Categoria circuitoChico, Categoria circuitoMedio, Categoria circuitoAvanzado) {
        System.out.println("\n--- Circuitos Disponibles ---");
        System.out.println("1. " + circuitoChico.getNombre() + " - " + circuitoChico.getDistancia() + " km - " + circuitoChico.getRecorrido());
        System.out.println("2. " + circuitoMedio.getNombre() + " - " + circuitoMedio.getDistancia() + " km - " + circuitoMedio.getRecorrido());
        System.out.println("3. " + circuitoAvanzado.getNombre() + " - " + circuitoAvanzado.getDistancia() + " km - " + circuitoAvanzado.getRecorrido());
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        if (!(nombre.equals("Circuito Avanzado") && inscripcion.getParticipante().getEdad() < 18)) {
            inscripciones.add(inscripcion);
        }
    }

    public void eiminarInscripcion(Inscripcion inscripcion) {
        inscripciones.remove(inscripcion);
    }

    public double calcularInscripciones() {
        double total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            total += inscripcion.getCostoInscripcion();
        }
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public double getCostoInscripcionMenores() {
        return costoInscripcionMenores;
    }

    public double getCostoInscripcionMayores() {
        return costoInscripcionMayores;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}
