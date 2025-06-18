package com.mercadolibre.melifrescosg9w31.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrderRequest {
    @NotNull(message = "Order number cannot be null.")
    @JsonProperty("order_number")
    private Integer orderNumber;

    @NotNull(message = "Order date cannot be null.")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @JsonProperty("order_date")
    private LocalDate orderDate;

    @NotNull(message = "Section cannot be null.")
    @Valid
    @JsonProperty("section")
    private SectorRequestDTO section;

    @NotEmpty(message = "Batch stock list cannot be empty.")
    @Valid
    @JsonProperty("batch_stock")
    private List<BatchStockDTO> batchStock;
}
