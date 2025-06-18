package com.mercadolibre.melifrescosg9w31.unit.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.melifrescosg9w31.dtos.request.InboundOrderRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.InboundOrderRequestWrapperDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InboundOrderRequestWrapperDTOTest {

    @Test
    void testNoArgsConstructor() {
        com.mercadolibre.melifrescosg9w31.dtos.request.InboundOrderRequestWrapperDTO dto = new InboundOrderRequestWrapperDTO();
        assertNull(dto.getInboundOrder());
    }

    @Test
    void testAllArgsConstructorAndGetters() {
        InboundOrderRequest inboundOrder = new InboundOrderRequest();
        InboundOrderRequestWrapperDTO dto = new InboundOrderRequestWrapperDTO(inboundOrder);
        assertEquals(inboundOrder, dto.getInboundOrder());
    }

    @Test
    void testSetters() {
        InboundOrderRequest inboundOrder = new InboundOrderRequest();
        InboundOrderRequestWrapperDTO dto = new InboundOrderRequestWrapperDTO();
        dto.setInboundOrder(inboundOrder);
        assertEquals(inboundOrder, dto.getInboundOrder());
    }

    @Test
    void testEqualsAndHashCode() {
        InboundOrderRequest inboundOrder = new InboundOrderRequest();
        InboundOrderRequestWrapperDTO dto1 = new InboundOrderRequestWrapperDTO(inboundOrder);
        InboundOrderRequestWrapperDTO dto2 = new InboundOrderRequestWrapperDTO(inboundOrder);
        InboundOrderRequestWrapperDTO dto3 = new InboundOrderRequestWrapperDTO(null);

        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());
    }

    @Test
    void testToString() {
        InboundOrderRequest inboundOrder = new InboundOrderRequest();
        InboundOrderRequestWrapperDTO dto = new InboundOrderRequestWrapperDTO(inboundOrder);
        String str = dto.toString();
        assertTrue(str.contains("InboundOrderRequestWrapperDTO"));
        assertTrue(str.contains("inboundOrder"));
    }

    @Test
    void testJsonProperty() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InboundOrderRequest inboundOrder = new InboundOrderRequest();
        InboundOrderRequestWrapperDTO dto = new InboundOrderRequestWrapperDTO(inboundOrder);

        String json = mapper.writeValueAsString(dto);
        assertTrue(json.contains("inbound_order"));

        InboundOrderRequestWrapperDTO deserialized = mapper.readValue(json, InboundOrderRequestWrapperDTO.class);
        assertNotNull(deserialized);
    }
}
