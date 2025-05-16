package com.example.joyeria.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO implements Serializable {
    private String message;
}
