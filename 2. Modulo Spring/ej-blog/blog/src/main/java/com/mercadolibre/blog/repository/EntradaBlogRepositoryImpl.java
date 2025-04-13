package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.exception.BlogNotFound;
import com.mercadolibre.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaBlogRepositoryImpl implements EntradaBlogRepository {

    private List<EntradaBlog> blogs = new ArrayList<>();


    @Override
    public EntradaBlog createBlog(EntradaBlog blog) {
        this.blogs.add(blog);

        return blog;
    }

    @Override
    public EntradaBlog findById(String id) {
        Optional<EntradaBlog> blogEncontrado = blogs.stream().filter(b -> b.getId().equals(id)).findFirst();

        if (blogEncontrado.isPresent()) {
            return blogEncontrado.get();
        } else {
            throw new BlogNotFound("El id ingresado no coincide con el de ningun blog.");
        }
    }

    @Override
    public List<EntradaBlog> findAll() {
        return this.blogs;
    }

    @Override
    public Boolean alreadyExists(String id) {
        return blogs.stream().filter(b -> b.getId().equals(id)).findFirst().isPresent();

    }
}
