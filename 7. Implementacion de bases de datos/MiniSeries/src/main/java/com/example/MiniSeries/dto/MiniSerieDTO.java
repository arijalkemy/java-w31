package com.example.MiniSeries.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MiniSerieDTO {
    private Long id;
    private String name;
    private Double rating;
    private int amount_of_awards;
}
