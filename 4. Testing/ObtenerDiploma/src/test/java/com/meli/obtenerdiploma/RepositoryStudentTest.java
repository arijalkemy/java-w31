package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.Student;
import com.meli.obtenerdiploma.model.Subject;
import com.meli.obtenerdiploma.repository.RepositoryStudent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryStudentTest {

    private RepositoryStudent repositoryStudent;

    @BeforeEach
    void setUp(){
        //Inicializamos el repositorio
        repositoryStudent = new RepositoryStudent();
    }

    @Test
    void testSave(){
        //Arrange (Organizar)
        List<Subject> subjectList = new ArrayList<>(List.of(
                new Subject("materia",8.0),
                new Subject("",6.0)
        ));
        Student s = new Student(1,"nombre","mensaje",10.0,subjectList);
        //Act (Actuar)
        Student guardado = repositoryStudent.save(s);

        //Assert (Afirmar)
        assertNotNull(guardado);
        assertEquals(1,guardado.getId());
        assertEquals("mensaje",guardado.getMessage());
    }

    @Test
    void findById(){
        //Arrange
        List<Subject> subjectList = new ArrayList<>(List.of(
                new Subject("materia",8.0),
                new Subject("",6.0)
        ));
        Student s = new Student(1,"nombre","mensaje",10.0,subjectList);

        Student guardado = repositoryStudent.save(s);

        //Act
        Student encontrado = repositoryStudent.findById(1);

        //Assert
        assertEquals(guardado,encontrado);
        assertEquals(1,encontrado.getId());
    }

    @Test
    void delete(){
        //Arrange
        List<Subject> subjectList = new ArrayList<>(List.of(
                new Subject("materia",8.0),
                new Subject("",6.0)
        ));
        Student s = new Student(1,"nombre","mensaje",10.0,subjectList);

        Student guardado = repositoryStudent.save(s);

        //Act
        repositoryStudent.delete(guardado.getId());
        Student d = repositoryStudent.findById(guardado.getId());

        //Assert
        assertNull(d);
    }
}
