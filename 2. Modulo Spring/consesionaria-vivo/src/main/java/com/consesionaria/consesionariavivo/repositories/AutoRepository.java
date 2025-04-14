package com.consesionaria.consesionariavivo.repositories;

import com.consesionaria.consesionariavivo.controller.AutoRestController;
import com.consesionaria.consesionariavivo.dto.AutoDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoRepository implements IAutoRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file = new File("data.json");

    public void saveData(AutoDTO auto) throws IOException {
        List<AutoDTO> autoList = readData();
        autoList.add(auto);
        try {
            objectMapper.writeValue(file, autoList);
        } catch (IOException e) {
            throw new IOException("Error writing to file: " + e.getMessage(), e);
        }
    }

    public List<AutoDTO> readData() throws IOException {
        if (file.exists()) {
            try {
                return objectMapper.readValue(file, new TypeReference<>() {});
            } catch (IOException e) {
                throw new IOException("Error reading from file: " + e.getMessage(), e);
            }
        } else {
            return new ArrayList<>();
        }
    }

}
