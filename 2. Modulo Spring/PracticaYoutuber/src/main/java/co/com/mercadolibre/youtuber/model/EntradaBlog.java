package co.com.mercadolibre.youtuber.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

}
