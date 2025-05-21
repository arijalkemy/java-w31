package com.showroom.extra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.util.List;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Document(indexName = "ventas")
public class Venta {
    @Id
    private String numero;
    private LocalDate fecha;
    private Double total;
    private String medioPago;
    private List<Prenda> prendas;
}
