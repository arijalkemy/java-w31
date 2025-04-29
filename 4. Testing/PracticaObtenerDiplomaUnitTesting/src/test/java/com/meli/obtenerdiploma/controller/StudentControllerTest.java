package com.meli.obtenerdiploma.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;

@WebMvcTest(controllers = StudentController.class)
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @MockitoBean
    private IStudentService iStudentService;


    @Test
    void obtenerUnEstudiante_WhenIdIsPassed() throws Exception{
        //Arrange
        StudentDTO studentDtoStubbed = new StudentDTO(1L, "Jhon", "Hey", null, 
        List.of(
                new SubjectDTO("Math", 5.0), new SubjectDTO("Languages", 7.6)));
        
        given(iStudentService.read(studentDtoStubbed.getId())).willReturn(studentDtoStubbed);
        

        //Act
        ResultActions resultActions = mockMvc.perform(get("/student/getStudent/{id}", 
        studentDtoStubbed.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(studentDtoStubbed))).andExpect(MockMvcResultMatchers.status().isOk());

        //Assert
        resultActions.andExpect(status().isOk());
    }

    @Test
    void registrarUnEstudiante_WhenBodyIsPassed() throws Exception{
        
        //Arrange

        StudentDTO studentDtoStubbed = new StudentDTO(1L, "Jhon", "Hey", null, 
            List.of(new SubjectDTO("Math", 5.0), new SubjectDTO("Languages", 7.6)));

        willDoNothing().given(iStudentService).create(any(StudentDTO.class));

        String payloadJson = objectMapper.writeValueAsString(studentDtoStubbed);

        //Act & Assert
         mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
            .andExpect(MockMvcResultMatchers.status().isOk());
            
    }

    @Test
    void modificarUnEstudiante_WhenBodyIsPassed() throws Exception{
        
        //Arrange

        StudentDTO studentDtoStubbed = new StudentDTO(1L, "Jhon", "Hey", null, 
            List.of(new SubjectDTO("Math", 5.0), new SubjectDTO("Languages", 7.6)));

        // this line works even if we do not add it
        willDoNothing().given(iStudentService).update(any(StudentDTO.class));

        String payloadJson = objectMapper.writeValueAsString(studentDtoStubbed);

        //Act & Assert
         mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
            .andExpect(MockMvcResultMatchers.status().isOk());
        verify(iStudentService, atLeastOnce()).update(any(StudentDTO.class));
    }
    
    @Test
    void eliminarUnEstudiante_WhenIdIsPassed() throws Exception{ 
        Long studentId = 1L;
        mockMvc.perform(delete("/student/removeStudent/{id}", studentId))
        .andExpect(status().isOk());
        verify(iStudentService).delete(studentId);

    }

    @Test
    @Disabled
    void obtenerTodosLosEstudiantes() throws Exception{

    // Arrange
    StudentDTO student1 = new StudentDTO(1L, "Jhon", "Hey", null, List.of());
    StudentDTO student2 = new StudentDTO(2L, "Jane", "Hello", null, List.of());
    Set<StudentDTO> students = Set.of(student1, student2);
    given(iStudentService.getAll()).willReturn(students);

    // Act & Assert
    mockMvc.perform(get("/listStudents"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].studentName", anyOf(is("Jhon"), is("Jane"))))
        .andExpect(jsonPath("$[1].studentName", anyOf(is("Jhon"), is("Jane"))));
    
        
    }

}
