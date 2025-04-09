package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.dto.BlogPostDTO;
import com.mercadolibre.blog.model.BlogPost;

import java.util.HashMap;
import java.util.Map;

public interface IBlogPostRepository {
    public void saveBlog(BlogPost blog);
    public BlogPost findById(Integer id);
    public Map<Integer, BlogPost> findAll();
}
