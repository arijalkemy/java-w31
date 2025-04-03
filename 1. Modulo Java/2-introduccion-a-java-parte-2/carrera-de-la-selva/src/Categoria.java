import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Categoria {
    private String circuito;
    private int km;
    private String descripcion;
    private Map<Inscripcion, Participante> inscripciones = new HashMap<>();

    public Categoria(String circuito, int km, String descripcion) {
        this.circuito = circuito;
        this.km = km;
        this.descripcion = descripcion;
    }

    public void mostrarInscriptos() {
        System.out.println("Participantes circuito: " + circuito);
        inscripciones.forEach( (inscripcion, participante) -> {
            System.out.println(inscripcion.getNumeroIncripcion() + " " + participante.getNombre() + " " + participante.getApellido());
        });
    }

    public AtomicInteger montoTotal() {
        AtomicInteger total = new AtomicInteger();
        // inscripciones.forEach(inscripcion -> total.addAndGet((int) inscripcion.getMonto()));
        return total;
    }

    private float calcularMonto(int edad) {
        switch (this.circuito) {
            case "chico":
                return edad <= 18 ? 1300 : 1500;
            case "medio":
                return edad <= 18 ? 2000 : 2300;
            case "avanzado":
                // falta
                return 30;
            default:
                return 0;
        }
    }

    public Inscripcion insribirParticipante(Participante participante) {
        Inscripcion inscripcion = new Inscripcion(new Random().nextInt(1000), this.calcularMonto(participante.getEdad()));
        inscripciones.put(inscripcion, participante);
        return inscripcion;
    }

    public void desinscribirParticipante(Inscripcion inscripcion) {
        inscripciones.remove(inscripcion);
        System.out.println("Participante " + inscripcion.getNumeroIncripcion() + " removido");
    }
}
