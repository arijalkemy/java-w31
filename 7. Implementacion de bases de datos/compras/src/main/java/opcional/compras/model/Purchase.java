package opcional.compras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JoinColumn(name = "date_id")
    private Set<Item> items;
}
