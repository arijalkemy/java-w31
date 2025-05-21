package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;

import java.util.List;

public interface IStudentService {
    public List<StudentDTO> getStudents();
    public void saveStudent(StudentDTO stu);
    public void deleteStudent(Long id);
    public Student findStudent(Long id);
}
