package com.consesionaria.consesionariavivo.servicies;

import com.consesionaria.consesionariavivo.dto.AutoDTO;
import com.consesionaria.consesionariavivo.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AutoService implements IAutoService{
    private final AutoRepository autoRepository;

    @Autowired
    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public void saveData(AutoDTO auto) throws IOException {
        autoRepository.saveData(auto);
    }
}
