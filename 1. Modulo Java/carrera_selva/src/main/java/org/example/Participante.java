package org.example;

public class Participante {
    private int numero;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String emergencia;
    private String grupoSanguineo;

    public Participante(int numero, String dni, String nombre, String apellido, int edad, String celular, String emergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.emergencia = emergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    // Getters
    public int getNumero() { return numero; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - DNI: " + dni + " - Edad: " + edad;
    }
}