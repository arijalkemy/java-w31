package com.bootcamp.be_java_hisp_w31_g09.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPostsResponseDTO {
    @JsonPropertyOrder({ "user_id", "posts" })
    private Integer id;
    private List<PromoPostDTO> posts;
}
