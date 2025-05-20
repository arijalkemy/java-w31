package com.mercadolibre.casosdeprueba.mapper;

import com.mercadolibre.casosdeprueba.dto.TesterDto;
import com.mercadolibre.casosdeprueba.model.Tester;

public class TesterMapper {
    static public TesterDto toTesterDto(Tester tester) {
        return new TesterDto(tester.getNombre(), tester.getTestRealizados().stream().map(TestCaseMapper::toTestCaseDto).toList());
    }

    static public Tester toTester(TesterDto testerDto) {
        return new Tester(null, testerDto.getNombre(), testerDto.getTestRealizados().stream().map(TestCaseMapper::toTestCase).toList());
    }
}
