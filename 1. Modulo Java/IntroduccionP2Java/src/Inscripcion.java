public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double montoInscripcion;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante, double montoInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.montoInscripcion = montoInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripción #" + numeroInscripcion + ": " + participante + ", Monto: $" + montoInscripcion;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMontoInscripcion() {
        return montoInscripcion;
    }

    public void setMontoInscripcion(double montoInscripcion) {
        this.montoInscripcion = montoInscripcion;
    }
}
