package com.springexceptions.blog.dto;

import com.springexceptions.blog.model.BlogEntry;

import java.io.Serializable;
import java.util.Date;

public class BlogEntryDTO implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private Date publicationDate;

    public BlogEntryDTO(String author, Integer id, Date publicationDate, String title) {
        this.author = author;
        this.id = id;
        this.publicationDate = publicationDate;
        this.title = title;
    }

    // Mapper
    public BlogEntryDTO(BlogEntry entry) {
        this.author = entry.getAuthor();
        this.id = entry.getId();
        this.publicationDate = entry.getPublicationDate();
        this.title = entry.getTitle();
    }

    public BlogEntryDTO() {
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
