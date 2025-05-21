package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    IStudentService stuServ;

    @PostMapping("/create")
    public String createStudent(@RequestBody StudentDTO studentDTO){
        stuServ.saveStudent(studentDTO);
        return "El estudiante fue agregado correctamente";
    }
}
