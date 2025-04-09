package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogEntry;

import java.util.List;

public interface IBlogRepository {
    List<BlogEntry> getAll();
    BlogEntry getById(Integer id);
    BlogEntry getByTitle(String title);
    BlogEntry addEntry(BlogEntry entry);
    Boolean existsByTitle(String title);
}
