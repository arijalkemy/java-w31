package org.mercadolibre.ejercicio_blog.repository;

import org.mercadolibre.ejercicio_blog.entity.EntradaBlog;

import java.util.List;

public interface BlogRepository {
    List<EntradaBlog> listAllBlogs();
    void addBlog(EntradaBlog blog);
}
