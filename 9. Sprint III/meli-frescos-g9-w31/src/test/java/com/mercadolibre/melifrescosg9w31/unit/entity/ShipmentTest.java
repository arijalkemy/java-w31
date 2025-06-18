package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.Carrier;
import com.mercadolibre.melifrescosg9w31.entity.PurchaseOrder;
import com.mercadolibre.melifrescosg9w31.entity.Shipment;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ShipmentTest {

    @Test
    void testNoArgsConstructor() {
        Shipment shipment = new Shipment();
        assertNull(shipment.getId());
        assertNull(shipment.getDispatchDate());
        assertNull(shipment.getShipmentState());
        assertNull(shipment.getDetails());
        assertNull(shipment.getPurchaseOrder());
        assertNull(shipment.getCarrier());
    }

    @Test
    void testAllArgsConstructor() {
        Instant now = Instant.now();
        PurchaseOrder purchaseOrder = mock(PurchaseOrder.class);
        Carrier carrier = mock(Carrier.class);

        Shipment shipment = new Shipment(1L, now, "PENDING", "Some details", purchaseOrder, carrier);

        assertEquals(1L, shipment.getId());
        assertEquals(now, shipment.getDispatchDate());
        assertEquals("PENDING", shipment.getShipmentState());
        assertEquals("Some details", shipment.getDetails());
        assertEquals(purchaseOrder, shipment.getPurchaseOrder());
        assertEquals(carrier, shipment.getCarrier());
    }

    @Test
    void testGettersAndSetters() {
        Shipment shipment = new Shipment();
        Instant newDate = Instant.now().plusSeconds(3600);
        PurchaseOrder newPurchaseOrder = mock(PurchaseOrder.class);
        Carrier newCarrier = mock(Carrier.class);

        shipment.setId(2L);
        shipment.setDispatchDate(newDate);
        shipment.setShipmentState("SHIPPED");
        shipment.setDetails("More details");
        shipment.setPurchaseOrder(newPurchaseOrder);
        shipment.setCarrier(newCarrier);

        assertEquals(2L, shipment.getId());
        assertEquals(newDate, shipment.getDispatchDate());
        assertEquals("SHIPPED", shipment.getShipmentState());
        assertEquals("More details", shipment.getDetails());
        assertEquals(newPurchaseOrder, shipment.getPurchaseOrder());
        assertEquals(newCarrier, shipment.getCarrier());
    }

    @Test
    void testEqualsAndHashCode() {
        Instant date1 = Instant.parse("2024-01-01T10:00:00Z");
        Instant date2 = Instant.parse("2024-01-01T10:00:00Z"); // Same instant
        Instant date3 = Instant.parse("2024-01-02T10:00:00Z");

        PurchaseOrder po1 = new PurchaseOrder();
        po1.setId(1L);
        PurchaseOrder po2 = new PurchaseOrder();
        po2.setId(1L); // Same ID, for equals check
        PurchaseOrder po3 = new PurchaseOrder();
        po3.setId(2L);

        Carrier c1 = new Carrier();
        c1.setId(1L);
        Carrier c2 = new Carrier();
        c2.setId(1L); // Same ID, for equals check
        Carrier c3 = new Carrier();
        c3.setId(2L);

        Shipment shipment1 = new Shipment(1L, date1, "STATE1", "Details1", po1, c1);
        Shipment shipment2 = new Shipment(1L, date2, "STATE1", "Details1", po2, c2);
        Shipment shipment3 = new Shipment(2L, date3, "STATE2", "Details2", po3, c3);
        Shipment shipment4 = new Shipment(1L, null, null, null, null, null);
        Shipment shipment5 = new Shipment(1L, null, null, null, null, null);


        assertEquals(shipment1, shipment2);
        assertNotEquals(shipment1, shipment3);
        assertNotEquals(shipment1, null);
        assertNotEquals(shipment1, new Object());
        assertEquals(shipment4, shipment5);

        assertEquals(shipment1.hashCode(), shipment2.hashCode());
        assertNotEquals(shipment1.hashCode(), shipment3.hashCode());
        assertEquals(shipment4.hashCode(), shipment5.hashCode());
    }

    @Test
    void testToString() {
        Instant now = Instant.now();
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(10L); // Set ID for a more realistic toString
        Carrier carrier = new Carrier();
        carrier.setId(20L); // Set ID for a more realistic toString

        Shipment shipment = new Shipment(5L, now, "DELIVERED", "Item delivered", purchaseOrder, carrier);

        String expectedToString = "Shipment(id=5, dispatchDate=" + now + ", shipmentState=DELIVERED, details=Item delivered, purchaseOrder=" + purchaseOrder + ", carrier=" + carrier + ")";
        assertEquals(expectedToString, shipment.toString());
    }
}