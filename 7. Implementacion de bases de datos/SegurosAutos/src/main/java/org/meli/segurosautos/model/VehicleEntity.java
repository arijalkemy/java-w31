package org.meli.segurosautos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate;
    private String brand;
    private String model;
    private Integer manufactureYear;
    private Integer numberOfWheels;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<ClaimEntity> claims;
}
