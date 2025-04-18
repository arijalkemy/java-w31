package org.example;

public abstract class Cliente {
    String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public abstract void mostrarOperaciones();
}
