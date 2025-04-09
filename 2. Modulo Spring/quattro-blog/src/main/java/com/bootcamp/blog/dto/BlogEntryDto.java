package com.bootcamp.blog.dto;

import com.bootcamp.blog.model.BlogEntry;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BlogEntryDto implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private String postDate;

    public static BlogEntryDto buildFromBlogEntry(BlogEntry blogEntry) {
        return new BlogEntryDto(blogEntry.getId(),
                blogEntry.getTitle(),
                blogEntry.getAuthor(),
                blogEntry.getPostDate().toString());
    }
}
