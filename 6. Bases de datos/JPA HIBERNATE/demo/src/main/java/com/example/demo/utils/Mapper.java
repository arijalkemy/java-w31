package com.example.demo.utils;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static Student StudentDTOToStudent(StudentDTO studentDTO){
        return new Student(studentDTO.getId(),studentDTO.getDni(),
                studentDTO.getFirstName(),studentDTO.getLastName());
    }

    public static List<StudentDTO> ListStudentToListStudentDTO(List<Student> list){
        return list.stream()
                .map(a-> new StudentDTO(a.getId(),a.getDni(),a.getFirstName(),a.getLastName()))
                .collect(Collectors.toList());
    }
}
