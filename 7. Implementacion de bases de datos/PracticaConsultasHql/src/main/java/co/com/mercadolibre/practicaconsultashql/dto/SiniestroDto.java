package co.com.mercadolibre.practicaconsultashql.dto;


import co.com.mercadolibre.practicaconsultashql.model.Vehiculo;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDto {

    private Long id;
    private Date fechaDelSiniestro;
    private double perdidaEconomica;
    private VehiculoDto vehiculo;
}
