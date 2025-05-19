package com.mercadolibre.qatester.util;

import com.mercadolibre.qatester.dto.TestCaseDto;
import com.mercadolibre.qatester.modal.TestCase;

public class Mapper {

    public static TestCaseDto toDto (TestCase test){

        return new TestCaseDto(test.getId_case(),
                              test.getDescription(),
                              test.getTested(),
                              test.getPassed(),
                              test.getNumber_of_tries(),
                              test.getLastUpdate(),
                              test.getFunctionality(),
                              test.getTester().getId(),
                              test.getTester().getNombre());
    }
}
