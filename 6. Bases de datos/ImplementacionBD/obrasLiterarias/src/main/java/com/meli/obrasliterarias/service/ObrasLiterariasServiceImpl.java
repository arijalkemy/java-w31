package com.meli.obrasliterarias.service;

import com.meli.obrasliterarias.model.ObraLiteraria;
import com.meli.obrasliterarias.repository.ObrasLiterariasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObrasLiterariasServiceImpl implements ObrasLiterariasService{

    @Autowired
    private ObrasLiterariasRepository obrasLiterariasRepository;

    @Override
    public String saveObras(List<ObraLiteraria> obraLiteraria) {
        obrasLiterariasRepository.saveAll(obraLiteraria);
        return ("Se guardaron correctamente " + obraLiteraria.size() + " obras.");
    }

    public List<ObraLiteraria> findAll() {
        Iterable<ObraLiteraria> iterable = obrasLiterariasRepository.findAll();
        List<ObraLiteraria> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    @Override
    public List<ObraLiteraria> findByAuthor(String author) {
        List<ObraLiteraria> listaObras = obrasLiterariasRepository.findByAuthorIgnoreCase(author);
        return listaObras;
    }

    @Override
    public List<ObraLiteraria> findByPalabraClave(String palabraClave) {
        List<ObraLiteraria> listaObras = obrasLiterariasRepository.findByTitleContainingIgnoreCase(palabraClave);
        return listaObras;
    }

    @Override
    public List<ObraLiteraria> findTop5ByPaginas() {
        return obrasLiterariasRepository.findAll(PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "pageCount")))
                .getContent();
    }


    @Override
    public List<ObraLiteraria> findByAnoPublicacionBefore(int year) {
        return obrasLiterariasRepository.findByPublicationYearLessThan(year);
    }

    @Override
    public List<ObraLiteraria> findByEditorial(String publisher) {
        return obrasLiterariasRepository.findByPublisherIgnoreCase(publisher);
    }

}
