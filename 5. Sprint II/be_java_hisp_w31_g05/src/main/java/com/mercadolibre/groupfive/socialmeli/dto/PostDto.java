package com.mercadolibre.groupfive.socialmeli.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.groupfive.socialmeli.model.Post;

import jakarta.validation.constraints.Min;
import lombok.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto implements Serializable {

    @JsonProperty("user_id")
    @NotNull(message = "El id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía")
    private LocalDate publishDate;
    @JsonProperty("product")
    @Valid
    private ProductDto productDto;
    @NotNull(message = "El campo no puede estar vacío")
    private Integer category;
    @NotNull(message = "El campo no puede estar vacío")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    @Positive(message = "El precio no puede ser menor a 0")
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;


    public static List<PostDto> fromPostToPostDto(List<Post> listOfPosts) {
        return listOfPosts.stream()
                .map(p -> new PostDto(
                        p.getPostId(),
                        p.getUserId(),
                        p.getPublishDate(),
                        new ProductDto(
                                p.getProduct().getId(),
                                p.getProduct().getType(),
                                p.getProduct().getBrand(),
                                p.getProduct().getName(),
                                p.getProduct().getColor(),
                                p.getProduct().getNotes()),
                        p.getCategory(),
                        p.getPrice(),
                        Boolean.FALSE,
                        0.0))
                .toList();
    }

}