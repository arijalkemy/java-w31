package com.mercadolibre.melifrescosg9w31.exceptions;

import com.mercadolibre.melifrescosg9w31.dtos.ProductStockError;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StockException extends RuntimeException {
    private final List<ProductStockError> errors;

    public StockException(List<ProductStockError> errors) {
        super(
                errors != null && !errors.isEmpty() ?
                        errors.stream()
                                .map(e -> e.getProductId() + ": " + e.getError())
                                .collect(Collectors.joining(", "))
                        : "Sin detalles"
        );
        this.errors = errors;
    }
}
