package carreradelaselva;

import java.util.HashSet;
import java.util.Set;

public class Categoria {

    private int id;
    private String nombre;
    private boolean permiteMenores;
    private double montoInscripcionMenor18;
    private double montoInscripcionMayor18;
    private Set<Inscripcion> inscriptosCategoria;

    public Categoria(int id, String nombre, boolean permiteMenores, double montoInscripcionMenor18, double montoInscripcionMayor18) {
        this.id = id;
        this.nombre = nombre;
        this.permiteMenores = permiteMenores;
        this.montoInscripcionMenor18 = montoInscripcionMenor18;
        this.montoInscripcionMayor18 = montoInscripcionMayor18;
        this.inscriptosCategoria = new HashSet<>(); // Inicialización del conjunto
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isPermiteMenores() {
        return permiteMenores;
    }

    public double getMontoInscripcion(int edad) {
        return edad < 18 ? montoInscripcionMenor18 : montoInscripcionMayor18;
    }

    public void inscribirUsuario(Inscripcion inscripcion) {
        inscriptosCategoria.add(inscripcion);
    }

    public int getCantidadInscriptos() {
        System.out.println("Cantidad de inscriptos en " + nombre + ": " + inscriptosCategoria.size());
        return inscriptosCategoria.size();
    }

    public double getDineroRecaudado() {
        return inscriptosCategoria.stream()
                .mapToDouble(Inscripcion::getMontoAbonar)
                .sum();
    }

    public Set<Inscripcion> getInscriptosCategoria() {
        return new HashSet<>(inscriptosCategoria); // Retornar una copia del conjunto
    }

    public void desinscribirUsuario(Inscripcion inscripcion) {
        if (inscriptosCategoria.contains(inscripcion)) {
            inscriptosCategoria.remove(inscripcion);
        } else {
            throw new IllegalArgumentException("El participante no está inscrito en esta categoría");
        }
    }
}
