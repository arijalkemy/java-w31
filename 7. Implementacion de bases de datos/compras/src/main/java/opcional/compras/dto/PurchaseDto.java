package opcional.compras.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto {
    private Long clientId;
    private Date date;
    private Double totalWithoutDiscount;
    private Double discount;
    private Double totalDiscountsApplied;
    private Set<ItemDto> items;
}
