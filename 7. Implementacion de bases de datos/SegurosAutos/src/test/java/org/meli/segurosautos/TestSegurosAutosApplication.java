package org.meli.segurosautos;

import org.springframework.boot.SpringApplication;

public class TestSegurosAutosApplication {

    public static void main(String[] args) {
        SpringApplication.from(SegurosAutosApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
