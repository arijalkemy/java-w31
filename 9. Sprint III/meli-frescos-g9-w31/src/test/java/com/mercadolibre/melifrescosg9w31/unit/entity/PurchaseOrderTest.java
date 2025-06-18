package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.Buyer;
import com.mercadolibre.melifrescosg9w31.entity.PurchaseOrder;
import com.mercadolibre.melifrescosg9w31.entity.Warehouse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchaseOrderTest {

    @Test
    void testGettersAndSetters() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        Long id = 1L;
        LocalDate creationDate = LocalDate.now();
        String state = "CARRITO";
        BigDecimal totalPrice = new BigDecimal("150.00");
        Buyer buyer = new Buyer();
        Warehouse warehouse = new Warehouse();

        purchaseOrder.setId(id);
        purchaseOrder.setCreationDate(creationDate);
        purchaseOrder.setState(state);
        purchaseOrder.setTotalPrice(totalPrice);
        purchaseOrder.setBuyer(buyer);
        purchaseOrder.setWarehouse(warehouse);

        assertEquals(id, purchaseOrder.getId());
        assertEquals(creationDate, purchaseOrder.getCreationDate());
        assertEquals(state, purchaseOrder.getState());
        assertEquals(totalPrice, purchaseOrder.getTotalPrice());
        assertEquals(buyer, purchaseOrder.getBuyer());
        assertEquals(warehouse, purchaseOrder.getWarehouse());
    }
}
