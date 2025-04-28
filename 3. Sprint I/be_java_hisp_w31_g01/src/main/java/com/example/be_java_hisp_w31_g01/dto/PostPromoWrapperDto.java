package com.example.be_java_hisp_w31_g01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoWrapperDto {
    private int userId;
    private String userName;
    private List<PostPromoDto> posts;

}
