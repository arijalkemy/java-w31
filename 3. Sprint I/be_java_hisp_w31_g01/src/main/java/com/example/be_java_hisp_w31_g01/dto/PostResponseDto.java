package com.example.be_java_hisp_w31_g01.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResponseDto {
    private int postId;
    private int userId;
    private LocalDate date;
    private ProductDto product;
    private int category;
    private double price;
}
