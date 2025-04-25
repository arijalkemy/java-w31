package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.BeforeEach;

public class StrudentDAOTest {

    IStudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    StudentDAO createStudentDAO() {
        StudentDAO s1 = new StudentDAO("Matematica", 9.00);
        StudentDAO student = new StudentDAO();
    }
}
