package com.bootcamp.blogs.dto;

import lombok.AllArgsConstructor;

import java.io.Serializable;

public class BlogDto implements Serializable {
    String id;
    String titulo;
    String nombreAutor;
    String fechaPublicacion;

    public BlogDto(String id, String titulo, String nombreAutor, String fechaPublicacion) {
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
