package org.mercadolibre.ejercicio_blog.service;

import org.mercadolibre.ejercicio_blog.dto.EntradaBlogDTO;

import java.util.List;

public interface BlogService {
    List<EntradaBlogDTO> getAllBlogs();
    String addBlog(EntradaBlogDTO blog);
    EntradaBlogDTO getBlogById(int id);
}
