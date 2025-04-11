package org.example.blog.repositories;

import org.example.blog.entities.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    public EntradaBlog createBlog(EntradaBlog entradaBlog);
    public EntradaBlog getBlogById(int id);
    public List<EntradaBlog> getBlogs();

}
