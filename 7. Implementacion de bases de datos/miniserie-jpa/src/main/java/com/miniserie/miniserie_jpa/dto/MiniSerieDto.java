package com.miniserie.miniserie_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MiniSerieDto {
    private Long id;
    private String name;
    private Double rating;
    private Integer amountOfAwards;
}
