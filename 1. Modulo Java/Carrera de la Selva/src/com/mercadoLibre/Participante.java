package com.mercadoLibre;

public class Participante {
    private int numeroParticipante;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String celularEmergencia;
    private String grupoSanguineo;

    public Participante(int numeroParticipante, String dni, String nombre, String apellido, int edad, String celular, String celularEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.celularEmergencia = celularEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCelular() {
        return celular;
    }

    public String getCelularEmergencia() {
        return celularEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
}

