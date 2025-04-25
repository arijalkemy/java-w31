package com.example.ejyoutuber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogDto {
    private String id;
    private String title;
    private String authorName;
    private String postedDate;
}
