package com.mercadolibre.melifrescosg9w31.unit.DTO;

import com.mercadolibre.melifrescosg9w31.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleDTOTest {
    @Test
    void testNoArgsConstructorAndSetter() {
        SampleDTO dto = new SampleDTO();
        dto.setRandom(42);
        assertEquals(42, dto.getRandom());
    }

    @Test
    void testAllArgsConstructorAndGetter() {
        SampleDTO dto = new SampleDTO(99);
        assertEquals(99, dto.getRandom());
    }
}
