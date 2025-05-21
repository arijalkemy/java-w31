package com.mercadolibre.showroom.model;



import com.mercadolibre.showroom.dto.ClothingItemDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(indexName = "sale")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    private String number;

    @Field(type = FieldType.Date)
    private LocalDate date;           // Fecha de la venta

    private Double total;             // Total de la venta

    private String paymentMethod;     // Medio de pago

    private List<ClothingItem> clothingItems = new ArrayList<>();;

}
