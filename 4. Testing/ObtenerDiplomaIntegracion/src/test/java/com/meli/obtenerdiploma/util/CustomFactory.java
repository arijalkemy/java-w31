package com.meli.obtenerdiploma.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class CustomFactory {
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final ObjectWriter writer = mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    private static final String STUDENT_DTO_PATH = "jsons/response.json";
    private static final String STUDENT_DIPLOMA_DTO_PATH = "jsons/ResponseDiploma.json";


    /**
     * Lee un archivo JSON desde la carpeta de recursos
     *
     * @param path ruta del archivo en la carpeta de recursos
     * @return contenido del archivo como String
     * @throws IOException si hay un error al leer el archivo
     */
    private static String readJsonFromResource(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }

    public static String getStudentDto()throws JsonProcessingException{

        return generateFromDto(TestUtilsGenerator.getStudentWith3Subjects("Marco"));
    }
    public static String getStudentDtoOver()throws JsonProcessingException{

        return generateFromDto(TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Sandra"));
    }
    public static StudentDTO getResponse() throws IOException {
        return generateFromJson(
                readJsonFromResource(STUDENT_DTO_PATH),
                StudentDTO.class
        );
    }
    public static StudentDTO getResponseDiploma() throws IOException {
        return generateFromJson(
                readJsonFromResource(STUDENT_DIPLOMA_DTO_PATH),
                StudentDTO.class
        );
    }


    private static <T> T generateFromJson(String data, Class<T> classType) throws JsonProcessingException {
        return mapper.readValue(data, classType);
    }

    private static String generateFromDto(Object dto) throws JsonProcessingException {
        return writer.writeValueAsString(dto);
    }

}
