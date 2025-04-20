package com.company;

public class Participante {
    private int numeroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numeroEmer;
    private String grupoSang;

    public Participante(int numeroParticipante, int dni, String nombre, String apellido, int edad, int celular, int numeroEmer, String grupoSang) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmer = numeroEmer;
        this.grupoSang = grupoSang;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNumeroEmer() {
        return numeroEmer;
    }

    public void setNumeroEmer(int numeroEmer) {
        this.numeroEmer = numeroEmer;
    }

    public String getGrupoSang() {
        return grupoSang;
    }

    public void setGrupoSang(String grupoSang) {
        this.grupoSang = grupoSang;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numeroParticipante=" + numeroParticipante +
                ", dni=" + dni +
                ", nombre='" + nombre + '\n' +
                ", apellido='" + apellido + '\n' +
                ", edad=" + edad +
                ", celular=" + celular +
                ", numeroEmer=" + numeroEmer +
                ", grupoSang='" + grupoSang + '\n' +
                '}';
    }
}
