package com.mercadolibre;

public class Participante {
    int numeroDeParticipante;
    long dni;
    int edad;
    String nombre;
    String apellido;
    String celular;
    String numeroDeEmergencia;
    String grupoSanguineo;
    Categoria categoria;

    public Participante( int numeroDeParticipante, int edad, long dni, String nombre, String apellido, String celular, String numeroDeEmergencia, String grupoSanguineo){
        this.numeroDeParticipante = numeroDeParticipante;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.celular = celular;
        this.numeroDeEmergencia = numeroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.edad = edad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getNumeroDeParticipante() {
        return numeroDeParticipante;
    }

    public void setNumeroDeParticipante(int numeroDeParticipante) {
        this.numeroDeParticipante = numeroDeParticipante;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumeroDeEmergencia() {
        return numeroDeEmergencia;
    }

    public void setNumeroDeEmergencia(String numeroDeEmergencia) {
        this.numeroDeEmergencia = numeroDeEmergencia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
}
