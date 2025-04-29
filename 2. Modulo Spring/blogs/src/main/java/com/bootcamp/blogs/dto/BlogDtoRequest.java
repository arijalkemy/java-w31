package com.bootcamp.blogs.dto;

import lombok.Data;

@Data
public class BlogDtoRequest {
    String id;
    String titulo;
    String nombreAutor;
    String fechaPublicacion;

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

    public BlogDtoRequest(String id, String titulo, String nombreAutor, String fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
