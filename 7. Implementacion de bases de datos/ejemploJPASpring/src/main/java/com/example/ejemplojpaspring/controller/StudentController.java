package com.example.ejemplojpaspring.controller;

import com.example.ejemplojpaspring.model.Student;
import com.example.ejemplojpaspring.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentServ;

    @PostMapping("/create")
    public String postStudent(@RequestBody Student student){
        studentServ.saveStudent(student);
        return "El estudiante fue agregado correctamente.";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentList = studentServ.getStudents();
        return studentList;
    }

    @PostMapping("edit/{id}")
    public Student editStudent (@PathVariable Long id,
                                @RequestParam ("name") String newName,
                                @RequestParam ("lastname") String newLastName) {
        return  studentServ.modifyStudentName(id, newName, newLastName);
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudent (@PathVariable Long id) {
        studentServ.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }

}
