package com.mercadolibre.showroom_uno.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.showroom_uno.dto.ClotheDto;
import com.mercadolibre.showroom_uno.model.Clothe;
import com.mercadolibre.showroom_uno.repository.IClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowRoomService implements IShowRoomService {

    @Autowired
    IClothesRepository repository;
    @Autowired
    private ObjectMapper mapper;
    /* POST  /api/clothes Crear una nueva prenda.*/
    @Override
    public void createClothe(ClotheDto clotheDto) {
        clotheDto.setId(null);
        Clothe clothe = mapper.convertValue(clotheDto, Clothe.class);
        repository.save(clothe);
    }

    @Override
    public List<ClotheDto> getAllClothes() {
       return repository.findAll().stream().map(c -> mapper.convertValue(c, ClotheDto.class)).toList();
    }

    @Override
    public ClotheDto getClotheByCode(Long code) {
      Optional<Clothe> clothe = repository.findById(code);
        Clothe clotheObtained = repository.findById(code)
                .orElseThrow(() -> new RuntimeException("Prenda no encontrada con código: " + code));
      return mapper.convertValue(clotheObtained, ClotheDto.class);
    }

    @Override
    public void updateClothe(Long id, ClotheDto clotheDto) {
        Clothe existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prenda no encontrada para actualizar."));

        existing.setCantidad(clotheDto.getCantidad());
        existing.setNombre(clotheDto.getNombre());
        existing.setMarca(clotheDto.getMarca());
        existing.setTipo(clotheDto.getTipo());
        existing.setTalle(clotheDto.getTalle());
        existing.setColor(clotheDto.getColor());
        existing.setPrecioVenta(clotheDto.getPrecioVenta());
        repository.save(existing);
    }

    @Override
    public void deleteClothe(Long code) {
        Optional<Clothe> clothe = repository.findById(code);
        Clothe clotheObtained = repository.findById(code)
                .orElseThrow(() -> new RuntimeException("Prenda no encontrada con código: " + code));
        repository.delete(clotheObtained);
    }

    @Override
    public List<ClotheDto> getClothesBySize(String size) {
       List<Clothe> clothes = repository.findAll().stream().filter(c -> c.getTalle().equalsIgnoreCase(size))
               .toList();
       return clothes.stream().map(c -> mapper.convertValue(c, ClotheDto.class)).toList();
    }

    @Override
    public List<ClotheDto> getClotheByName(String name) {
        List<Clothe> clothes = repository.findAll().stream()
                .filter(c -> c.getNombre().toLowerCase().contains(name))
                .toList();
        return clothes.stream().map(c -> mapper.convertValue(c, ClotheDto.class)).toList();
    }
    /* POST  /api/clothes Crear una nueva prenda.*/

    /* GET /api/clothes  Devolver todas las prendas*/

    /* GET /api/clothes/{code} Devolver una prenda en particular*/

    /*PUT /api/clothes/{code} Actualizar una prenda en particular*/

    /* DELETE /api/clothes/{code] Eliminar una prenda en particular*/

    /* GET /api/clothes/{size} Traer todas las prendas de un determinado talle*/

    /* GET /api/clothes?name=remera Buscar todas las prendas en cuyo nombre aparezca
    la palabra “remera”. No se tienen en cuenta ni mayúsculas ni minúsculas*/

}
