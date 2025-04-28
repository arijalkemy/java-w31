package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.ObtenerDiplomaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObtenerDiplomaApplicationTest {

    @Test
    void contextLoads(){}

    @Test
    void testMain() {
        ObtenerDiplomaApplication.main(new String[] {});  // Invocar el método main
    }
}
