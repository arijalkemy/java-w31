package com.mercadolibre.groupfive.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class UserDto implements Serializable {
    @JsonProperty("user_id")
    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer id;
    @JsonProperty("user_name")
    private String name;
    private List<Integer> followers;
    private List<Integer> followeds;
    private List<PostDto> posts;
    private Integer followersCount;
    @JsonProperty("promo_products_count")
    private Integer amountOfPromos;
    private List<UserDto> followersList;
    private List<UserDto> followedList;
}
