package org.example.blog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {

    private int id;
    private String titulo;
    private String autor;
    private LocalDate publicacionDate;

}
