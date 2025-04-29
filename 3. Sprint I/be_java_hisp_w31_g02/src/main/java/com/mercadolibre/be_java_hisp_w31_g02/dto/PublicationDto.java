package com.mercadolibre.be_java_hisp_w31_g02.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class PublicationDto {
    
    @NotNull(message = "The user_id must not be null")
    private Integer user_id;

    @NotBlank(message = "The date must not be blank")
    @Pattern(
        regexp = "\\d{2}-\\d{2}-\\d{4}",
        message = "The date must follow the format yyyy-MM-dd"
    )
    private String date;

    @NotNull(message = "Product must not be null")
    @Valid
    private ProductDto product;
    
    @NotNull(message = "Category must not be null")
    private Integer category;

    @Positive(message = "Price must be zero or a positive number")
    private Double price;

    private Boolean has_promo;
    private Double discount;
    private String promo_exp_date;

}
