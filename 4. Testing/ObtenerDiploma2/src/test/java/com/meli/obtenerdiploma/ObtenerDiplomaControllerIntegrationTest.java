package com.meli.obtenerdiploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; //Para convertir objetos a JSON

    /*
    CASOS A CHEQUEAR

    ✅ Caso feliz: analizar las notas de un estudiante existente y recibir diploma.

    ⚠️ Validaciones: si el studentId no existe, que devuelva error.

    ❌ Excepciones: si algo falla (por ejemplo, ID inválido), controlar que responda correctamente (con 404 o 400).
     */

    //Test caso feliz
    @Test
    void shouldReturnDiplomaWhenStudentExists() throws Exception {
        //Arrange
        Long existStudentId = 2L;

        //Act & Assert
        //Simulamos la llamada al endpoint
        mockMvc.perform(get("/analyzeScores/{studentId}", existStudentId))
                //Verifica la respuesta que sea 200 Ok
                .andExpect(status().isOk())
                //Verifica que el JSON de respuesta exista el campo message
                .andExpect(jsonPath("$.message").exists())
                //Verifica que el campo student.name tenga el valor "Juan Perez"
                .andExpect(jsonPath("$.studentName").value("Pedro"));
    }

    //Caso error: estudiante no encontrado
    @Test
    void shouldReturnNotFoundWhenStudentDoesNotExist() throws Exception{
        //Arrange
        Long nonExistentStudentId = 999L;
        //Act Assert
        mockMvc.perform(get("/analyzeScores/{studentId}",nonExistentStudentId))
                .andExpect(status().isNotFound());
    }
}
