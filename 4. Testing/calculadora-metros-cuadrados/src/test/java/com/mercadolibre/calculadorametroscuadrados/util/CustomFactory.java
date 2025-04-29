package com.mercadolibre.calculadorametroscuadrados.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CustomFactory {
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final ObjectWriter writer = mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    private static final String HOUSE_RESPONSE_DTO_PATH = "jsons/data_house_response_dto.json";

    /*
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

    public static HouseResponseDTO getHouseResponseDto() throws IOException {
        return generateFromJson(
                readJsonFromResource(HOUSE_RESPONSE_DTO_PATH),
                HouseResponseDTO.class
        );
    }

    public static String getHouseDto() throws JsonProcessingException {
        List<RoomDTO> roomDTOList = new ArrayList<>();
        RoomDTO room1 =  new RoomDTO("Baño", 130, 150);
        RoomDTO room2 = new RoomDTO("Habitacion", 400, 400);
        roomDTOList.add(room1);
        roomDTOList.add(room2);

        HouseDTO house = new HouseDTO("La casa de barbie", "barbieland 123",  roomDTOList);
        return generateFromDto(house);
    }

    private static <T> T generateFromJson(String data, Class<T> classType) throws JsonProcessingException {
        return mapper.readValue(data, classType);
    }

    private static String generateFromDto(Object dto) throws JsonProcessingException {
        return writer.writeValueAsString(dto);
    }
}
