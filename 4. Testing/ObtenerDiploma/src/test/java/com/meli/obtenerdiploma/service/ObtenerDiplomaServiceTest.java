package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

        @Mock
        private IStudentDAO studentDAO;

        @InjectMocks
        private ObtenerDiplomaService obtenerDiplomaService;

        private List<SubjectDTO> subjects;
        private StudentDTO studentDto;

        @BeforeEach
        public void setUp() {
                subjects = new ArrayList<>();
                SubjectDTO subject = new SubjectDTO("Math", 100.0);
                SubjectDTO subject2 = new SubjectDTO("English", 100.0);
                SubjectDTO subject3 = new SubjectDTO("Spanish", 100.0);
                subjects.add(subject);
                subjects.add(subject2);
                subjects.add(subject3);
                studentDto = new StudentDTO(1L, "John Doe", "", null, subjects);
        }

        @Test
        public void testAnalyzeScoresStudentBestScore() {
                // Arrange
                Long id = studentDto.getId();
                Double expectedAverage = subjects.stream()
                                .mapToDouble(SubjectDTO::getScore)
                                .average()
                                .orElse(0.0);
                when(studentDAO.findById(id)).thenReturn(studentDto);

                // Act
                StudentDTO result = obtenerDiplomaService.analyzeScores(id);
                Double actualAverage = result.getAverageScore();

                // Assert
                verify(studentDAO, atLeast(1)).findById(id);
                assertEquals(expectedAverage, actualAverage);
        }

        @Test
        public void testAnalyzeScoresStudentGoodGreetingMessage() {
                // Arrange
                Long id = studentDto.getId();
                Double expectedAverage = subjects.stream()
                                .mapToDouble(SubjectDTO::getScore)
                                .average()
                                .orElse(0.0);
                String expectedMessage = "El alumno " + studentDto.getStudentName() + " ha obtenido un promedio de "
                                + new DecimalFormat("#.##").format(expectedAverage) + ". Felicitaciones!";
                when(studentDAO.findById(id)).thenReturn(studentDto);

                // Act
                StudentDTO result = obtenerDiplomaService.analyzeScores(id);
                String actualMessage = result.getMessage();

                // Assert
                verify(studentDAO, atLeast(1)).findById(id);
                assertEquals(expectedMessage, actualMessage);
        }

        @Test
        public void testAnalyzeScoresStudentBadGreetingMessage() {
                // Arrange
                Long id = studentDto.getId();
                subjects.stream().forEach(subject -> subject.setScore(5.0));
                Double expectedAverage = subjects.stream()
                                .mapToDouble(SubjectDTO::getScore)
                                .average()
                                .orElse(0.0);
                String expectedMessage = "El alumno " + studentDto.getStudentName() + " ha obtenido un promedio de "
                                + new DecimalFormat("#.##").format(expectedAverage) + ". Puedes mejorar.";
                when(studentDAO.findById(id)).thenReturn(studentDto);

                // Act
                StudentDTO result = obtenerDiplomaService.analyzeScores(id);
                String actualMessage = result.getMessage();

                // Assert
                verify(studentDAO, atLeast(1)).findById(id);
                assertEquals(expectedMessage, actualMessage);
        }

        @Test
        public void testAnalyzeScoresStudent() {
                // Arrange
                Long id = studentDto.getId();
                Double expectedAverage = subjects.stream()
                                .mapToDouble(SubjectDTO::getScore)
                                .average()
                                .orElse(0.0);
                String expectedMessage = "El alumno " + studentDto.getStudentName() + " ha obtenido un promedio de "
                                + new DecimalFormat("#.##").format(expectedAverage) + ". Felicitaciones!";
                studentDto.setAverageScore(expectedAverage);
                studentDto.setMessage(expectedMessage);
                when(studentDAO.findById(id)).thenReturn(studentDto);

                // Act
                StudentDTO result = obtenerDiplomaService.analyzeScores(id);

                // Assert
                verify(studentDAO, atLeast(1)).findById(id);
                assertEquals(studentDto, result);
        }
}
