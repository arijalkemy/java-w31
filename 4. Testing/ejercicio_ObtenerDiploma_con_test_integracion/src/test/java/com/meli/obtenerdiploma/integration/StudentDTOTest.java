package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentDTOTest {

    @Test
    public void testGettersAndSetters() {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        Assertions.assertEquals(9999L, student.getId());
        Assertions.assertEquals("Juan", student.getStudentName());
        Assertions.assertEquals(subjects, student.getSubjects());
    }

    @Test
    public void testAllArgsConstructor() {
        StudentDTO student = new StudentDTO(9999L, "Juan", null, null, null);

        Assertions.assertEquals(9999L, student.getId());
        Assertions.assertEquals("Juan", student.getStudentName());
    }
}
