package carreraDeLaSelva;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double montoAbonar;

    public Inscripcion() {
    }

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.montoAbonar = montoAbonar();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getMontoAbonar() {
        return montoAbonar;
    }

    public void setMontoAbonar(double montoAbonar) {
        this.montoAbonar = montoAbonar;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    private double montoAbonar() {
        if (categoria.getKm() == 2) {
            return participante.getEdad() < 18 ? 1300 : 1500;
        }else if (categoria.getKm() == 5) {
            return participante.getEdad() < 18 ? 2000 : 2300;
        } else if (categoria.getKm() == 10 && participante.getEdad() >= 18) {
            return 2800;
        }
        return 0.0;
    }

    public static void mostrarInscriptos(List<Inscripcion> inscripciones, Categoria categoria) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().equals(categoria)) {
                Participante participante = inscripcion.getParticipante();
                System.out.println("Inscripcion: " + inscripcion.getNumeroInscripcion());
            }
        }
    }

    public static void elimiarInscriptos(List<Inscripcion> inscripciones, Participante participante) {
        inscripciones.removeIf(inscripcion -> inscripcion.getParticipante().equals(participante));
    }
}

