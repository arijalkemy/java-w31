package com.mercadolibre.testcases.util;

import com.mercadolibre.testcases.dto.TesterDto;
import com.mercadolibre.testcases.model.Tester;

public class TesterMapper {
    public static TesterDto toTesterDto(Tester tester) {
        return new TesterDto(
                tester.getId(),
                tester.getName(),
                tester.getEmail()
        );
    }

    public static Tester toTester(TesterDto testerDto) {
        Tester tester = new Tester();
        tester.setName(testerDto.getName());
        tester.setEmail(testerDto.getEmail());
        return tester;
    }
}
