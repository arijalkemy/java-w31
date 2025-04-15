package co.com.mercadolibre.concesionario.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class VehicleDto {
    private Long id;    
    private String brand, model;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate manufacturingDate;
    private long numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<ServiceDto> listOfServices;
    private int countOfOwners;
}
