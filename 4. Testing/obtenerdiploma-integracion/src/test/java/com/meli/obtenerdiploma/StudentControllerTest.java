package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    void registerStudent() {
        // arrange
        StudentDTO stu = new StudentDTO(1L, "Marcos", "Excellent", 95.0, null);
        // act
        controller.registerStudent(stu);
        // assert
        verify(service, atLeastOnce()).create(stu);
    }

    @Test
    void getStudent() {
        // arrange
        StudentDTO stu = new StudentDTO(1L, "Marcos", "Excellent", 95.0, null);
        when(service.read(stu.getId())).thenReturn(stu);
        // act
        StudentDTO readStu = controller.getStudent(stu.getId());
        // assert
        verify(service, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    void modifyStudent() {
        // arrange
        StudentDTO stu = new StudentDTO(1L, "Marcos", "Excellent", 95.0, null);
        // act
        controller.modifyStudent(stu);
        // assert
        verify(service, atLeastOnce()).update(stu);
    }

    @Test
    void removeStudent() {
        // arrange
        StudentDTO stu = new StudentDTO(1L, "Marcos", "Excellent", 95.0, null);
        // act
        controller.removeStudent(stu.getId());
        // assert
        verify(service, atLeastOnce()).delete(stu.getId());
    }
}
