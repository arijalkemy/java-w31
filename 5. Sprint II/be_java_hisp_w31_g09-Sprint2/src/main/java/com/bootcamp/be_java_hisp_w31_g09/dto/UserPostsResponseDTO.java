package com.bootcamp.be_java_hisp_w31_g09.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPostsResponseDTO {
    @JsonPropertyOrder({ "user_id", "posts" })
    private Integer id;
    private List<PromoPostDTO> posts;
}
