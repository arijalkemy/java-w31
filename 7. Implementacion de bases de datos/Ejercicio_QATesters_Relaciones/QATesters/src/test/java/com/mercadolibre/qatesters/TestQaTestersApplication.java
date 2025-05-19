package com.mercadolibre.qatesters;

import org.springframework.boot.SpringApplication;

public class TestQaTestersApplication {

    public static void main(String[] args) {
        SpringApplication.from(QaTestersApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
