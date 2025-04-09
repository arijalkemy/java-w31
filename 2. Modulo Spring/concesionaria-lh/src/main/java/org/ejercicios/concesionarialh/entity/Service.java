package org.ejercicios.concesionarialh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@AllArgsConstructor
public class Service {
    private String date;
    private String kilometers;
    private String descriptions;
}
