package com.mercadolibre.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkStatsDTO {
    private Integer id;
    private Integer redirectCount;
}
