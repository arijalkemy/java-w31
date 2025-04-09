package com.mercadolibre.bootcamp.blog.repository;

import com.mercadolibre.bootcamp.blog.dto.BlogEntryDto;
import com.mercadolibre.bootcamp.blog.model.BlogEntry;

import java.util.List;
import java.util.Map;

public interface IBlogRepository {

    BlogEntry save(BlogEntry blogEntry);

    BlogEntry getBlogEntry(Long id);

    void updateBlogEntry(BlogEntry blogEntry);

    void removeBlogEntry(Long id);

    List<BlogEntry> getAllBlogEntries();

}
