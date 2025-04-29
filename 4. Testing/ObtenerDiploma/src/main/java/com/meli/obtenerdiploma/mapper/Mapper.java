package com.meli.obtenerdiploma.mapper;

import com.meli.obtenerdiploma.dto.StudentDTO;
import com.meli.obtenerdiploma.dto.SubjectDTO;
import com.meli.obtenerdiploma.model.Student;
import com.meli.obtenerdiploma.model.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper implements IMapper{
    @Override
    public Student studentDtoToStudent(StudentDTO studentDTO) {
        return new Student(
                studentDTO.getId(),
                studentDTO.getStudentName(),
                studentDTO.getMessage(),
                studentDTO.getAverageScore(),
                subjectDtoToSubject(studentDTO.getSubjects()));
    }

    private List<Subject> subjectDtoToSubject(List<SubjectDTO> subjectDTO) {
        List<Subject> subjectList = new ArrayList<>();

        for(SubjectDTO s: subjectDTO){
            Subject s1 = new Subject(s.getName(),s.getScore());
            subjectList.add(s1);
        }
        return subjectList;
    }

    public StudentDTO studentToStudentDto(Student student){
        return new StudentDTO(
                student.getId(),
                student.getStudentName(),
                student.getMessage(),
                student.getAverageScore(),
                subjectToSubjectDto(student.getSubjects()
        ));
    }

    private List<SubjectDTO> subjectToSubjectDto(List<Subject> subjectlist) {
        List<SubjectDTO> subjecDTOtList = new ArrayList<>();

        for(Subject s: subjectlist){
            SubjectDTO s1 = new SubjectDTO(s.getName(),s.getScore());
            subjecDTOtList.add(s1);
        }
        return subjecDTOtList;
    }

    public List<StudentDTO> listTolistDto(List<Student> studentList){
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for(Student s: studentList){
            studentDTOList.add(studentToStudentDto(s));
        }
        return studentDTOList;
    }

}
