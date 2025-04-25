package com.example.ejyoutuber.repository;

import com.example.ejyoutuber.model.BlogEntry;

import java.util.List;

public interface IBlogRepository {
    List<BlogEntry> findAll();
    void loadBlog(BlogEntry blog);
}
