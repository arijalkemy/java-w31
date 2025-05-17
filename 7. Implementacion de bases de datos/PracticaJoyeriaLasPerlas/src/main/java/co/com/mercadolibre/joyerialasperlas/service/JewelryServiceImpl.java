package co.com.mercadolibre.joyerialasperlas.service;

import co.com.mercadolibre.joyerialasperlas.dto.JewelryDto;
import co.com.mercadolibre.joyerialasperlas.mappers.JewelryMapper;
import co.com.mercadolibre.joyerialasperlas.model.Jewelry;
import co.com.mercadolibre.joyerialasperlas.repository.IJewelryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JewelryServiceImpl implements IJewelryService{

    private final IJewelryRepository jewelryRepository;

    @Override
    public List<JewelryDto> getAll() {
        return jewelryRepository.findAllByVentaONoIsTrue().stream().map(JewelryMapper::toDto).toList();
    }

    @Override
    public JewelryDto save(JewelryDto jewelryDto) {
        Jewelry jewelry = JewelryMapper.toEntity(jewelryDto);
        jewelry.setVentaONo(true);
        jewelryRepository.save(jewelry);
        return JewelryDto.builder()
                .nroIdentificatorio(jewelry.getNroIdentificatorio())
                .build();
    }

    @Override
    public void delete(Long id) {
        Jewelry jewelryToBeDeleted = jewelryRepository.findAllByVentaONoIsTrue().stream()
                .filter(j -> j.getNroIdentificatorio().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Not Found"));
        jewelryToBeDeleted.setVentaONo(false);
        jewelryRepository.save(jewelryToBeDeleted);
    }

    @Override
    public JewelryDto update(JewelryDto jewelryDto, Long id) {
        Jewelry jewelryToBeUpdated = jewelryRepository.findAllByVentaONoIsTrue().stream()
                .filter(j -> j.getNroIdentificatorio().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Not Found"));
        jewelryToBeUpdated
                .setPeso(jewelryDto.getPeso())
                .setMaterial(jewelryDto.getMaterial())
                .setNombre(jewelryDto.getNombre())
                .setParticularidad(jewelryDto.getParticularidad());
        jewelryRepository.save(jewelryToBeUpdated);
        return JewelryMapper.toDto(jewelryToBeUpdated);
    }
}
