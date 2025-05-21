package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.ConflictException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BlogRepository implements IBlogRepository{

    private final List<EntradaBlog> blogs = new ArrayList<>();

    public BlogRepository() {
        blogs.add(new EntradaBlog(1, "Lorem Ipsum", "Test Entry 1", "2025-04-10"));
        blogs.add(new EntradaBlog(2, "Lorem Ipsum", "Test Entry 2", "2025-05-05"));
        blogs.add(new EntradaBlog(3, "Lorem Impsum", "Test Entry 3", "2025-03-25"));
    }

    @Override
    public EntradaBlog save(EntradaBlog eBlog) {
        for (EntradaBlog blog : blogs) {
            if (blog.getId().equals(eBlog.getId())) {
                throw new ConflictException("El Blog ya existe.");
            }
        }
        blogs.add(eBlog);
        return eBlog;
    }

    @Override
    public Optional<EntradaBlog> findById(Integer id) {
        return blogs.stream().filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<EntradaBlog> findAll() {
        return blogs;
    }
}
