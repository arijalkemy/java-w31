package com.example.showroomrelacional.entity;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class CreateSaleRequest {
    private LocalDate date;
    private Double totalPrice;
    private String paymentMethod;
    private List<Long> clothesIds;
}