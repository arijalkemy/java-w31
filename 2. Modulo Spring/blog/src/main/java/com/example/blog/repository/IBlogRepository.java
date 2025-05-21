package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;

import java.util.Collection;
import java.util.Optional;

public interface IBlogRepository {
    EntradaBlog save(EntradaBlog eBlog);

    Optional<EntradaBlog> findById(Integer id);

    Collection<EntradaBlog> findAll();
}
