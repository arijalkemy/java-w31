package com.bootcamp.blog.services;

import com.bootcamp.blog.dto.BlogDTO;

import java.util.List;

public interface IBlogService {
    Long saveBlog(BlogDTO blogDTO);
    BlogDTO getBlog(Long id);
    List<BlogDTO> getAllBlogs();
}
