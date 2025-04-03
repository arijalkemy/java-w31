package com.mercadolibre;

public class Cliente {
    private static int contadorId = 1;
    private Integer id;
    private String nombre;
    private String dni;
    private String apellido;

    public Cliente(String nombre, String apellido, String dni) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
