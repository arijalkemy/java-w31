package org.mercadolibre.ejercicio_blog.repository;

import org.mercadolibre.ejercicio_blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository{
    List<EntradaBlog> entradaBlogList = new ArrayList<>();

    @Override
    public List<EntradaBlog> listAllBlogs() {
        return entradaBlogList;
    }

    @Override
    public void addBlog(EntradaBlog blog) {
        entradaBlogList.add(blog);
    }
}
