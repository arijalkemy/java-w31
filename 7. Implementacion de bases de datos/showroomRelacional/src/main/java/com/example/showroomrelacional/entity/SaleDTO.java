package com.example.showroomrelacional.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class SaleDTO {
    private Long id;
    private LocalDate date;
    private Double totalPrice;
    private String paymentMethod;
    private List<ClothDTO> clothes;
}