package com.meli.obtenerdiploma.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.nio.file.Path;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

public class Utils {
        private static String testUsersFilePath = "src/test/resources/users.json";

        public static void emptyUsersFile() throws IOException {
                Path filePath = (Path) Paths.get(testUsersFilePath);
                OpenOption[] options = { StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE };
                Files.write((java.nio.file.Path) filePath, "[]".getBytes(), options);
        }

        public static Set<StudentDTO> generateStudentsSet() {
                Set<StudentDTO> students = new HashSet<>();

                students.add(new StudentDTO(100L, "Ana Lopez", null, null,
                                Arrays.asList(
                                                new SubjectDTO("Math", 8.0),
                                                new SubjectDTO("Science", 9.0),
                                                new SubjectDTO("History", 7.0))));

                students.add(new StudentDTO(101L, "Juan Perez", null, null,
                                Arrays.asList(
                                                new SubjectDTO("Math", 6.5),
                                                new SubjectDTO("English", 7.5),
                                                new SubjectDTO("Physics", 8.0))));

                students.add(new StudentDTO(102L, "Carlos García", null, null,
                                Arrays.asList(
                                                new SubjectDTO("Chemistry", 9.0),
                                                new SubjectDTO("Biology", 8.0))));

                students.add(new StudentDTO(103L, "Laura Martinez", null, null,
                                Arrays.asList(
                                                new SubjectDTO("Math", 8.5),
                                                new SubjectDTO("Science", 7.0),
                                                new SubjectDTO("Art", 9.0))));

                students.add(new StudentDTO(104L, "Sofía Rojas", null, null,
                                Arrays.asList(
                                                new SubjectDTO("History", 7.5),
                                                new SubjectDTO("English", 8.0),
                                                new SubjectDTO("Art", 7.5))));

                students.add(new StudentDTO(105L, "Miguel Torres", null, null,
                                Arrays.asList(
                                                new SubjectDTO("Math", 9.0),
                                                new SubjectDTO("Computer Science", 10.0))));

                return students;
        }

        public static StudentDTO createStudent() {
                return new StudentDTO(106L, "Pedro Gonzalez", null, null,
                                Arrays.asList(
                                                new SubjectDTO("Math", 8.0),
                                                new SubjectDTO("Science", 9.0),
                                                new SubjectDTO("History", 7.0)));
        }

        public static StudentDTO createRegularStudent() {
                return new StudentDTO(107L, "Juan Perez", null, null,
                                Arrays.asList(
                                                new SubjectDTO("Math", 4.0),
                                                new SubjectDTO("Science", 5.0),
                                                new SubjectDTO("History", 6.0)));
        }

        public static StudentDTO createStudentWithHonors() {
                return new StudentDTO(108L, "Maria Lopez", null, null,
                                Arrays.asList(
                                                new SubjectDTO("Math", 10.0),
                                                new SubjectDTO("Science", 9.5),
                                                new SubjectDTO("History", 9.6)));
        }

        public static StudentDTO createInvalidStudent() {
                return new StudentDTO(-1L, "invalid Name!", null, null, new ArrayList<>());
        }
}
