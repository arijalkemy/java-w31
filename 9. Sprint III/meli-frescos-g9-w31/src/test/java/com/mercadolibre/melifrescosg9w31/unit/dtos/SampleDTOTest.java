package com.mercadolibre.melifrescosg9w31.unit.dtos;

import com.mercadolibre.melifrescosg9w31.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SampleDTOTest {

    @Test
    void testNoArgsConstructor() {
        SampleDTO sampleDTO = new SampleDTO();
        assertEquals(0, sampleDTO.getRandom());
    }

    @Test
    void testParameterizedConstructor() {
        int expectedRandom = 123;
        SampleDTO sampleDTO = new SampleDTO(expectedRandom);
        assertEquals(expectedRandom, sampleDTO.getRandom());
    }

    @Test
    void testGettersAndSetters() {
        SampleDTO sampleDTO = new SampleDTO();

        int newRandom = 456;
        sampleDTO.setRandom(newRandom);
        assertEquals(newRandom, sampleDTO.getRandom());

        int updatedRandom = 789;
        sampleDTO.setRandom(updatedRandom);
        assertEquals(updatedRandom, sampleDTO.getRandom());
    }
}