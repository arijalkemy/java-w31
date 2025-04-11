package org.example.blog.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.blog.controllers.BlogExceptionHandler;
import org.example.blog.entities.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Repository
public class BlogRepository implements IBlogRepository{
    List<EntradaBlog> blogs = new ArrayList<>();

    @Override
    public EntradaBlog createBlog(EntradaBlog entradaBlog) {
        this.blogs.add(entradaBlog);
        return entradaBlog;
    }

    @Override
    public EntradaBlog getBlogById(int id) {
        return this.blogs.stream().filter(blog -> blog.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> getBlogs() {
        return this.blogs;
    }
}
