package com.springexceptions.blog.repository;

import com.springexceptions.blog.exception.IdAlreadyInUseException;
import com.springexceptions.blog.exception.IdNotFoundException;
import com.springexceptions.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepository {
    private HashMap<Integer, BlogEntry> entries = new HashMap<>();

    public void addBlogEntry(BlogEntry entry) {
        boolean alreadyExists = entries.containsKey(entry.getId());
        if (alreadyExists) {
            throw new IdAlreadyInUseException("There is already a blog entry with id " + entry.getId());
        }
        entries.put(entry.getId(), entry);
    }

    public BlogEntry getBlogEntry(Integer id) {
        if (!entries.containsKey(id)) {
            throw new IdNotFoundException("Blog entry not found for id " + id);
        }
        return entries.get(id);
    }

    public List<BlogEntry> getAllEntries() {
        return new ArrayList<>(entries.values());
    }

}
