package com.bootcamp.blogs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


public class EntryBlog {
    String id;
    String titulo;
    String nombreAutor;
    String fechaPublicacion;

    public EntryBlog(String id, String titulo, String nombreAutor, String fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
}
