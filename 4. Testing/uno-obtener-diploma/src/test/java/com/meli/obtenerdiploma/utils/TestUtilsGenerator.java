package com.meli.obtenerdiploma.utils;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class TestUtilsGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static void emptyUsersFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static Set<StudentDTO> getStudentsSet(){
        return new HashSet<StudentDTO>() {{
            createStudentWithThreeSubjectsHighScores("Laura");
            createStudentWithThreeSubjectsHighScores("Carlos");
            createStudentWithThreeSubjectsLowScores("Marta");
            createStudentWithThreeSubjectsLowScores("Mario");
        }};
    }

    public static StudentDTO createStudentWithThreeSubjectsHighScores(String name) {
        return new StudentDTO(null, name,
                List.of(new SubjectDTO("Italian", 9.5D),
                        new SubjectDTO("English", 9D),
                        new SubjectDTO("Spanish", 10D)
                ));
    }

    public static StudentDTO createStudentWithThreeSubjectsLowScores(String name) {
        return new StudentDTO(null, name,
                List.of(new SubjectDTO("Italian", 3D),
                        new SubjectDTO("English", 4D),
                        new SubjectDTO("Spanish", 1D)
                ));
    }
}
