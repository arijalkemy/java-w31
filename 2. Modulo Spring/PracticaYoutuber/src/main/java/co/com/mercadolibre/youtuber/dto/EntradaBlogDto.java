package co.com.mercadolibre.youtuber.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDto {
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
