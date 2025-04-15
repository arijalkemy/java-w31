package com.bootcamp.ejercicio_linktracker.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class CreateLinkDto implements Serializable {
    private String url;
    private String password;
}
