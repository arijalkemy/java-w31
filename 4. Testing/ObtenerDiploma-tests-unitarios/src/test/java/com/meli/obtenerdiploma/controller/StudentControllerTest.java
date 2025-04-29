package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private StudentService service;
    @InjectMocks
    private StudentController studentController;

    public void registerStudentTest() {
        // arrange

        // act
        // assert
    }
}
