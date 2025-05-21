package com.showroom.extra.dto;

import com.showroom.extra.model.Prenda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private LocalDate fecha;
    private Double total;
    private String medioPago;
    private List<Long> prendasId;
}
