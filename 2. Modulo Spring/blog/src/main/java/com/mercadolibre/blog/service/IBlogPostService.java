package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.BlogPostDTO;
import com.mercadolibre.blog.model.BlogPost;

import java.util.HashMap;

public interface IBlogPostService {

    public void createBlog(BlogPostDTO blog);
    public BlogPostDTO getBlogById(Integer id);
    public HashMap<Integer, BlogPostDTO> getListOfBlogs();

}
