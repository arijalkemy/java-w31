import java.util.HashSet;
import java.util.Set;

public class Carrera {
    private Set<Inscripcion> inscripciones = new HashSet<>();

    public void inscribirParticipante(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public void desinscribirParticipante(Participante participante) {
        inscripciones.removeIf(inscripcion -> inscripcion.getParticipante().equals(participante));
    }

    public void mostrarInscripcionesPorCategoria(Categoria categoria) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().equals(categoria)) {
                System.out.println(inscripcion);
            }
        }
    }

    public double calcularMontoTotalPorCategoria(Categoria categoria) {
        double total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().equals(categoria)) {
                total += inscripcion.getMontoInscripcion();
            }
        }
        return total;
    }

    public double calcularMontoTotal() {
        double total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            total += inscripcion.getMontoInscripcion();
        }
        return total;
    }

    public static double calcularMonto(Categoria categoria, Participante participante) {
        int edad = participante.getEdad();
        switch (categoria.getNombre()) {
            case "Circuito chico":
                return (edad < 18) ? 1300 : 1500;
            case "Circuito medio":
                return (edad < 18) ? 2000 : 2300;
            case "Circuito avanzado":
                return (edad >= 18) ? 2800 : Double.NaN; // Retorna NaN si es menor de 18
            default:
                return 0;
        }
    }
}