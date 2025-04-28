package com.example.be_java_hisp_w31_g01.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDto {
    @NotNull(message = "El ID de usuario es obligatorio")
    @Positive(message = "El ID de usuario debe ser un número positivo")
    private int userId;

    private int postId;

    @NotNull(message = "La fecha es obligatoria")
    @PastOrPresent(message = "No puede ser una fecha futura")
    private LocalDate date;

    @NotNull(message = "El producto es obligatorio")
    @Valid
    private ProductDto product;

    @NotNull(message = "La categoría es obligatoria")
    @Positive(message = "La categoría debe ser un número positivo")
    private int category;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a cero")
    private double price;

    @NotNull(message = "Has promo es obligatorio ")
    @AssertTrue(message = "Has promo debe ser true")
    private boolean hasPromo;

    @NotNull(message = "El descuento es obligatorio")
    @Positive(message = "El descuento debe ser mayor a cero")
    private double discount;
}
