package org.meli.ejercicioDeCarreraDeSelva;

public class Inscripcion {

    private static int contadorInscripciones = 1;
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(Categoria categoria, Participante participante) {
        this.numeroInscripcion = contadorInscripciones++;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    private double calcularMonto() {
        int edad = participante.getEdad();
        switch (categoria.getId()) {
            case 1:
                return (edad < 18) ? 1300 : 1500;
            case 2:
                return (edad < 18) ? 2000 : 2300;
            case 3:
                return (edad < 18) ? 0 : 2800;
            default:
                return 0;
        }
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

    public double getMonto() {
        return monto;
    }
}
