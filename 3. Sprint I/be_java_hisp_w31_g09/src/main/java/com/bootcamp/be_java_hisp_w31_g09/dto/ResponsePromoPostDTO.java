package com.bootcamp.be_java_hisp_w31_g09.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePromoPostDTO {
    @JsonPropertyOrder({ "user_id","user_name", "promo_posts" })
    private Integer id;
    private String name;
    private List<PromoPostDTO> posts;
}
