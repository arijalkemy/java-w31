package com.meli.obtenerdiploma.unittest.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentControllerTets {

    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;


    @Test
    public void registerStudent(){
        Long studentId = 4L;
        StudentDTO student = new StudentDTO();
        student.setId(studentId);
        student.setStudentName("Pedro");
        student.setSubjects(List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        ));

        studentController.registerStudent(student);
        verify(studentService, atLeastOnce()).create(student);
    }
}
