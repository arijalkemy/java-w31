package com.bootcamp.ejercicio_linktracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDto implements Serializable {
    private Integer id;
    private String url;
    private Integer visitCount;
    private Boolean isValid;
}
