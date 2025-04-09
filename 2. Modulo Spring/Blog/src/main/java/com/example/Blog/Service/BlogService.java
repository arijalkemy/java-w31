package com.example.Blog.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.Blog.DTO.BlogEntryDTO;
import com.example.Blog.Entities.BlogEntry;

public interface BlogService {
    public ResponseEntity<String> newEntry(BlogEntry entry);
    public BlogEntryDTO getEntry(String id);
    public List<BlogEntryDTO> getAll();
}
