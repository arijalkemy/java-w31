package com.example.MiniSeries.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMiniSerieDTO {
    private String name;
    private Double rating;
    private int amount_of_awards;

}
