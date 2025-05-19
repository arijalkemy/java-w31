package com.mercadolibre.be_java_hisp_w31_g02.entity;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Promotion {

    Integer promotionId;
    Double discount;
    LocalDate initialDate;
    LocalDate expirationDate;
    Integer publicationId;
    
    public boolean hasCurrentPromo(LocalDate date){
        return date.isBefore(expirationDate) && date.isAfter(initialDate);
    }
}
