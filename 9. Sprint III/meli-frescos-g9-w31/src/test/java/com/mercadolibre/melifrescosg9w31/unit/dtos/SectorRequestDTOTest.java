package com.mercadolibre.melifrescosg9w31.unit.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.melifrescosg9w31.dtos.request.SectorRequestDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectorRequestDTOTest {

  @Test
  void testNoArgsConstructor() {
    SectorRequestDTO dto = new SectorRequestDTO();
    assertNull(dto.getSectorCode());
    assertNull(dto.getWarehouseCode());
  }

  @Test
  void testAllArgsConstructorAndGetters() {
    SectorRequestDTO dto = new SectorRequestDTO(1, 2);
    assertEquals(1, dto.getSectorCode());
    assertEquals(2, dto.getWarehouseCode());
  }

  @Test
  void testSetters() {
    SectorRequestDTO dto = new SectorRequestDTO();
    dto.setSectorCode(10);
    dto.setWarehouseCode(20);
    assertEquals(10, dto.getSectorCode());
    assertEquals(20, dto.getWarehouseCode());
  }

  @Test
  void testEqualsAndHashCode() {
    SectorRequestDTO dto1 = new SectorRequestDTO(1, 2);
    SectorRequestDTO dto2 = new SectorRequestDTO(1, 2);
    SectorRequestDTO dto3 = new SectorRequestDTO(2, 3);

    assertEquals(dto1, dto2);
    assertNotEquals(dto1, dto3);
    assertEquals(dto1.hashCode(), dto2.hashCode());
    assertNotEquals(dto1.hashCode(), dto3.hashCode());
  }

  @Test
  void testToString() {
    SectorRequestDTO dto = new SectorRequestDTO(1, 2);
    String str = dto.toString();
    assertTrue(str.contains("SectorRequestDTO"));
    assertTrue(str.contains("sectorCode"));
    assertTrue(str.contains("warehouseCode"));
  }

  @Test
  void testJsonProperty() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    SectorRequestDTO dto = new SectorRequestDTO(1, 2);

    String json = mapper.writeValueAsString(dto);
    assertTrue(json.contains("section_code"));
    assertTrue(json.contains("warehouse_code"));

    SectorRequestDTO deserialized = mapper.readValue(json, SectorRequestDTO.class);
    assertEquals(1, deserialized.getSectorCode());
    assertEquals(2, deserialized.getWarehouseCode());
  }
}
