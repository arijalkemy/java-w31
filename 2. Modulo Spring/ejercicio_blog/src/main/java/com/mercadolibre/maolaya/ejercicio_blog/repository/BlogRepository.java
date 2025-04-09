package com.mercadolibre.maolaya.ejercicio_blog.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mercadolibre.maolaya.ejercicio_blog.model.BlogEntry;

@Repository
public class BlogRepository {
    private Map<Integer, BlogEntry> blogEntries = new HashMap<>();

    public Boolean existBlogEntry(Integer id) {
        return blogEntries.containsKey(id);
    }

    public void saveBlogEntry(BlogEntry blogEntry) {
        blogEntries.put(blogEntry.getId(), blogEntry);
    }

    public BlogEntry getBlogEntryById(Integer id) {
        return blogEntries.get(id);
    }

    public List<BlogEntry> getAll() {
        return new ArrayList(blogEntries.values());
    }
}
