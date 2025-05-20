package com.bootcamp.showroom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    private String number;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<ClothingDTO> clothesList;

}
