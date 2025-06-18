package com.mercadolibre.melifrescosg9w31.unit.beans;

import com.mercadolibre.melifrescosg9w31.beans.RandomSampleBean;
import com.mercadolibre.melifrescosg9w31.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
