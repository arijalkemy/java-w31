package com.mercadolibre.execptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class entryblogdto {
    private Integer id;
    private String title;
    private String Author;
    private LocalDate publishDate;


}
