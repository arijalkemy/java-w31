package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    void analyzeScores_returnsServiceResult() {
        Long id = 5L;
        StudentDTO resultMock = new StudentDTO();
        resultMock.setId(id);
        resultMock.setStudentName("Pepe");

        when(obtenerDiplomaService.analyzeScores(id)).thenReturn(resultMock);

        StudentDTO result = controller.analyzeScores(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Pepe", result.getStudentName());
        verify(obtenerDiplomaService).analyzeScores(id);
    }

    @Test
    void analyzeScores_whenStudentNotFound_throwsStudentNotFoundException() {
        when(obtenerDiplomaService.analyzeScores(222L)).thenThrow(new StudentNotFoundException(222L));

        assertThrows(StudentNotFoundException.class, () -> controller.analyzeScores(anyLong()));
        verify(obtenerDiplomaService).analyzeScores(222L);
    }
}