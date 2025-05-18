package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ObtenerDiplomaController.class)
public class ObtenerDiplomaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IObtenerDiplomaService diplomaService;

    @Test
    public void obtenerDiploma_deberiaRetornarOk() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/analyzeScores/1"))
                .andExpect(status().isOk());
    }
}