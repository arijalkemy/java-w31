package com.example.ejemplojpaspring.service;

import com.example.ejemplojpaspring.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents();
    void saveStudent(Student stu);
    void deleteStudent(Long id);
    Student findStudent(Long id);
    Student modifyStudentName(Long id, String name, String lastName);
}
