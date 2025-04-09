package com.mercadolibre.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostDTO {
    private Integer id_blog;
    private String blog_title;
    private String author_name;
    private String date_of_publication;
}
