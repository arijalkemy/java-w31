package siniestros.vehiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String licensePlate;
    private String brand;
    private String model;
    private Integer yearOfManufacture;
    private Integer wheels;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Set<InsuranceClaim> claims;
}
