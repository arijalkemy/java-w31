package ejerciciodos;

import ejerciciodos.interfaces.MostrarDocumento;

import java.util.List;

public class Curriculum implements MostrarDocumento {
    String nombre;
    String apellido;
    List<String> habilidades;


    public Curriculum(String nombre, String apellido, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }


    @Override
    public String mostrar() {
        return "Curriculum de " + nombre + " " + apellido + "\nHabilidades: " + String.join(", ", habilidades);
    }
}
