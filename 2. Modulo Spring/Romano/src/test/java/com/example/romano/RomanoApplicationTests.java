package com.example.romano;

import com.example.romano.Services.RomanoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RomanoApplicationTests {
    private final RomanoService romanoService = new RomanoService();

    @Test
    void testConvertirARomano() {
        assertEquals("I", romanoService.convertirARomano(1));
        assertEquals("V", romanoService.convertirARomano(5));
        assertEquals("", romanoService.convertirARomano(10));
    }
}
