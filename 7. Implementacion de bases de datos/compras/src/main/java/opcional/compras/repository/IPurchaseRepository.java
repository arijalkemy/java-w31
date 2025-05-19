package opcional.compras.repository;

import opcional.compras.model.Purchase;
import opcional.compras.model.PurchaseKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseRepository extends JpaRepository<Purchase, PurchaseKey> {
}
