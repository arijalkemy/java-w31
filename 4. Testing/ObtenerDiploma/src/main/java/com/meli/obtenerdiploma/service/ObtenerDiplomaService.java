package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.mapper.IMapper;
import com.meli.obtenerdiploma.model.Student;
import com.meli.obtenerdiploma.repository.IRepositoryStudent;
import com.meli.obtenerdiploma.utils.IdContador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Autowired
    IMapper mapper;

    @Autowired
    IRepositoryStudent repositoryStudent;

    @Autowired
    IdContador idContador;

    @Override
    public StudentDTO analyzeScores(StudentDTO rq) {
        rq.setAverageScore(calculateAverage(rq.getSubjects()));
        rq.setMessage(getGreetingMessage(rq.getStudentName(), rq.getAverageScore()));

        return rq;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }


    @Override
    public Student addStudent(StudentDTO studentDTO) {
        studentDTO.setId(idContador.idCountGetAndIncrement());
        return repositoryStudent.save(mapper.studentDtoToStudent(studentDTO));
    }

    @Override
    public StudentDTO findByIdStudent(Integer id) {
        Student s = repositoryStudent.findById(id);
        if(Objects.isNull(s)){
            throw new RuntimeException("El estudiante no se encuentra");
        }
        return mapper.studentToStudentDto(s);
    }

    @Override
    public String setStudent(Integer id, Double nuevoPromedio) {
        Student student = repositoryStudent.findById(id);

        if (Objects.isNull(student)) {
            throw new RuntimeException("Estudiante no encontrado con ID: " + id);
        }

        student.setAverageScore(nuevoPromedio);
        repositoryStudent.save(student);

        return "El promedio del estudiante con ID " + id + " fue actualizado a " + nuevoPromedio + ".";
    }

    @Override
    public String deleteStudent(Integer id) {
        repositoryStudent.delete(id);
        return "Estudiante con id: "+id +" eliminado exitosamente";
    }

    @Override
    public List<StudentDTO> findAllStudent() {
        return mapper.listTolistDto(repositoryStudent.findAll());
    }
}
