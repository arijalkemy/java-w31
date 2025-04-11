package com.example;

public class Participante {
    private static int contador = 1;

    private int idParticipante;
    private String nombre;
    private String apellido;
    private int edad;
    private int dni;
    private int celular;
    private int contactoEmergencia;
    private String gruposanguineo;

  public Participante(String nombre, String apellido, int edad, int dni, int celular, int contactoEmergencia, String gruposanguineo) {
        this.idParticipante = contador++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.celular = celular;
        this.contactoEmergencia = contactoEmergencia;
        this.gruposanguineo = gruposanguineo;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(int contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getGruposanguineo() {
        return gruposanguineo;
    }

    public void setGruposanguineo(String gruposanguineo) {
        this.gruposanguineo = gruposanguineo;
    }
}
