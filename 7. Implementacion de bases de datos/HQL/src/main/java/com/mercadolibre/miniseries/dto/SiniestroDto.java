package com.mercadolibre.miniseries.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class SiniestroDto {
    private Long id;
    private Date fecha;
    private Double perdida;

    }

