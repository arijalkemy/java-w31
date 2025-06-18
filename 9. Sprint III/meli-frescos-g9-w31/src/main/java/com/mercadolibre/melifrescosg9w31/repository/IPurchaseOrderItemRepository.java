package com.mercadolibre.melifrescosg9w31.repository;

import com.mercadolibre.melifrescosg9w31.entity.PurchaseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem, Long> {
    // Métodos personalizados si es necesario
}
