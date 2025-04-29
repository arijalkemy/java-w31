package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.Student;

import java.util.List;

public interface IRepositoryStudent {
    Student save(Student s);
    Student findById(Integer id);
    List<Student> findAll();
    void delete(Integer id);
}
