package com.mercadolibre.bootcamp.model;

import com.mercadolibre.bootcamp.interfaces.Imprimible;

import java.util.List;

public class Curriculum extends Documento {
    private String nombre;
    private String apellido;
    private String dni;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
        this.dni = dni;
    }

    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum:");
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Dni: " + dni);
        System.out.println("Habilidades: " + String.join(", ", habilidades));
    }
}
