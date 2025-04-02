package model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private int id;
    private String nombre;
    private String descripcion;
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void agregarParticipante(Participante participante) throws Exception{
        if(participante.isInscrito()){
            throw  new Exception("Participante ya inscrito");
        }
        double monto = 0;
        if (nombre.equals("Circuito chico")) {
            monto = participante.getEdad() < 18 ? 1300 : 1500;
        } else if (nombre.equals("Circuito medio")) {
            monto = participante.getEdad() < 18 ? 2000 : 2300;
        } else if (nombre.equals("Circuito avanzado")) {
            if (participante.getEdad() < 18) {
                throw new Exception("No se permite inscripciones a menores de 18 años en Circuito avanzado");
            }
            monto = 2800;
        }
        Inscripcion inscripcion = new Inscripcion(inscripciones.size() + 1, this, participante, monto);
        inscripciones.add(inscripcion);
    }

    public void mostrarInscritos() {
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println("Número de Inscripción: " + inscripcion.getId() + ", Participante: "
                    + inscripcion.getParticipante() + ", Monto: " + inscripcion.getPrecio());
        }
    }

    public int calcularRecaudacion() {
        int total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            total += inscripcion.getPrecio();
        }
        return total;
    }

    public void desinscribirParticipante(int numeroParticipante) {
        inscripciones.removeIf(inscripcion -> inscripcion.getParticipante().getNumero() == numeroParticipante);
    }
}
