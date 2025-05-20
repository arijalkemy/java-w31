package com.bootcamp.be_java_hisp_w31_g09.mapper;

import com.bootcamp.be_java_hisp_w31_g09.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.RequestPostDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.RequestPromoPostDTO;
import com.bootcamp.be_java_hisp_w31_g09.entity.Post;
import com.bootcamp.be_java_hisp_w31_g09.entity.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PostMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static ProductDTO productToDto(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public static PromoPostDTO toPromoDto(Post post) {
        return new PromoPostDTO(
                post.getUserId(), // user_id
                post.getId(),       // post_id
                post.getDate(),
                productToDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()    // suponiendo que este método hace el cálculo con descuent
        );
    }

    public static Post mapToPost(RequestPostDTO requestPostDTO) {
        LocalDate parsedDate = LocalDate.parse(requestPostDTO.getDate(), FORMATTER);

        Product product = new Product(
                requestPostDTO.getProduct().getId(),
                requestPostDTO.getProduct().getName(),
                requestPostDTO.getProduct().getType(),
                requestPostDTO.getProduct().getBrand(),
                requestPostDTO.getProduct().getColor(),
                requestPostDTO.getProduct().getNotes());

        Post post = new Post(requestPostDTO.getUserId(),
                parsedDate,
                product,
                requestPostDTO.getCategory(),
                requestPostDTO.getPrice(),
                Boolean.FALSE,
                0.0);

        return post;
    }
    public static Post mapToPromoPost(RequestPromoPostDTO requestPromoPostDTO) {
        LocalDate parsedDate = LocalDate.parse(requestPromoPostDTO.getDate(), FORMATTER);
        Product product = new Product(
                requestPromoPostDTO.getProduct().getId(),
                requestPromoPostDTO.getProduct().getName(),
                requestPromoPostDTO.getProduct().getType(),
                requestPromoPostDTO.getProduct().getBrand(),
                requestPromoPostDTO.getProduct().getColor(),
                requestPromoPostDTO.getProduct().getNotes());

        Post post = new Post(requestPromoPostDTO.getUserId(),
                parsedDate,
                product,
                requestPromoPostDTO.getCategory(),
                requestPromoPostDTO.getPrice(),
                requestPromoPostDTO.getHasPromo(),
                requestPromoPostDTO.getDiscount());

        return post;
    }
}
