package ejercicio_imprimibles;

import java.util.ArrayList;

public class CV implements Imprimible {
    private Persona persona;
    private ArrayList<String> habilidades;

    @Override
    public String toString() {
        return "CV [persona=" + persona.toString() + ", habilidades=" + habilidades + "]";
    }

    public CV(Persona persona, ArrayList<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

}
