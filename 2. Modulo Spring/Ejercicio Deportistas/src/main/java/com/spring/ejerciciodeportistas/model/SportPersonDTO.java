package com.spring.ejerciciodeportistas.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class SportPersonDTO implements Serializable {
    private String name;
    private String surname;
    private String sport;
}
