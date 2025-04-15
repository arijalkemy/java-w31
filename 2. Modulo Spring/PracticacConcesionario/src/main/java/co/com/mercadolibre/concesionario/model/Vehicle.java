package co.com.mercadolibre.concesionario.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {
        private Long id;
        private String brand, model;
        private LocalDate manufacturingDate;
        private long numberOfKilometers;
        private int doors;
        private double price;
        private String currency;
        private List<Service> listOfServices;
        private int countOfOwners;
}
