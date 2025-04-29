package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.model.Student;

import java.util.List;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);
    Student addStudent(StudentDTO studentDTO);
    StudentDTO findByIdStudent(Integer id);
    String setStudent(Integer id, Double nuevoPromedio);
    String deleteStudent(Integer id);
    List<StudentDTO> findAllStudent();
}
