package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter ow;
    private List<StudentDTO> students;

    @BeforeEach
    void setUp() {
        ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        students = List.of(
                new StudentDTO(1L, "Camilo", "El alumno Camilo ha obtenido un promedio de 4,25. Puedes mejorar.", 4.25, List.of(
                        new SubjectDTO("Math", 3.5),
                        new SubjectDTO("Science", 5.0)
                )),
                new StudentDTO(2L, "Laura", "El alumno Laura ha obtenido un promedio de 4,8. Puedes mejorar.", 4.8, List.of(
                        new SubjectDTO("Science", 4.9),
                        new SubjectDTO("History", 4.7)
                )),
                new StudentDTO(3L, "Andrés", "El alumno Andrés ha obtenido un promedio de 4,1. Puedes mejorar.", 4.1, List.of(
                        new SubjectDTO("History", 4.1)
                )),
                new StudentDTO(4L, "Sofia", "El alumno Sofia ha obtenido un promedio de 10. Felicitaciones!", 10.0, List.of(
                        new SubjectDTO("Biology", 10.0),
                        new SubjectDTO("Chemistry", 10.0)

                )),
                new StudentDTO(5L, "Mateo", "El alumno Mateo ha obtenido un promedio de 3,0. Puedes mejorar.", 3.0, List.of(
                        new SubjectDTO("Math", 2.9),
                        new SubjectDTO("Literature", 3.1)
                ))
        );
    }

    @Test
    public void testAnalyzeScores_shouldCalculateAverageAndMessage() throws Exception {
        // Assert
        StudentDTO expectedDto = students.get(0);
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(expectedDto.getId()))
                .andExpect(jsonPath("$.studentName").value(expectedDto.getStudentName()))
                .andExpect(jsonPath("$.averageScore").value(expectedDto.getAverageScore()))
                .andExpect(jsonPath("$.message").value(expectedDto.getMessage()));
    }

    @Test
    public void testAnalyzeScores_withHonors() throws Exception {
        StudentDTO expectedDto = students.get(3);
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(expectedDto.getId()))
                .andExpect(jsonPath("$.studentName").value(expectedDto.getStudentName()))
                .andExpect(jsonPath("$.averageScore").value(expectedDto.getAverageScore()))
                .andExpect(jsonPath("$.message").value(expectedDto.getMessage()));

    }

    @Test
    public void testAnalyzeScores_nullStudent_throwsException() throws Exception {
        this.mockMvc.perform(get("/analyzeScores/{studentId}", Integer.MAX_VALUE))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id "+ Integer.MAX_VALUE + " no se encuetra registrado."));
    }

}
