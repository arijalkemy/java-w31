package com.mercadolibre.melifrescosg9w31.unit.mapper;

import com.mercadolibre.melifrescosg9w31.entity.Batch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BatchMapperTest {
    @Test
    public void testBatchMapper() {
        Batch batch = new Batch();
        assertNotNull(batch);
    }
}
