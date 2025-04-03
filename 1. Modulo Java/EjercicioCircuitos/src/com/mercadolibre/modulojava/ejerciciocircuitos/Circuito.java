package com.mercadolibre.modulojava.ejerciciocircuitos;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.List;

public class Circuito {
    private int id;
    private String descripcion;
    private Inscripcion del_persona;
    List<Inscripcion> inscripciones = new ArrayList();

    public Circuito(String descripcion, int id) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return this.id;
    }

    public void addinscripcion(Inscripcion inscripcion) {
        this.inscripciones.add(inscripcion);
    }

    public void getInscripciones() {
        for(Inscripcion inscripcion : this.inscripciones) {
            inscripcion.mostrarinfo();
        }

    }

    public void desinscribirPersona(Persona persona) {
        for(Inscripcion inscripcion : this.inscripciones) {
            if (persona == inscripcion.getpersona()) {
                this.del_persona = inscripcion;
            }
        }

        this.inscripciones.remove(this.del_persona);
        this.getInscripciones();
    }

    public double totalMonto() {
        double montototal = (double)0.0F;

        for(Inscripcion inscripcion : this.inscripciones) {
            montototal += inscripcion.getmonto();
        }

        return montototal;
    }
}

