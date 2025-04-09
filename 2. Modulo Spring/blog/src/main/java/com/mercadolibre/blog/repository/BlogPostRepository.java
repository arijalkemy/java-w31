package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.dto.BlogPostDTO;
import com.mercadolibre.blog.model.BlogPost;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogPostRepository implements IBlogPostRepository {
    Map<Integer, BlogPost> blogs = new HashMap<>();


    @Override
    public void saveBlog(BlogPost blog) {
        this.blogs.put(blog.getId_blog(), blog);
    }

    @Override
    public BlogPost findById(Integer id) {
        return this.blogs.get(id);
    }

    @Override
    public Map<Integer, BlogPost> findAll() {
        return this.blogs;
    }
}
