package com.meli.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {
    private String id;
    private String title;
    private String authorName;
    private String publicationDate;
}
