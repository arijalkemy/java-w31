package co.com.mercadolibre.joyerialasperlas.model;

import co.com.mercadolibre.joyerialasperlas.enums.Material;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder(toBuilder = true)
public class Jewelry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nroIdentificatorio;

    private String nombre, particularidad;

    private Material material;

    private double peso;

    private boolean ventaONo;

}
