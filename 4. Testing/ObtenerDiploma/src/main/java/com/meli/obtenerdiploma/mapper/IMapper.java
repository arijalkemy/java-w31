package com.meli.obtenerdiploma.mapper;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.model.Student;
import com.meli.obtenerdiploma.model.Subject;

import java.util.List;

public interface IMapper {
    Student studentDtoToStudent(StudentDTO studentDTO);
    StudentDTO studentToStudentDto(Student student);

    List<StudentDTO> listTolistDto(List<Student> studentList);
}
