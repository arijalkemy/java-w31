package com.mercadolibre.blog.dto;

import com.mercadolibre.blog.model.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class BlogDTO extends Blog {

    public BlogDTO(Integer id, String title, String author, String publishDate) {
        super(id, title, author, publishDate);
    }
}
