package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.utils.Mapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository stuRepo;

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> getStudents() {
        List<Student> listStudent = stuRepo.findAll();
        return Mapper.ListStudentToListStudentDTO(listStudent);
    }

    @Override
    public void saveStudent(StudentDTO stu) {
        stuRepo.save(Mapper.StudentDTOToStudent(stu));
    }

    @Override
    public void deleteStudent(Long id) {
        stuRepo.deleteById(id);
    }

    @Override
    public Student findStudent(Long id) {
        return stuRepo.findById(id).orElse(null);
    }
}
