package com.mercadolibre.melifrescosg9w31.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "batch", schema = "frescosG9")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "batch_number", nullable = false, unique = true)
    private Integer batchNumber;

    @NotNull
    @Column(name = "initial_quantity", nullable = false)
    private Integer initialQuantity;

    @NotNull
    @Column(name = "actual_quantity", nullable = false)
    private Integer actualQuantity;

    @Column(name = "manufacturing_datetime")
    private LocalDateTime manufacturingDatetime;

    @NotNull
    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;

    @Column(name = "registration_temp", precision = 5, scale = 1)
    private BigDecimal registrationTemp;

    @Column(name = "minimum_temp", precision = 5, scale = 1)
    private BigDecimal minimumTemp;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sector_id", nullable = false)
    private Sector sector;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "inbound_order_id", nullable = false)
    private InboundOrder inboundOrder;
}
