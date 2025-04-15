package co.com.mercadolibre.concesionario.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Service {
    private LocalDate date;
    private int kilometers;
    private String description;

}
