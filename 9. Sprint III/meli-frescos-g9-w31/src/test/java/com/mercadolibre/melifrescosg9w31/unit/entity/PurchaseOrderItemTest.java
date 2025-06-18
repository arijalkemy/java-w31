package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchaseOrderItemTest {

    @Test
    void testGettersAndSetters() {
        PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();

        Long id = 1L;
        Integer amount = 10;
        BigDecimal unitPriceAtSale = new BigDecimal("15.00");
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        Product product = new Product(1L, "Product Name", "Description", new BigDecimal("10.00"), new ProductType(), new Seller());
        Batch batch = new Batch();

        purchaseOrderItem.setId(id);
        purchaseOrderItem.setAmount(amount);
        purchaseOrderItem.setUnitPriceAtSale(unitPriceAtSale);
        purchaseOrderItem.setPurchaseOrder(purchaseOrder);
        purchaseOrderItem.setProduct(product);
        purchaseOrderItem.setBatch(batch);

        assertEquals(id, purchaseOrderItem.getId());
        assertEquals(amount, purchaseOrderItem.getAmount());
        assertEquals(unitPriceAtSale, purchaseOrderItem.getUnitPriceAtSale());
        assertEquals(purchaseOrder, purchaseOrderItem.getPurchaseOrder());
        assertEquals(product, purchaseOrderItem.getProduct());
        assertEquals(batch, purchaseOrderItem.getBatch());
    }
}
