package com.springexceptions.blog.model;

import java.util.Date;

public class BlogEntry {
    private Integer id;
    private String title;
    private String author;
    private Date publicationDate;

    public String getAuthor() {
        return author;
    }

    public Integer getId() {
        return id;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public BlogEntry(String author, Integer id, Date publicationDate, String title) {
        this.author = author;
        this.id = id;
        this.publicationDate = publicationDate;
        this.title = title;
    }
}
