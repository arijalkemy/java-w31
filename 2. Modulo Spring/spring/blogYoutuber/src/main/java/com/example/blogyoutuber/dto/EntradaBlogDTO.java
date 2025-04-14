package com.example.blogyoutuber.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDTO {
    private int id;
    private String titulo;
    private String nombre;
    private String fechaPublicacion;
}
