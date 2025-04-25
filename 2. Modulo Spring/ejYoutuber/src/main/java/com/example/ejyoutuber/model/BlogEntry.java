package com.example.ejyoutuber.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class BlogEntry {
    private String id;
    private String title;
    private String authorName;
    private String postedDate;
}
