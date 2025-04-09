package com.mercadolibre.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    private Integer id_blog;
    private String blog_title;
    private String author_name;
    private String date_of_publication;
}
