package com.mercadolibre.groupfive.socialmeli.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.groupfive.socialmeli.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto implements Serializable {
    
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate publishDate;
    @JsonProperty("product")
    private ProductDto productDto;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;

    public PostDto(Integer userId, LocalDate publishDate, ProductDto productDto, Integer category, Double price,
                   Boolean hasPromo, Double discount) {
        this.userId = userId;
        this.publishDate = publishDate;
        this.productDto = productDto;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public static List<PostDto> fromPostToPostDto (List<Post> listOfPosts){
        return listOfPosts.stream().map(p -> new PostDto(p.getPostId(), p.getUserId(), p.getPublishDate(), 
        new ProductDto(p.getProduct().getId(), p.getProduct().getType(), p.getProduct().getBrand(), 
        p.getProduct().getName(), p.getProduct().getColor(), p.getProduct().getNotes()),
        p.getCategory(), p.getPrice(), null, null)).toList();
    }

}