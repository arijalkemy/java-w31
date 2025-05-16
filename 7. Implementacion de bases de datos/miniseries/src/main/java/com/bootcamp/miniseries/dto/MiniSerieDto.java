package com.bootcamp.miniseries.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MiniSerieDto implements Serializable {
    private Long id;
    private String name;
    private BigDecimal rating;
    private Integer amountOfAwards;
}
