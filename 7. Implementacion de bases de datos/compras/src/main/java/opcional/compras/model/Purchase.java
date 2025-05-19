package opcional.compras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "purchases")
@IdClass(value = PurchaseKey.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    @Id
    private Long clientId;
    @Id
    private Date date;
    private Double totalWithoutDiscount;
    private Double discount;
    private Double totalDiscountsApplied;
}
