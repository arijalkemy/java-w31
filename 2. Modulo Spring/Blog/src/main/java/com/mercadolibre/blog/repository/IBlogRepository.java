package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntryBlog;

import java.util.Collection;
import java.util.Optional;

public interface IBlogRepository {
    EntryBlog save(EntryBlog blog);

    Optional<EntryBlog> findById(Integer id);

    Collection<EntryBlog> findAll();
}
