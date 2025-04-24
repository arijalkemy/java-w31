package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentDAO studentDAO;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

}