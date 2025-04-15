package org.example;

public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    private double calcularMonto() {
        int edad = participante.getEdad();
        String nombreCat = categoria.getNombre().toLowerCase();

        if (nombreCat.contains("chico")) return edad < 18 ? 1300 : 1500;
        if (nombreCat.contains("medio")) return edad < 18 ? 2000 : 2300;
        if (nombreCat.contains("avanzado")) return edad >= 18 ? 2800 : 0;
        return 0;
    }

    public double getMonto() { return monto; }
    public Categoria getCategoria() { return categoria; }
    public Participante getParticipante() { return participante; }
    public int getNumeroInscripcion() { return numeroInscripcion; }

    @Override
    public String toString() {
        return "Inscripción #" + numeroInscripcion + ": " + participante + " - Monto: $" + monto;
    }
}
