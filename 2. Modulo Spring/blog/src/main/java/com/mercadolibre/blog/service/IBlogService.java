package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.BlogDTO;

import java.util.HashMap;

public interface IBlogService {
    public void postNewBlog(BlogDTO blogDTO);
    public BlogDTO findById(Integer id);
    public HashMap<Integer, BlogDTO> findAll();
}
