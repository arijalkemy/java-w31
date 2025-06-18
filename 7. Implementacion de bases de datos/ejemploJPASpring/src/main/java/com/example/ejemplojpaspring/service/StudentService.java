package com.example.ejemplojpaspring.service;

import com.example.ejemplojpaspring.model.Student;
import com.example.ejemplojpaspring.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService  implements IStudentService{

    private final StudentRepository  studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }

    @Override
    public void saveStudent(Student stu) {
        // el save sirve tanto para guardar un nuevo student como un student ya existente pero con modficaciones
        // hibernate no nos ofrece un metodo modify para el update.
        studentRepo.save(stu);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public Student findStudent(Long id) {
        Student stu = studentRepo.findById(id).orElse(null);
        return null;
    }

    @Override
    public Student modifyStudentName(Long id, String name, String lastName) {
        Student stu = studentRepo.findById(id).orElse(null);
        if(stu != null) {
            stu.setName(name);
            stu.setLastname(lastName);
            studentRepo.save(stu);
        }
        return stu;
    }


}
