package com.example.Blog.Repository;

import java.util.List;
import com.example.Blog.Entities.BlogEntry;

public interface BlogRepository {
    public void newEntry(BlogEntry entry);

    public BlogEntry getEntry(String id);

    public List<BlogEntry> getAll();
}
