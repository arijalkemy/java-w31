package carreradelaselva;

public class Inscripcion {

    private Carrera carrera;
    private Categoria categoria;
    private Participante participante;
    private double montoAbonar;

    public Inscripcion(Carrera carrera, Participante participante, Categoria categoria) {
        this.carrera = carrera;
        this.participante = participante;
        this.categoria = validarCategoria(categoria);
        this.montoAbonar = categoria.getMontoInscripcion(participante.getEdad());
    }

    private Categoria validarCategoria(Categoria categoria) {
        Categoria categoriaEncontrada = carrera.getCategoria(categoria);
        if (!categoriaEncontrada.isPermiteMenores() && participante.getEdad() < 18) {
            throw new IllegalArgumentException("No se permite la inscripción en esta categoría para menores de edad");
        }
        return categoriaEncontrada;
    }

    public double getMontoAbonar() {
        return montoAbonar;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }
}
