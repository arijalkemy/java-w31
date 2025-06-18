package com.mercadolibre.melifrescosg9w31.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BatchStockDTO {

    @NotNull(message = "Batch number cannot be null.")
    @JsonProperty("batch_number")
    private Integer batchNumber;

    @NotNull(message = "Product ID cannot be null.")
    @JsonProperty("product_id")
    private Long productId;

    @NotNull(message = "Current temperature cannot be null.")
    @JsonProperty("current_temperature")
    private Double currentTemperature;

    @NotNull(message = "Minimum temperature cannot be null.")
    @JsonProperty("minimum_temperature")
    private Double minimumTemperature;

    @NotNull(message = "Initial quantity cannot be null.")
    @Min(value = 1, message = "Initial quantity must be greater than 0.")
    @JsonProperty("initial_quantity")
    private Integer initialQuantity;

    @NotNull(message = "Current quantity cannot be null.")
    @Min(value = 0, message = "Current quantity cannot be less than 0.")
    @JsonProperty("current_quantity")
    private Integer currentQuantity;

    @NotNull(message = "Manufacturing date cannot be null.")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @JsonProperty("manufacturing_date")
    private LocalDate manufacturingDate;

    @NotNull(message = "Manufacturing time cannot be null.")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @JsonProperty("manufacturing_time")
    private LocalDateTime manufacturingTime;

    @NotNull(message = "Due date cannot be null.")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @JsonProperty("due_date")
    private LocalDate dueDate;

    public BatchStockDTO(@NotNull Integer batchNumber, @NotNull Integer actualQuantity, LocalDate dueDate) {
        this.batchNumber = batchNumber;
        this.currentQuantity = actualQuantity;
        this.dueDate = dueDate;
    }
}