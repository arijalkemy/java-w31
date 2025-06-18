package com.mercadolibre.melifrescosg9w31.beans;

import com.mercadolibre.melifrescosg9w31.dtos.SampleDTO;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;


/**
 * Sample Bean class.
 */
@Component
public class RandomSampleBean {

    /**
     * @return new instance of SampleDTO.
     */
    public SampleDTO random() {
        return new SampleDTO(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
    }
}
