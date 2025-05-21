package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    IStudentService stuServ;

    @PostMapping("/create")
    public String createStudent(@RequestBody StudentDTO studentDTO){
        stuServ.saveStudent(studentDTO);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/student")
    public List<StudentDTO> getStudent(){
        return stuServ.getStudents();
    }

    @PostMapping("/edit/{id}")
    public StudentDTO editStudent(@PathVariable Long id,
                                  @RequestParam ("firstName") String firstName,
                                  @RequestParam ("lastName") String lassName){

        StudentDTO stu = stuServ.findStudent(id);
        stu.setFirstName(firstName);
        stu.setLastName(lassName);
        stuServ.saveStudent(stu);
        return stu;
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        stuServ.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }
}
