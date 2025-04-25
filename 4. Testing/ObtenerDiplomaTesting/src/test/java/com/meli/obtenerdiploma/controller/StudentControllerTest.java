package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    private IStudentService service;

    @InjectMocks
    private StudentController controller;

}