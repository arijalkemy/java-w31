package co.com.mercadolibre.concesionario.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceDto {

    private LocalDate date;
    private int kilometers;
    private String description;
}
