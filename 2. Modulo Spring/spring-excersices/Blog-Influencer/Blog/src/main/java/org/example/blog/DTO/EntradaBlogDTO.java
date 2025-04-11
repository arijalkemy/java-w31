package org.example.blog.DTO;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EntradaBlogDTO {
    private int id;
    private String titulo;
    private String autor;
    private LocalDate publicacionDate;

}
