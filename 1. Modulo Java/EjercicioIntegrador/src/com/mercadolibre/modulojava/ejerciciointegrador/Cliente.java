package com.mercadolibre.modulojava.ejerciciointegrador;

public class Cliente {
    private String name;
    private String apellido;
    private String dni;

    public Cliente(String name, String apellido, String dni) {
        this.name = name;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
