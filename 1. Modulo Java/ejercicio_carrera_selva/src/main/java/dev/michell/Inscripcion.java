package dev.michell;

public class Inscripcion {

    private int numero;
    private Participante participante;
    private double monto;

    public Inscripcion(Participante participante) {
        this.participante = participante;
        this.numero = participante.getNumeroParticipante();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Numero: " + numero + ", dev.michell.Participante: " + participante + ", Monto: " + monto;
    }
}
