package com.bootcamp.blog.model;

import com.bootcamp.blog.dto.BlogEntryDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogEntry {
    private Integer id;
    private String title;
    private String author;
    private LocalDateTime postDate;
    private static int idsCount;

    public BlogEntry(String title, String author) {
        idsCount++;
        this.id = idsCount;
        this.title = title;
        this.author = author;
        this.postDate = LocalDateTime.now();
    }

    public static BlogEntry buildFromDto(BlogEntryDto dto) {
        return new BlogEntry(dto.getTitle(), dto.getAuthor());
    }
}
