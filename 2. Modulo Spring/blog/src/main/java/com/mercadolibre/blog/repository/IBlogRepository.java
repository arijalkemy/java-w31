package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.model.Blog;

import java.util.Map;

public interface IBlogRepository {

    public void saveNewBlog(Blog blog);
    public Map<Integer, Blog> findAll();
    public Blog findById(Integer id);

}
