package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.dto.BlogDTO;
import com.mercadolibre.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository {

    private HashMap<Integer, Blog> blogs = new HashMap<>();


    @Override
    public void saveNewBlog(Blog blog) {
        blogs.put(blog.getId(), blog);
    }

    @Override
    public Map<Integer, Blog> findAll() {
        return blogs;
    }

    @Override
    public Blog findById(Integer id) {
        return blogs.get(id);
    }
}
