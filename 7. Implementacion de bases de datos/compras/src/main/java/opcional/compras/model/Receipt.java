package opcional.compras.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "receipts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String type;
    private Double total;
    private Boolean approved;
    private String paymentMethod;
    private Double totalWithoutDiscount;
    private Double discount;
    private Double totalDiscountsApplied;
    @OneToOne(mappedBy = "receipt")
    @JsonBackReference
    private Purchase purchase;
}
