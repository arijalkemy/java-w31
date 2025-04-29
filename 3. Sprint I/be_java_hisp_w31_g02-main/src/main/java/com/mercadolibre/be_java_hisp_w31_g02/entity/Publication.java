package com.mercadolibre.be_java_hisp_w31_g02.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    private Integer post_id;
    private LocalDateTime publish_date;
    private Integer category;
    private Double price;
    private Product product;
}
