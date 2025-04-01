package carreraDeLaSelva;

public class Inscripcion {
    Participante participante;
    int idInscripcion;
    Categoria categoria;

    public Inscripcion(Categoria categoria, int idInscripcion, Participante participante) {
        this.categoria = categoria;
        this.idInscripcion = idInscripcion;
        this.participante = participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }
}
