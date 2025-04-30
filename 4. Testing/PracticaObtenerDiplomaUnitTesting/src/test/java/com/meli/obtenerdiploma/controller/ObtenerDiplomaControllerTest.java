package com.meli.obtenerdiploma.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;

@WebMvcTest(controllers = ObtenerDiplomaController.class)
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IObtenerDiplomaService iObtenerDiplomaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void ObtenerDiplomaController_AnalyzeScores_Return_StudentDto() throws Exception{
        
        //Arrange
        StudentDTO studentDtoStubbed = new StudentDTO(1L, "Jhon", "Hey", null, 
        List.of(
                new SubjectDTO("Math", 5.0), new SubjectDTO("Languages", 7.6)));
        
        given(iObtenerDiplomaService.analyzeScores(studentDtoStubbed.getId())).willReturn(studentDtoStubbed);

        //Act
        ResultActions resultActions = mockMvc.perform(get("/analyzeScores/{studentId}", 
        studentDtoStubbed.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(studentDtoStubbed))).andExpect(MockMvcResultMatchers.status().isOk());

        //Assert
        resultActions.andExpect(status().isOk());
    }

}
