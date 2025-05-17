package co.com.mercadolibre.joyerialasperlas.dto;

import co.com.mercadolibre.joyerialasperlas.enums.Material;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class JewelryDto implements Serializable {

    @JsonProperty("nro identificatorio")
    private Long nroIdentificatorio;

    private String nombre, particularidad;

    private Material material;

    private double peso;

    private boolean ventaONo;

}
