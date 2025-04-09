package com.mercadolibre.bootcamp.blog.model;


import com.mercadolibre.bootcamp.blog.dto.BlogEntryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogEntry {

    private Long id;
    private String title;
    private String autor;
    private String publicationDate;

    public BlogEntry (BlogEntryDto blogEntryDto){
        this.id = blogEntryDto.getId();
        this.title = blogEntryDto.getTitle();
        this.autor = blogEntryDto.getAutor();
        this.publicationDate = blogEntryDto.getPublicationDate();
    }
}
