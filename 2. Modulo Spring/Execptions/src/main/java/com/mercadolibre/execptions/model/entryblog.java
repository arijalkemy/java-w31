package com.mercadolibre.execptions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class entryblog {
    private Integer id;
    private String title;
    private String Author;
    private LocalDate publishDate;
}
