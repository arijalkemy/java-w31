package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void invalidCases(){
        Long invalidId = 999L;
        when(studentDAO.findById(invalidId)).thenThrow(new StudentNotFoundException(invalidId));

        assertThrows(StudentNotFoundException.class, () -> {
            obtenerDiplomaService.analyzeScores(invalidId);
        });
    }

    @Test
    public void testAnalyzeScores_EmptySubjects() {
        // Crea un estudiante con un ID y sin materias
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Juan", null, null, new ArrayList<>());

        // Configura el mock
        when(studentDAO.findById(studentId)).thenReturn(student);

        // Ejecuta el método que estás probando
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        // Verificar que el promedio no se ha calculado (puede ser null o 0 dependiendo de tu implementación)
        assertTrue(Double.isNaN(result.getAverageScore()));
        assertEquals("El alumno Juan ha obtenido un promedio de NaN. Puedes mejorar.", result.getMessage());
    }

    @Test
    public void calculateAverageTest() {
        Long studentId = 1L;
        List<SubjectDTO> subjectDTOList = getSubjectDTOS();
        StudentDTO studentDTO = new StudentDTO(studentId, "Juan", null, null, subjectDTOList);

        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertNotNull(result);
        assertEquals("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", result.getMessage());
    }

    @Test
    public void averageWithHonors() {
        Long studentId = 1L;
        List<SubjectDTO> subjectDTOList = getPerfectSubjectDTOS();
        StudentDTO studentDTO = new StudentDTO(studentId, "Juan", null, null, subjectDTOList);

        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);
        assertNotNull(result);
        assertEquals("El alumno Juan ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());
    }

    private static List<SubjectDTO> getSubjectDTOS() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO mathematics = new SubjectDTO();
        mathematics.setName("Matemáticas");

        mathematics.setScore(7.0);
        subjectDTOList.add(mathematics);

        SubjectDTO fisica = new SubjectDTO();
        fisica.setName("Física");
        fisica.setScore(9.0);
        subjectDTOList.add(fisica);

        SubjectDTO historia = new SubjectDTO();
        historia.setName("Historia");
        historia.setScore(6.0);
        subjectDTOList.add(historia);
        return subjectDTOList;
    }

    private static List<SubjectDTO> getPerfectSubjectDTOS() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO mathematics = new SubjectDTO();
        mathematics.setName("Matemáticas");

        mathematics.setScore(10D);
        subjectDTOList.add(mathematics);

        SubjectDTO fisica = new SubjectDTO();
        fisica.setName("Física");
        fisica.setScore(10D);
        subjectDTOList.add(fisica);

        SubjectDTO historia = new SubjectDTO();
        historia.setName("Historia");
        historia.setScore(10D);
        subjectDTOList.add(historia);
        return subjectDTOList;
    }
}
