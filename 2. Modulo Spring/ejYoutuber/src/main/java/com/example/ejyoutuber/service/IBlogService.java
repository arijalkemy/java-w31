package com.example.ejyoutuber.service;

import com.example.ejyoutuber.dto.BlogDto;

import java.util.List;

public interface IBlogService {
    String addBlog(BlogDto blog);
    BlogDto findBlogById(String id);
    List<BlogDto> findBlogs();
}
