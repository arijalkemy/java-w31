package com.springexceptions.blog.service;

import com.springexceptions.blog.dto.BlogEntryDTO;

import java.util.List;

public interface IBlogEntryService {

    void save(BlogEntryDTO entry);
    BlogEntryDTO get(Integer id);
    List<BlogEntryDTO> getAllEntries();

}
