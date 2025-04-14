package com.example.blogyoutuber.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombre;
    private String fechaPublicacion;
}
