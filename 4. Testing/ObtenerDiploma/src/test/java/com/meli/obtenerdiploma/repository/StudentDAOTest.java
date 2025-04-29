package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

@SpringBootTest
public class StudentDAOTest {
    private static final String ORIGINAL_FILE_PATH = "./src/main/resources/users_original.json";
    private static final String TEST_FILE_PATH = "./src/main/resources/users.json";

    private StudentDAO studentDAO;

    @BeforeEach
    public void setUp() throws IOException {
        studentDAO = new StudentDAO();
        // restore original file before each test
        Files.copy(new File(ORIGINAL_FILE_PATH).toPath(),
                new File(TEST_FILE_PATH).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
    }

    // SAVE
    @Test
    public void saveExistingStudentTest() {
        // arrange
        StudentDTO studentDTO = createExistingStudent();
        assert (studentDAO.getStudents().size() == 2);
        // act
        studentDAO.save(studentDTO);
        // assert
        assert (studentDAO.getStudents().size() == 2);
        assert (studentDAO.getStudents().contains(studentDTO));

    }

    @Test
    public void saveNewStudentTest() {
        // arrange
        StudentDTO studentDTO = createNewStudent();
        assert (studentDAO.getStudents().size() == 2);
        // act
        studentDAO.save(studentDTO);
        // assert
        assert (studentDAO.getStudents().size() == 3);
        assert (studentDAO.getStudents().contains(studentDTO));
    }

    @Test
    public void saveNullStudentTest() {
        // arrange
        StudentDTO studentDTO = null;
        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentDAO.save(studentDTO));
    }

    // DELETE
    @Test
    public void deleteExistingStudentTest() {
        // arrange
        Long param = 1L;
        // act & assert
        Assertions.assertTrue(studentDAO.delete(param));
    }

    @Test
    public void deleteNonExistentStudent() {
        // arrange
        Long param = 4L;
        // act & assert
        Assertions.assertFalse(studentDAO.delete(param));
    }

    // EXISTS
    @Test
    public void existsStudentTest() {
        // arrange
        StudentDTO param = createExistingStudent();
        // act & assert
        Assertions.assertTrue(studentDAO.exists(param));
    }

    @Test
    public void notExistsStudentTest() {
        // arrange
        StudentDTO param = createNonExistingStudent();
        // act & assert
        Assertions.assertFalse(studentDAO.exists(param));

    }

    @Test
    public void findExistingStudentTest() {
        // arrange
        Long param = 2L;
        // act
        StudentDTO foundStudent = studentDAO.findById(param);
        // assert
        Assertions.assertEquals(param, foundStudent.getId());
    }

    @Test
    public void findNonExistentStudentTest() {
        // arrange
        Long param = 4L;
        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentDAO.findById(param));
    }

    // DATA GENERATION METHODS

    private StudentDTO createNonExistingStudent() {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0),
                new SubjectDTO("Literatura", 8.0)
        );
        return new StudentDTO(6L, "Pepa",
                "hola", 0.0, subjects);
    }


    private StudentDTO createExistingStudent() {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0),
                new SubjectDTO("Literatura", 8.0)
        );
        return new StudentDTO(1L, "Juan",
                "hola", 0.0, subjects);
    }

    private StudentDTO createNewStudent() {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Historia", 8.0)
        );
        return new StudentDTO(3L, "Romina", "no sé", 9.0,
                subjects);
    }
}
