package com.example.be_java_hisp_w31_g01.dto;

import com.example.be_java_hisp_w31_g01.entity.Seller;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedResponseDto {
    @NotNull(message = "El  id no puede estar vacío. El id debe ser mayor a cero.")
    @Positive(message = "El  id no puede estar vacío. El id debe ser mayor a cero.")
    @Min(value = 1, message = "El  id no puede estar vacío. El id debe ser mayor a cero.")
    private int user_id;
    private String user_name;
    private List<Seller> followed;
}
