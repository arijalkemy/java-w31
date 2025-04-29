package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.Student;
import com.meli.obtenerdiploma.model.Subject;
import com.meli.obtenerdiploma.utils.IdContador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RepositoryStudent implements IRepositoryStudent, CommandLineRunner {
    private List<Student> studentList = new ArrayList<>();

    @Autowired
    IdContador idContador;


    @Override
    public void run(String... args) throws Exception {
        Subject sub1 = new Subject("Matematicas",8.5D);
        Subject sub2 = new Subject("Lengua",8.5D);
        Subject sub3 = new Subject("Cs Naturales",8.5D);

        List<Subject> subjectList = new ArrayList<>(List.of(sub1,sub2,sub3));
        Student s1 = new Student(idContador.idCountGetAndIncrement(),"nombre1","Es un buen chico",8.5D,subjectList);

        Subject sub4 = new Subject("Matematicas",6.5D);
        Subject sub5 = new Subject("Lengua",7.5D);
        Subject sub6 = new Subject("Cs Naturales",9.5D);

        List<Subject> subjectList2 = new ArrayList<>(List.of(sub4,sub5,sub6));
        Student s2 = new Student(idContador.idCountGetAndIncrement(),"nombre1","Es un buen chico",8.5D,subjectList2);

    }

    @Override
    public Student save(Student student){
        studentList.add(student);
        return student;
    }

    @Override
    public Student findById(Integer id){
        return studentList.stream()
                .filter(a-> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> findAll(){
        return studentList;
    }

    @Override
    public void delete(Integer id){
        Student s = studentList.stream()
                .filter(a-> a.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(Objects.isNull(s)){
            throw new RuntimeException("No existe un estudiante con id: "+ id);
        }
        studentList.remove(s);
    }
}
