package com.bootcamp.ej_blog.model;

import java.time.LocalDate;
import java.util.Date;

public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public EntradaBlog(int id, String titulo, String autor, LocalDate fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
}
