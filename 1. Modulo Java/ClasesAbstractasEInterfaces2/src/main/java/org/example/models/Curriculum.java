package org.example.clasesdos;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Documento {

    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String celular, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
        this.habilidades = new ArrayList<>();
    }

    @Override
    public String imprimir(String identificacion) {
        return "nombre: "+this.nombre+" apellido: "+this.apellido+" celular: "+this.celular+" email: "+this.email +" habilidades: "+this.habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public void addHabilidad(String habilidad) {
        this.habilidades.add(habilidad);
    }
}
