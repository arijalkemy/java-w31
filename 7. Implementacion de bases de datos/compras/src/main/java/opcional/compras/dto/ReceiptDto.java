package opcional.compras.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDto {
    private Long id;
    private String type;
    private Double total;
    private Boolean approved;
    private String paymentMethod;
    private Double totalWithoutDiscount;
    private Double discount;
    private Double totalDiscountsApplied;
    private PurchaseDto purchase;
}
