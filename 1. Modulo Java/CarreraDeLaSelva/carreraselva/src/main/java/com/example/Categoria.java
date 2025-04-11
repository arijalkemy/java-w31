package com.example;

public class Categoria {
    
    private int idCategoria;
    private String nombre;
    private String descripción;

    // Constructor de la clase Categoria
    public Categoria(int idCategoria, String nombre, String descripción) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripción = descripción;
    }

    @Override
    public String toString() {
    return nombre;  // Esto devuelve el nombre de la categoría.
}

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

}
