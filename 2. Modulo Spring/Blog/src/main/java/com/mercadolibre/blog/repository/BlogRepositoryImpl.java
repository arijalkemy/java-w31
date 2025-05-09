package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntryBlog;
import com.mercadolibre.blog.exception.ConflictException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private final Map<Integer, EntryBlog> blogs = new HashMap<>();

    public BlogRepositoryImpl() {
        blogs.put(1, new EntryBlog(1, "Lorem Ipsum", "Test Entry 1", "2025-04-10"));
        blogs.put(2, new EntryBlog(2, "Lorem Ipsum", "Test Entry 2", "2025-05-05"));
        blogs.put(3, new EntryBlog(3, "Lorem Impsum", "Test Entry 3", "2025-03-25"));
    }

    @Override
    public EntryBlog save(EntryBlog blog) {
        if (blogs.containsKey(blog.getId())) {
            throw new ConflictException("Blog with the given ID already exists.");
        }
        blogs.put(blog.getId(), blog);
        return blog;
    }

    @Override
    public Optional<EntryBlog> findById(Integer id) {
        return Optional.ofNullable(blogs.get(id));
    }

    @Override
    public Collection<EntryBlog> findAll() {
        return blogs.values();
    }
}
