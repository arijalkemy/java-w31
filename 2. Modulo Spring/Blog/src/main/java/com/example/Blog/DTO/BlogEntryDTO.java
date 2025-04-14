package com.example.Blog.DTO;

import java.io.Serializable;

import com.example.Blog.Entities.BlogEntry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogEntryDTO implements Serializable {
    private String id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;

    public BlogEntryDTO() {
    }

    public BlogEntryDTO(String titulo, String autor, String fechaPublicacion, String id) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.id = id;
    }

    public static BlogEntryDTO blogEntryToDTO(BlogEntry entry) {
        return new BlogEntryDTO(entry.getTitulo(), entry.getAutor(), entry.getFechaPublicacion(), entry.getId());
    }
}
