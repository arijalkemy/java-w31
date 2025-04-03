package com.mercadolibre.modulojava.ejerciciocircuitos;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Inscripcion {
    private int numero_inscripcion;
    private Circuito categoria;
    private Persona participante;
    private double monto;

    public Inscripcion(int numero_inscripcion, Circuito categoria, Persona participante) {
        this.numero_inscripcion = numero_inscripcion;
        this.categoria = categoria;
        this.participante = participante;
        if (categoria.getId() == 1) {
            if (participante.getEdad() < 18) {
                this.monto = (double)1300.0F;
            } else {
                this.monto = (double)1500.0F;
            }
        } else if (categoria.getId() == 2) {
            if (participante.getEdad() < 18) {
                this.monto = (double)2000.0F;
            } else {
                this.monto = (double)2300.0F;
            }
        } else {
            this.monto = (double)2800.0F;
        }

        ++Main.numeroi;
        categoria.addinscripcion(this);
    }

    public void mostrarinfo() {
        System.out.println("Numero de inscripcion: " + this.numero_inscripcion);
        System.out.println("Monto: " + this.monto);
        this.participante.mostrarinfo();
    }

    public Persona getpersona() {
        return this.participante;
    }

    public double getmonto() {
        return this.monto;
    }
}
