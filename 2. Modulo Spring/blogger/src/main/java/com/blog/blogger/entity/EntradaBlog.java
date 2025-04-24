package com.blog.blogger.entity;

import java.time.LocalDate;
import java.util.Objects;

public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaDePublicacion;

    public EntradaBlog(int id, String titulo, String nombreAutor, String fechaDePublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(String fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntradaBlog that = (EntradaBlog) o;
        return id == that.id && Objects.equals(titulo, that.titulo) && Objects.equals(nombreAutor, that.nombreAutor) && Objects.equals(fechaDePublicacion, that.fechaDePublicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, nombreAutor, fechaDePublicacion);
    }

    @Override
    public String toString() {
        return "EntradaBlog{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", fechaDePublicacion='" + fechaDePublicacion + '\'' +
                '}';
    }
}
