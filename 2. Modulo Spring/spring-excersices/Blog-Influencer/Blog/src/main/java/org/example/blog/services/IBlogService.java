package org.example.blog.services;

import org.example.blog.DTO.EntradaBlogDTO;
import org.example.blog.entities.EntradaBlog;

import java.util.List;

public interface IBlogService {
    EntradaBlogDTO createBlog(EntradaBlogDTO entradaBlogDTO);
    EntradaBlogDTO getBlogById(int id);
    List<EntradaBlogDTO> getAllBlogs();
}
