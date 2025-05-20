package com.miniserie.miniserie_jpa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class MiniSerieResponseDto {
    private String name;
    private Double rating;
    private Integer amountOfAwards;
}
