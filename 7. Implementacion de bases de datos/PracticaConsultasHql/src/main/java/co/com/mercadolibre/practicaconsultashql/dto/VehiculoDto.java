package co.com.mercadolibre.practicaconsultashql.dto;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {

    private Long id;
    private String patente, marca, modelo;
    private Date anioDeFabricacion;
    private int cantidadDeRuedas;
    private Set<SiniestroDto> siniestros;
    private List<String> patentesUsed;
}
