package com.mercadolibre.joyeria.service;

import com.mercadolibre.joyeria.dto.RequestJewelryDto;
import com.mercadolibre.joyeria.model.Jewelry;
import com.mercadolibre.joyeria.repository.IJewelryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryService implements IJewelryService {

    private IJewelryRepository jewelryRepository;

    public JewelryService(IJewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }


    @Override
    public String addJewelry(RequestJewelryDto jewelry) {
        Jewelry jewelryToSave = new Jewelry(
                null,
                jewelry.getNombre(),
                jewelry.getMaterial(),
                jewelry.getPeso(),
                jewelry.getParticularidad(),
                jewelry.getPosee_piedra(),
                null);
        Jewelry jewelrySaved = jewelryRepository.save(jewelryToSave);
        Long idSaved = jewelrySaved.getNro_identificatorio();
        return "Se ha agregado la joya: " + idSaved;
    }

    @Override
    public List<Jewelry> getAllJewelry() {
        return jewelryRepository.findAll().stream().filter(Jewelry::getVenta_o_no).toList();
    }

    @Override
    public String deleteJewelry(Long id) {
        Optional<Jewelry> jewelry = jewelryRepository.findById(id);
        if(jewelry.isPresent()) {
            jewelry.get().setVenta_o_no(Boolean.FALSE);
            jewelryRepository.save(jewelry.get());
            return "Se ha eliminado la joya";
        }
        return "No se encontro la joya";
    }

    @Override
    public Jewelry editJewelry(Long id, RequestJewelryDto jewelryDto) {
        Optional<Jewelry> jewelry = jewelryRepository.findById(id);
        if (jewelry.isPresent()) {
            Jewelry jewelryToEdit = jewelry.get();
            jewelryToEdit.setNombre(jewelryDto.getNombre());
            jewelryToEdit.setMaterial(jewelryDto.getMaterial());
            jewelryToEdit.setParticularidad(jewelryDto.getParticularidad());
            jewelryToEdit.setPeso(jewelryDto.getPeso());
            jewelryToEdit.setPosee_piedra(jewelryDto.getPosee_piedra());
            jewelryRepository.save(jewelryToEdit);
            return jewelryToEdit;
        }
        return null;
    }
}
