package com.meli.obtenerdiploma.controller.IT;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import static com.meli.obtenerdiploma.util.TestUtilsGenerator.*;

@AutoConfigureMockMvc
@SpringBootTest
class ObtenerDiplomaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IStudentDAO iStudentDAO;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void givenValidStudent_whenAnalyzeScore_thenPersonWithTheScoreCalculatedIsReturned() throws Exception{

        //Arrange
        StudentDTO studentDTO = getStudentWith3Subjects("Mark");
    
        //Act
        iStudentDAO.save(studentDTO);
        ResultActions resultActions;
        resultActions = mockMvc.perform(get("/analyzeScores/{studentId}", studentDTO.getId()));


        //Assert
        resultActions
            .andDo(print())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.studentName", Matchers.equalToIgnoringCase(studentDTO.getStudentName())));
    }

}