package com.bootcamp.blog.repository;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    void saveBlog(Blog blog);
    Blog getById(Long id);
    List<Blog> getAll();
}
