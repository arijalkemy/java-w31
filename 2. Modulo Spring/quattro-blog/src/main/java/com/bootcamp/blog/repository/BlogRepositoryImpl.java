package com.bootcamp.blog.repository;

import com.bootcamp.blog.exceptions.NotFoundException;
import com.bootcamp.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    private List<BlogEntry> blogEntries = new ArrayList<>();

    @Override
    public List<BlogEntry> getAll() {
        return blogEntries;
    }

    @Override
    public BlogEntry getById(Integer id) {
        return blogEntries.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public BlogEntry getByTitle(String title) {
        return blogEntries.stream()
                .filter(entry -> entry.getTitle().toLowerCase().contains(title.toLowerCase()))
                .findFirst().orElse(null);
    }

    @Override
    public BlogEntry addEntry(BlogEntry entry) {
        blogEntries.add(entry);
        return entry;
    }

    @Override
    public Boolean existsByTitle(String title) {
        Optional<BlogEntry> blog = blogEntries.stream()
                .filter(entry -> entry.getTitle().toLowerCase().contains(title.toLowerCase()))
                .findFirst();
        return blog.isPresent();
    }
}
