package com.bootcamp.ejerciciodeportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class ExceptionDto{
    private String message;

    public String getMessage() {
        return message;
    }

    public ExceptionDto(String message) {
        this.message = message;
    }
}
