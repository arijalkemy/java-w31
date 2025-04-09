package com.example.Blog.Entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class BlogEntry {
    private String id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
    
    public BlogEntry(String titulo, String autor, String fechaPublicacion, String id) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.id = id;
    }
}
