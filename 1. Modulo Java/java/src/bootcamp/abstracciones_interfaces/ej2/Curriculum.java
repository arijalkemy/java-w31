package bootcamp.abstracciones_interfaces.ej2;

import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private String apellido;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    @Override
    public String obtenerContenido() {
        return "Curriculum de " + nombre + " " + apellido + "\nHabilidades: " + String.join(", ", habilidades);
    }
}
