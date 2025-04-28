package com.meli.obtenerdiploma.integracion;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestObtenerDiplomaIT {
        @Autowired
        MockMvc mockMvc;

        static StudentDAO studentDAO = new StudentDAO();

        @Test
        public void analizeRegularStudentScore() throws Exception {
                List<SubjectDTO> subjects = List.of(
                                new SubjectDTO("Matematica", 6.0),
                                new SubjectDTO("Biologia", 8.0),
                                new SubjectDTO("Lengua", 7.0));
                StudentDTO student = new StudentDTO(100L, "Carlos Gomez", null, null, subjects);

                studentDAO.save(student);

                this.mockMvc.perform(
                                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", student.getId()))
                                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Carlos Gomez"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                                                .value("El alumno Carlos Gomez ha obtenido un promedio de 7,00. Puedes mejorar."))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(7.0))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects.length()").value(3));
        }

        @Test
        public void analizePerfectStudentScore() throws Exception {
                List<SubjectDTO> subjects = List.of(
                                new SubjectDTO("Matematica", 10.0),
                                new SubjectDTO("Biologia", 10.0),
                                new SubjectDTO("Lengua", 10.0));
                StudentDTO student = new StudentDTO(200L, "Maria Lopez", null, null, subjects);

                studentDAO.save(student);

                this.mockMvc.perform(
                                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", student.getId()))
                                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Maria Lopez"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                                                .value("El alumno Maria Lopez ha obtenido un promedio de 10,00. Felicitaciones!"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(10.0))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects.length()").value(3));
        }

        @Test
        public void analizeInvalidStudentScore() throws Exception {
                // Creo un estudiante y no lo guardo
                List<SubjectDTO> subjects = List.of(
                                new SubjectDTO("Matematica", 10.0),
                                new SubjectDTO("Biologia", 10.0),
                                new SubjectDTO("Lengua", 10.0));
                StudentDTO student = new StudentDTO(-1L, "Maria Lopez", null, null, subjects);

                this.mockMvc.perform(
                                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", student.getId()))
                                .andExpect(MockMvcResultMatchers.status().isNotFound())
                                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"));
        }
}
