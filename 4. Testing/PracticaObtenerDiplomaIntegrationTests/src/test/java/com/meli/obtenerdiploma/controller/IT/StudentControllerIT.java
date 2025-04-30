package com.meli.obtenerdiploma.controller.IT;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;


@AutoConfigureMockMvc
@SpringBootTest
class StudentControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IStudentDAO iStudentDAO;

    @Autowired
    private ObjectMapper objectMapper;

    private ResultActions resultActions;

    @Test
    void givenValidStudent_whenModifying_thenUpdate() throws Exception {

        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(1L);
        stu.setStudentName("Felipe");
        stu.setSubjects(subjects);
        
        String jsonPayload = objectMapper.writeValueAsString(stu);
        System.out.println(jsonPayload);
        
        //Act
        resultActions = mockMvc.perform(post("/student/modifyStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload));

        //Assert
        resultActions
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void givenValidStudent_whenCreated_saved() throws Exception {

        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(1L);
        stu.setStudentName("Felipe");
        stu.setSubjects(subjects);
        
        String jsonPayload = objectMapper.writeValueAsString(stu);
        System.out.println(jsonPayload);
        
        //Act
        resultActions = mockMvc.perform(post("/student/registerStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload));

        //Assert
        resultActions
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void givenValidStudentId_whenRequested_returned() throws Exception {
        
        StudentDTO studentDTO = iStudentDAO.findById(5L);
        
        String jsonPayload = objectMapper.writeValueAsString(studentDTO);
        System.out.println(jsonPayload);
        
        //Act
        resultActions = mockMvc.perform(get("/student/getStudent/{id}", studentDTO.getId()));

        //Assert
        resultActions
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.studentName", Matchers.containsString(studentDTO.getStudentName())));
    }

    @Test
    void givenValidStudentId_whenDeleted_returnedVoid() throws Exception {
        
        StudentDTO studentDTO = iStudentDAO.findById(2L);
        
        String jsonPayload = objectMapper.writeValueAsString(studentDTO);
        System.out.println(jsonPayload);
        
        //Act
        resultActions = mockMvc.perform(delete("/student/removeStudent/{id}", studentDTO.getId()));

        //Assert
        resultActions
            .andDo(print())
            .andExpect(status().isOk());
        iStudentDAO.save(studentDTO);
    }


}
