package com.mercadolibre.model;

public class Categoria {
    private Integer id;
    private String nombre;
    private String descripcion;
    private TipoCategoria tipo;

    public Categoria(int id, String nombre, String descripcion, TipoCategoria tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public TipoCategoria getTipo() {
        return tipo;
    }

    public void setTipo(TipoCategoria tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
