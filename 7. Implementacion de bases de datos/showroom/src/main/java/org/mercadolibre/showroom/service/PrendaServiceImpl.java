package org.mercadolibre.showroom.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.showroom.dto.PrendaDTO;
import org.mercadolibre.showroom.entities.Prenda;
import org.mercadolibre.showroom.exceptions.BadRequestException;
import org.mercadolibre.showroom.exceptions.NotFoundException;
import org.mercadolibre.showroom.repository.PrendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements  PrendaService{

    final private PrendaRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    public PrendaServiceImpl(PrendaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PrendaDTO> massiveCreate(List<PrendaDTO> prendaDTOS) {

        List<Prenda> prendaList = prendaDTOS.stream()
                .map(p -> mapper.convertValue(p, Prenda.class)).toList();

        repository.saveAll(prendaList);

        return prendaDTOS;
    }

    @Override
    public PrendaDTO createPrenda(PrendaDTO prendaDTO) {

        if(prendaDTO.getNombre() == null) {
            throw new BadRequestException("El nombre no puede ser nulo.");
        }

        if(prendaDTO.getCodigo() == null) {
            throw new BadRequestException("El código no puede ser nulo.");
        }

        if(prendaDTO.getPrecioVenta() <= 0) {
            throw new BadRequestException("l tamaño numérico de la prenda debe ser un valor positivo.");
        }

        // SE PUEDEN SEGUIR AGREGANDO VALIDACIONES ....

        Prenda prenda = mapper.convertValue(prendaDTO, Prenda.class);

        repository.save(prenda);

        return prendaDTO;
    }

    @Override
    public List<PrendaDTO> getAllPrendas() {
        List<Prenda> prendaList = repository.findAll();

        if(prendaList.isEmpty()) {
            throw  new NotFoundException("No hay prendas en la lista");
        }

        return prendaList.stream()
                .map(p -> mapper.convertValue(p, PrendaDTO.class)).toList();
    }

    @Override
    public PrendaDTO getPrendaByCode(String code) {

        Prenda prenda = repository.getByCodigo(code);

        if(prenda == null) {
            throw new NotFoundException("No se encontró la prenda");
        }

        return mapper.convertValue(prenda, PrendaDTO.class);
    }

    @Override
    public PrendaDTO updatePrendaByCode(String code, PrendaDTO dto) {

        Prenda prenda = repository.getByCodigo(code);

        if(prenda == null) {
            throw new NotFoundException("No se encontró la prenda");
        }

        prenda.setNombre(dto.getNombre());
        prenda.setCantidad(dto.getCantidad());
        prenda.setColor(dto.getColor());
        prenda.setMarca(dto.getMarca());
        prenda.setTipo(dto.getTipo());
        prenda.setTalle(dto.getTalle());
        prenda.setPrecioVenta(dto.getPrecioVenta());

        repository.save(prenda);

        return mapper.convertValue(prenda, PrendaDTO.class);
    }

    @Override
    public String deletePrenda(String code) {

        Prenda prenda = repository.getByCodigo(code);

        if(prenda == null){
            throw new NotFoundException("No se encontró la prenda");
        }

        repository.deleteById(prenda.getId());

        return "Se eliminó la prenda con éxito";
    }

    @Override
    public List<PrendaDTO> getPrendaBySize(String size) {

        List<Prenda> prendaList = repository.getPrendaBySize(size);

        if(prendaList.isEmpty()){
            throw new NotFoundException("No hay prendas con el talle especificado");
        }

        return prendaList.stream()
                .map(p -> mapper.convertValue(p, PrendaDTO.class)).toList();
    }

    @Override
    public List<PrendaDTO> getPrendaByName(String name) {

        List<Prenda> prendaList = repository.findByNombre(name);

        if(prendaList.isEmpty()) {
            throw new NotFoundException("No hay prendas con ese nombre");
        }

        return prendaList.stream()
                .map(p -> mapper.convertValue(p, PrendaDTO.class)).toList();
    }
}
