package com.mercadolibre.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.demo.dto.JoyaDTO;
import com.mercadolibre.demo.exception.NotFoundException;
import com.mercadolibre.demo.model.Joya;
import com.mercadolibre.demo.repository.IJoyaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class JoyaService implements IJoyaService
{

    private final IJoyaRepository repository;
    public JoyaService(IJoyaRepository repository){
        this.repository = repository;
    }

  /*Crear una nueva joya y devolver el correspondiente status code con un mensaje
    informando su “nro identificatorio”. (URI: /jewerly/new).
     */

    @Override
    public Long newJewerly(JoyaDTO joyaDto) {
        ObjectMapper mapper = new ObjectMapper();
        Joya joya = mapper.convertValue(joyaDto, Joya.class);
        joya.setVentaONo(true);
        repository.save(joya);
        return joya.getId();
    }


    /*Devolver el listado de todas las joyas registradas. (URI: /jewerly).*/
    @Override
    public List<JoyaDTO> getAllJewerly() {
        ObjectMapper mapper = new ObjectMapper();
        List<JoyaDTO> joyas = repository.findAll().stream()
                .filter(Joya::getVentaONo)
                .map(j -> mapper.convertValue(j, JoyaDTO.class))
                .toList();
        return joyas;
    }
    /*Eliminar “lógicamente” una joya. Para ello, se deberá contemplar un campo que
    se llama “ventaONo”, el cual debe ser verdadero al crear una nueva joya, y falso
    cuando se solicite el eliminado. En caso de estar eliminado lógicamente,
    no deberá ser devuelto en el listado de joyas registradas. (URI: /jewerly/delete/{id})*/

    @Override
    public void deleteJewerly(Long id) {
        Joya joya = repository.findById(id).orElse(null);
        if(!joya.getVentaONo()){
            throw new NotFoundException("Esa joya ya está eliminada.");
        }
        joya.setVentaONo(false);
        repository.save(joya);
    }


     /*Actualizar los datos de una joya. Una vez actualizados, devolver un mensaje
    con el correspondiente status code y los datos de la joya modificada.
     (URI: /jewerly/update/{id_modificar}).
      Envía el objeto completo para editar (sin cambiar la id).*/

    @Override
    public JoyaDTO updateJewerly(Long id, JoyaDTO joya) {
        Joya joyaExistente = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró la joya con el id" + id));
        joyaExistente.setName(joya.getName());
        joyaExistente.setMaterial(joya.getMaterial());
        joyaExistente.setPesoEnGramos(joya.getPesoEnGramos());
        joyaExistente.setParticularidad(joya.getParticularidad());
        joyaExistente.setPoseePiedra(joya.getPoseePiedra());

        Joya joyaActualizada = repository.save(joyaExistente);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(joyaActualizada, JoyaDTO.class);
    }
}
