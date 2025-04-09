package com.meli.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SportModel {
    private int id;
    private String name;
    private int level;
}
