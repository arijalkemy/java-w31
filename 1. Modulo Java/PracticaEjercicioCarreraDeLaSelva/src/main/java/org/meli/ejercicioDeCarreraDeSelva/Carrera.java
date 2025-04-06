package org.meli.ejercicioDeCarreraDeSelva;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private List<Inscripcion> inscripciones = new ArrayList<>();

    public void inscribirParticipante(Categoria categoria, Participante participante) {
        if (categoria.getId() == 3 && participante.getEdad() < 18) {
            System.out.println("No se permite la inscripción de menores en el Circuito Avanzado.");
            return;
        }
        Inscripcion inscripcion = new Inscripcion(categoria, participante);
        inscripciones.add(inscripcion);
        System.out.println("Inscripción realizada: " + participante.getNombreCompleto() + " en " + categoria.getNombre() + " (Monto: $" + inscripcion.getMonto() + ")");
    }

    public void mostrarInscriptosPorCategoria(Categoria categoria) {
        System.out.println("\n📋 Inscriptos en " + categoria.getNombre() + ":");
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == categoria.getId()) {
                System.out.println("N° Inscripción: " + inscripcion.getNumeroInscripcion() +
                        " - " + inscripcion.getParticipante().getNombreCompleto() +
                        " (Monto: $" + inscripcion.getMonto() + ")");
            }
        }
    }

    public void desinscribirParticipante(int numeroInscripcion) {
        inscripciones.removeIf(inscripcion -> inscripcion.getNumeroInscripcion() == numeroInscripcion);
        System.out.println("Participante desinscrito correctamente.");
    }

    public void calcularRecaudacion() {
        double total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            total += inscripcion.getMonto();
        }
        System.out.println("\n Total recaudado: $" + total);
    }
}
