package com.example.Blog.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.Blog.Entities.BlogEntry;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    private List<BlogEntry> blogEntries;

    public BlogRepositoryImpl() {
        this.blogEntries = new ArrayList<BlogEntry>();
    }

    @Override
    public void newEntry(BlogEntry entry) {
        blogEntries.add(entry);
    }

    @Override
    public BlogEntry getEntry(String id) {
        return blogEntries.stream()
                          .filter(b -> b.getId().equals(id))
                          .findFirst()
                          .orElse(null);
    }

    @Override
    public List<BlogEntry> getAll() {
        return blogEntries;
    }
    
}
