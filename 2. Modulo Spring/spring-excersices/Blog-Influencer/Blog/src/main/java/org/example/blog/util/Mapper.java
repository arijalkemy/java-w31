package org.example.blog.util;

import org.example.blog.DTO.EntradaBlogDTO;
import org.example.blog.entities.EntradaBlog;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public EntradaBlog mapBlog(EntradaBlogDTO entradaBlog) {
        EntradaBlog blog = new EntradaBlog();
        blog.setId(entradaBlog.getId());
        blog.setTitulo(entradaBlog.getTitulo());
        blog.setAutor(entradaBlog.getAutor());
        blog.setPublicacionDate(entradaBlog.getPublicacionDate());
        return blog;
    }

    public EntradaBlogDTO mapEntradaBlog(EntradaBlog entradaBlog) {
        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO();
        entradaBlogDTO.setId(entradaBlog.getId());
        entradaBlogDTO.setTitulo(entradaBlog.getTitulo());
        entradaBlogDTO.setAutor(entradaBlog.getAutor());
        entradaBlogDTO.setPublicacionDate(entradaBlog.getPublicacionDate());
        return entradaBlogDTO;
    }
}
